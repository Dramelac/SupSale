package com.supinfo.supsale.servlet.admin;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.entity.Advert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminAdvertServlet",urlPatterns = "/admin/advert")
public class AdminAdvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Advert> advertList = AdvertDAO.getAllAdvertsOrderByPublishDate();
        request.setAttribute("advertList", advertList);
        request.getRequestDispatcher("/jsp/admin/advertlist.jsp").forward(request, response);
    }
}
