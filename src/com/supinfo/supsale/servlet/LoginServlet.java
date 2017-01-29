package com.supinfo.supsale.servlet;

import com.supinfo.supsale.DAO.UserDAO;
import com.supinfo.supsale.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String passbdd = UserDAO.getPasswordByName(username);

        if (SecurityUtils.checkPassworc(request.getParameter("password"), passbdd)){
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath()+"/");
        }
        else {
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
}
