package com.supinfo.supsale.servlet.advert;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.entity.Advert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SearchTextServlet", urlPatterns = "/search")
public class SearchTextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("q");
        List<Advert> result = AdvertDAO.searchFullText(txt);
        request.setAttribute("resultList", result);
        request.setAttribute("filter", txt);

        request.getRequestDispatcher("/jsp/searchResult.jsp").forward(request, response);
    }
}
