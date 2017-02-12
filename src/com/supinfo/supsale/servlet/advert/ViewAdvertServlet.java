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
                String host = "smtp.gmail.com";
                String port = "587";
                String user = "Supsaleproject@gmail.com";
                String pass = "<InsertPassword>";
                String recipient = advert.getOwner().getEmail();
                String subject = senderuser.getEmail() + " from SupSale sent you a message";
                String content = request.getParameter("email_content");

                String resultMessage = "";

                try {
                    EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                            content);
                    resultMessage = "The e-mail was sent successfully";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    resultMessage = "There were an error: " + ex.getMessage();
                } finally {
                    request.setAttribute("Message", resultMessage);
                    getServletContext().getRequestDispatcher("/jsp/emailResult.jsp").forward(request, response);
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
