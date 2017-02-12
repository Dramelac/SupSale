package com.supinfo.supsale.servlet.admin;

import com.supinfo.supsale.DAL.UserDAO;
import com.supinfo.supsale.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetAdminServlet", urlPatterns = "/admin/setadmin")
public class SetAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
        User user = UserDAO.getUserById(id);
        user.setAdmin(isAdmin);
        UserDAO.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/admin/users");
    }
}
