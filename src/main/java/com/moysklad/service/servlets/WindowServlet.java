package com.moysklad.service.servlets;

import com.moysklad.dao.domain.ArrivalProductDaoImpl;
import com.moysklad.model.ArrivalOrSaleOfProduct;
import com.moysklad.view.ArrivalProductView;
import com.moysklad.view.MovingProductView;
import com.moysklad.view.SaleProductView;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/window/*")
@MultipartConfig
public class WindowServlet extends HttpServlet {


    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/view/jsp/window.jsp").forward(req, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestPath = request.getRequestURI();
        switch (requestPath) {
            case "/window/":
                doGet(request, response);
                break;
            case "/window/arrival":
                request.getServletContext().getRequestDispatcher("/view/jsp/arrival.jsp").forward(request, response);
                break;
            case  "/window/arrival/view_all_document":
                List<ArrivalProductView> arrivalProducts = new ArrivalProductView().findAllView();
                request.setAttribute("ArrivalProduct", arrivalProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/DbArrivalViewDocument.jsp").forward(request,response);
                break;
            case "/window/sale":
                request.getServletContext().getRequestDispatcher("/view/jsp/sale.jsp").forward(request,response);
                break;
            case "/window/sale/view_all_document":
                List<SaleProductView> saleProducts = new SaleProductView().findAllView();
                request.setAttribute("SaleProduct", saleProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/DbSaleViewDocument.jsp").forward(request,response);
                break;
            case "/window/moving":
                request.getServletContext().getRequestDispatcher("/view/jsp/moving.jsp").forward(request,response);
                break;
            case "/window/moving/view_all_document":
                List<MovingProductView> movingProducts = new MovingProductView().findAllView();
                request.setAttribute("MovingProduct",movingProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/DbMovingViewDocument.jsp").forward(request,response);
                break;
        }
    }


    private void addFilesOnServer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String applicationPath = request.getServletContext().getRealPath("");
        // создает путь к каталогу для сохранения загруженного файла
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        // Создает папку, если она не создана
        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        // Пишет все файлы в загруженную папку
        for (Part part : request.getParts()) {
            if (part != null && part.getSize() > 0) {
                String fileName = part.getSubmittedFileName();
                String contentType = part.getContentType();

                // Загружать только определенный тип. Тест
                if (!contentType.equalsIgnoreCase("json")) {
                    continue;
                }

                part.write(uploadFilePath + File.separator + fileName);


            }
        }
    }
}
