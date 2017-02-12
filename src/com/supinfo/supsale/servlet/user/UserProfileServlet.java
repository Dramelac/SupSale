package com.supinfo.supsale.servlet.user;

import com.supinfo.supsale.DAL.UserDAO;
import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UserProfileServlet", urlPatterns = "/user/profile")
public class UserProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("failed", false);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordverif = request.getParameter("check_password");

        if (email.isEmpty()){
            request.setAttribute("failed", true);
            request.setAttribute("message", "Required field is missing.");
            doGet(request, response);
            return;
        }
        if (!SecurityUtils.validateEmailAddress(email)){
            request.setAttribute("failed", true);
            request.setAttribute("message", "E-mail is invalid.");
            doGet(request, response);
            return;
        }
        if (!password.isEmpty() && password.length() < 8){
            request.setAttribute("failed", true);
            request.setAttribute("message", "Password is too weak (< 8).");
            doGet(request, response);
            return;
        }
        if (!password.isEmpty() && !password.equals(passwordverif)){
            request.setAttribute("failed", true);
            request.setAttribute("message", "Password not match.");
            doGet(request, response);
            return;
        }

        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(email);
        user.setAddress(request.getParameter("address"));
        user.setPhonenumber(request.getParameter("phonenumber"));

        if (!password.isEmpty()){
            if (SecurityUtils.checkPassword(request.getParameter("old_password"), user.getPassword())) {
                user.setPassword(SecurityUtils.getHashfromPassword(password));
            } else {
                request.setAttribute("failed", true);
                request.setAttribute("message", "Wrong current password.");
            }
        }

        if (!(boolean) request.getAttribute("failed")) {
            UserDAO.updateUser(user);

            request.setAttribute("success", true);
            request.setAttribute("message", "Profile successfully updated.");
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/jsp/user/profile.jsp").forward(request, response);
    }
}
