package com.moysklad.service.servlets;

import com.moysklad.dao.domain.UserCrudDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/**")
public class MainServlet extends HttpServlet {
    //Создать отдельный контроллер для сервлетов

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getServletPath();
       if(action.equals(""))
       {
           resp.sendRedirect("/login");
       }
     /*  switch (action) {
           case "":
               resp.sendRedirect("/login");
              // req.getServletContext().getRequestDispatcher("/login").forward(req,resp);
             //  req.getServletContext().getRequestDispatcher("/view/jsp/Login.jsp").forward(req,resp);
               break;
       }*/

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}