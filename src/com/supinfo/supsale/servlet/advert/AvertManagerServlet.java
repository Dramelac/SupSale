package com.supinfo.supsale.servlet.advert;

import com.supinfo.supsale.DAO.AdvertDAO;
import com.supinfo.supsale.DAO.UserDAO;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AvertManagerServlet",urlPatterns = "/user/advertmanager")
public class AvertManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        request.setAttribute("list", user.getAdverts());
        request.getRequestDispatcher("/jsp/user/advertManager.jsp").forward(request, response);
    }
}
