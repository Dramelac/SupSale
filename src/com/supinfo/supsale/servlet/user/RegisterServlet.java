package com.supinfo.supsale.servlet.user;

import com.supinfo.supsale.DAO.UserDAO;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("wrongpassword", false);
        User user = new User();
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPhonenumber(request.getParameter("phonenumber"));
        user.setUsername(request.getParameter("username"));


        if (request.getParameter("password").equals(request.getParameter("passwordverif"))){

            user.setPassword(SecurityUtils.getHashfromPassword(request.getParameter("password")));

            try {
                UserDAO.addUser(user);
                request.getSession().setAttribute("username", user.getUsername());
                request.getSession().setAttribute("userId", user.getId());
                request.getSession().setAttribute("isAdmin", user.isAdmin());
                response.sendRedirect(request.getContextPath() + "/");
            } catch (Exception e) {
                request.setAttribute("failed", true);
                doGet(request, response);
            }
        }
        else {
            request.setAttribute("wrongpassword", true);
            request.setAttribute("message2", "Password not match.");
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }
}
