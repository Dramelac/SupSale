package com.supinfo.supsale.filter;

import com.supinfo.supsale.DAL.UserDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Object userId = request.getSession().getAttribute("userId");
        if (userId != null){
            request.getSession().setAttribute("isAdmin", UserDAO.getUserById((Integer) userId).isAdmin());
        }

        if (request.getSession().getAttribute("isAdmin") == null || !(boolean) request.getSession().getAttribute("isAdmin")) {
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
