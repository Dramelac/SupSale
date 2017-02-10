package com.supinfo.supsale.servlet.advert;

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


@WebServlet(name = "UpdateAdvertServlet", urlPatterns = "/user/updateadvert")
public class UpdateAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Advert advert = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            advert = AdvertDAO.getAndCheck(id,
                    (int) request.getSession().getAttribute("userId"));
        } catch (NotFoundException e){
            response.sendError(404);
            return;
        } catch (IllegalAccessException e){
            response.sendError(403);
            return;
        }
        advert.setName(request.getParameter("advertname"));
        advert.setImageUrl(request.getParameter("image"));
        advert.setDescription(request.getParameter("description"));
        String cat = request.getParameter("categorie");
        if (!cat.isEmpty()){
            advert.setCategorie(Categorie.valueOf(request.getParameter("categorie")));
        }
        advert.setPrice(Double.parseDouble(request.getParameter("price")));
        AdvertDAO.updateAdvert(advert);

        response.sendRedirect(request.getContextPath() + "/view?id=" + id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Advert advert = null;
        try {
            advert = AdvertDAO.getAndCheck(Integer.parseInt(request.getParameter("id")),
                    (int) request.getSession().getAttribute("userId"));
        } catch (NotFoundException e){
            response.sendError(404);
            return;
        } catch (IllegalAccessException e){
            response.sendError(403);
            return;
        }
        request.setAttribute("categorieList", Categorie.CategorieList);
        request.setAttribute("advert", advert);

        request.getRequestDispatcher("/jsp/user/updateAdvert.jsp").forward(request, response);
    }
}
