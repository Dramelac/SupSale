package com.supinfo.supsale.servlet.advert;

import com.supinfo.supsale.DAO.AdvertDAO;
import com.supinfo.supsale.entity.Advert;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveAdvertServlet", urlPatterns = "/user/removeadvert")
public class RemoveAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Advert advert = AdvertDAO.getAdvertById(Integer.parseInt(request.getParameter("id")));
            if (advert == null){
                throw new NotFoundException("Advert no found");
            } else if (advert.getOwner().getId() != (int) request.getSession().getAttribute("userId")){
                response.sendError(403);
                return;
            }
            AdvertDAO.removeAdvertByAdvert(advert);
            response.sendRedirect(request.getContextPath() + "/user/advertmanager");
        } catch (NotFoundException e){
            response.sendError(404);
        }
    }
}
