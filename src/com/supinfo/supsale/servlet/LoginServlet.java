package com.supinfo.supsale.servlet;

import com.supinfo.supsale.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passuser = request.getParameter("password");
        String username = request.getParameter("username");
        String passbdd = UserDAO.getPasswordByName(username);
        if (passbdd.equals(passuser)){
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath()+"/");
        }
        else {
            System.out.print("Wrong password");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
}
