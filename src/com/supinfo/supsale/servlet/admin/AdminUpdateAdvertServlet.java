package com.supinfo.supsale.servlet.admin;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.Categorie;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminUpdateAdvertServlet",urlPatterns = "/admin/updateadvert")
public class AdminUpdateAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Advert advert = null;
        int id = Integer.parseInt(request.getParameter("id"));
        advert = AdvertDAO.getAdvertById(Integer.parseInt(request.getParameter("id")));
        advert.setName(request.getParameter("advertname"));
        advert.setImageUrl(request.getParameter("image"));
        advert.setDescription(request.getParameter("description"));
        String cat = request.getParameter("categorie");
        if (!cat.isEmpty()){
            advert.setCategorie(Categorie.valueOf(request.getParameter("categorie")));
        }
        advert.setPrice(Integer.parseInt(request.getParameter("price")));
        AdvertDAO.updateAdvert(advert);

        response.sendRedirect(request.getContextPath() + "/admin/advert");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Advert advert = null;
        advert = AdvertDAO.getAdvertById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("categorieList", Categorie.CategorieList);
        request.setAttribute("advert", advert);
        request.getRequestDispatcher("/jsp/user/updateAdvert.jsp").forward(request, response);
    }
}
