package com.moysklad.service.servlets;

import com.moysklad.dao.domain.documentsDao.UserAccountDao;
import com.moysklad.dao.domain.UserCrudDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Home", value = "")
public class MainLoginServlet extends HttpServlet {

    private UserAccountDao userAccount;
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardLogin(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardLogin(req, resp);
    }

    private void forwardLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        userAccount = new UserCrudDaoImpl();
        String name = req.getParameter("Login");
        String password = req.getParameter("password");
        Cookie cookie = new Cookie("Login", "yes");
        Cookie[] cookies = req.getCookies();
        int countCookie = 0;
        if (cookies != null) {
            for (Cookie c : cookies
            ) {
                if (c.getName().equals("Login") && session!=null) {
                    resp.sendRedirect(req.getContextPath()+"/window/");
                    countCookie++;
                return;
            }
            }
        }
        try {
            if (name != null && password != null) {
                if (userAccount.isExist(name, password)) {
                    session = req.getSession();
                    session.setAttribute("userAccount", name);
                    resp.addCookie(cookie);
                    resp.sendRedirect(req.getContextPath()+"/window/");
                } else {
                    req.getServletContext().getRequestDispatcher("/view/html/Login.html").forward(req, resp);
                }
            } else if (countCookie == 0 && session.getAttribute("userAccount") != null) {
                HttpSession session = req.getSession();
                session.removeAttribute("userAccount");
                req.getServletContext().getRequestDispatcher("/view/html/Login.html").forward(req, resp);
            } else req.getServletContext().getRequestDispatcher("/view/html/Login.html").forward(req, resp);
        } catch (NullPointerException e) {
            req.getServletContext().getRequestDispatcher("/view/html/Login.html").forward(req, resp);
        }
    }
}