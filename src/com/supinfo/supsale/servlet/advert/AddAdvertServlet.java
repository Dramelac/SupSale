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
import java.io.Console;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AddAdvertServlet",urlPatterns = "/user/addadvert")
public class AddAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        Advert advert = new Advert();
        advert.setName(request.getParameter("advertname"));
        advert.setDescription(request.getParameter("description"));
        advert.setPrice(Integer.parseInt(request.getParameter("price")));
        advert.setOwner(user);
        user.getAdverts().add(advert);
        UserDAO.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addadvert.jsp").forward(request, response);
    }
}
