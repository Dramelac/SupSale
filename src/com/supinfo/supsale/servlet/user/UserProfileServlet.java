package com.supinfo.supsale.servlet.user;

import com.supinfo.supsale.DAO.UserDAO;
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

        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPhonenumber(request.getParameter("phonenumber"));

        String pass = request.getParameter("password");
        if (!pass.isEmpty()) {
            if (!request.getParameter("password").equals(request.getParameter("check_password"))) {
                request.setAttribute("failed", true);
                request.setAttribute("message", "Password not match.");
            } else {
                if (SecurityUtils.checkPassword(request.getParameter("old_password"), user.getPassword())) {
                    user.setPassword(SecurityUtils.getHashfromPassword(pass));
                } else {
                    request.setAttribute("failed", true);
                    request.setAttribute("message", "Wrong current password.");
                }
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
        request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }
}
