package com.moysklad.service.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/login")) {
            String replace = requestURI.replace("/", "/login");
        //    String toReplace = requestURI.substring(requestURI.indexOf("/Dir_My_App"), requestURI.lastIndexOf("/") + 0);
          //  String newURI = requestURI.replace(toReplace, "?Contact_Id=");
            req.getRequestDispatcher(replace).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
