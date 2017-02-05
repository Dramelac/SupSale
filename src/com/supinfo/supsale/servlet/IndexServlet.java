package com.supinfo.supsale.servlet;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.DAL.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userCount", UserDAO.getUserCount());
        request.setAttribute("advertCount", AdvertDAO.getAdvertCount());
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
