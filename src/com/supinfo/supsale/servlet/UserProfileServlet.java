package com.supinfo.supsale.servlet;

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
        User user = UserDAO.getUserByName(request.getSession().getAttribute("username").toString());
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPhonenumber(request.getParameter("phonenumber"));

        String pass = request.getParameter("password");
        if (!pass.isEmpty()){
            user.setPassword(SecurityUtils.getHashfromPassword(pass));
        }

        UserDAO.updateUser(user);

        request.setAttribute("result", true);

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserByName(request.getSession().getAttribute("username").toString());
        request.setAttribute("user", user);
        request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }
}
