package com.supinfo.supsale.servlet.advert;

import com.supinfo.supsale.DAL.AdvertDAO;
import com.supinfo.supsale.DAL.UserDAO;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.EmailUtility;
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
        try{
                Advert advert = AdvertDAO.getAdvertById(Integer.parseInt(request.getParameter("id")));

                User senderuser = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
                String recipient = advert.getOwner().getEmail();
                String subject = senderuser.getEmail() + " from SupSale sent you a message";
                String content = request.getParameter("email_content");

                try {
                    EmailUtility.sendEmail(recipient, subject, content);
                    request.setAttribute("message_mail", "The e-mail was sent successfully");
                    request.setAttribute("success_mail", true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message_mail", "There were an error.");
                    request.setAttribute("failed_mail", true);
                } finally {
                    getServletContext().getRequestDispatcher("/jsp/viewAdvert.jsp").forward(request, response);
                }
        } catch (Exception e){
            response.sendError(404);
        }
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
            request.setAttribute("owner", advert.getOwner());
            request.getRequestDispatcher("/jsp/viewAdvert.jsp").forward(request, response);
        } catch (Exception e){
            response.sendError(404);
        }
    }
}
