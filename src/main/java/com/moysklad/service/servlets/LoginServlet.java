package com.moysklad.service.servlets;

import com.moysklad.dao.domain.UserCrudDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserCrudDaoImpl userCrudDao = UserCrudDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Получилось");
       /* req.getRequestURI().startsWith("/login");
        resp.sendRedirect("/view/jsp/Login.jsp");*/
        req.getServletContext().getRequestDispatcher("/view/jsp/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Получилось о да");
    }

    protected void checkUserAccount(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (userCrudDao.isExist(name, password)) {
            // создаем для него сессию
            HttpSession session = request.getSession();
            // кладем в атрибуты сессии атрибут user с именем пользователя
            session.setAttribute("user", name);
            // перенаправляем на страницу home
            // req.getServletContext().getRequestDispatcher("/jsp/startPageBox.jsp").forward(req, resp);
            System.out.println("Успешно");
        } else {
            // resp.sendRedirect(req.getContextPath() + "/login");
            System.out.println("нет");
        }
    }

}
