package com.supinfo.supsale.servlet.advert;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.entity.Advert;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ViewAdvertServlet", urlPatterns = "/view")
public class ViewAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Advert advert = AdvertDAO.getAdvertById(Integer.parseInt(request.getParameter("id")));
            if (advert == null){
                throw new NotFoundException("Advert no found");
            }
            Object userId = request.getSession().getAttribute("userId");
            if (userId != null && userId.equals(advert.getOwner().getId())){
                request.setAttribute("isOwner", true);
            }
            request.setAttribute("advert", advert);
            request.setAttribute("owner", advert.getOwner().getUsername());
            request.getRequestDispatcher("/jsp/viewAdvert.jsp").forward(request, response);
        } catch (Exception e){
            response.sendError(404);
        }
    }
}
