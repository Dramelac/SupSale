package com.supinfo.supsale.servlet.advert;

import com.supinfo.supsale.DAL.UserDAO;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.Categorie;
import com.supinfo.supsale.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@WebServlet(name = "AddAdvertServlet",urlPatterns = "/user/addadvert")
public class AddAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        Advert advert = new Advert();
        advert.setName(request.getParameter("advertname"));
        advert.setImageUrl(request.getParameter("image"));
        advert.setDescription(request.getParameter("description"));
        advert.setCategorie(Categorie.valueOf(request.getParameter("categorie")));
        advert.setPublishDate(new Date());
        advert.setPrice(Integer.parseInt(request.getParameter("price")));
        advert.setOwner(user);
        user.getAdverts().add(advert);
        UserDAO.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/index");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categorieList", Categorie.CategorieList);

        request.getRequestDispatcher("/jsp/user/addadvert.jsp").forward(request, response);
    }
}
