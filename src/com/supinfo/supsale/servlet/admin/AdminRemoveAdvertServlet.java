package com.supinfo.supsale.servlet.admin;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.entity.Advert;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminRemoveAdvertServlet", urlPatterns = "/admin/removeadvert")
public class AdminRemoveAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request ,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Advert advert = AdvertDAO.getAdvertById(Integer.parseInt(request.getParameter("id")));
        AdvertDAO.removeAdvertByAdvert(advert);
        response.sendRedirect(request.getContextPath() + "/admin/advert");
    }
}
