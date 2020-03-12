package com.moysklad.service.servlets;

import com.moysklad.dao.domain.ArrivalProductDaoImpl;
import com.moysklad.dao.domain.MovingProductDaoImpl;
import com.moysklad.dao.domain.SaleProductDaoImpl;
import com.moysklad.dao.domain.documentsDao.DocumentsArrivalDao;
import com.moysklad.dao.domain.documentsDao.DocumentsMovingDao;
import com.moysklad.dao.domain.documentsDao.DocumentsSaleDao;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.MovingOfProduct;
import com.moysklad.model.SaleOfProduct;
import com.moysklad.model.interfaceModel.Model;
import com.moysklad.service.folder.Folder;
import com.moysklad.service.json.Converter;
import com.moysklad.service.zip.ZipArchive;
import com.moysklad.view.*;
import com.moysklad.view.interfaceView.View;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "MainWindowServlet", urlPatterns = { "/window/*" })
@MultipartConfig
public class WindowServlet extends HttpServlet {

    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private List<Model> productList;
    private List<View> reports;


    private static final String UPLOAD_DIR = "uploads";
    private static final String DOWNLOAD_DIR = "downloads";
    private static final String JSON = "json";

    private DocumentsArrivalDao documentsArrivalDao;
    private DocumentsSaleDao documentsSaleDao;
    private DocumentsMovingDao documentsMovingDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/view/html/Window.html").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestPath = request.getRequestURI();
        switch (requestPath) {
            case "/window/":
                doGet(request, response);
                break;
            case "/window/arrival":
            case "/window/sale":
            case "/window/moving":
                modelMenu(request, response, requestPath);
                break;
            case "/window/arrival/view_document":
            case "/window/sale/view_document":
            case "/window/moving/view_document":
                viewDocument(request, response, requestPath);
                break;
            case "/window/arrival/view_all_documents":
            case "/window/sale/view_all_documents":
            case "/window/moving/view_all_documents":
                viewAllDocuments(request, response, requestPath);
                break;
            case "/window/arrival/send":
            case "/window/sale/send":
            case "/window/moving/send":
                sendJsonToDataBase(request, response, requestPath);
                break;
            case "/window/arrival/send_document":
            case "/window/sale/send_document":
            case "/window/moving/send_document":
                sentDocument(request, response, requestPath);
            case "/window/arrival/send/report_general_list_of_product_error":
            case "/window/sale/send/report_general_list_of_product_error":
            case "/window/moving/send/report_general_list_of_product_error":
            case "/window/arrival/send/report_stock_balances_error":
            case "/window/sale/send/report_stock_balances_error":
            case "/window/moving/send/report_stock_balances_error":
                getReports(request, response, requestPath);
                break;
            case "/window/arrival/send/report":
            case "/window/sale/send/report":
            case "/window/moving/send/report":
                getReports(request, response, requestPath);
                break;
        }
    }





    private void modelMenu(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {
        switch (requestPath) {
            case "/window/arrival":
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalMenu.html").forward(request, response);
                break;
            case "/window/sale":
                request.getServletContext().getRequestDispatcher("/view/html/SaleProduct/SaleMenu.html").forward(request,response);
            case "/window/moving":
                request.getServletContext().getRequestDispatcher("/view/html/MovingProduct/MovingMenu.html").forward(request,response);
        }
    }

    private void viewDocument(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {
        switch (requestPath) {
            case "/window/arrival/view_document":
                List<View> viewDoc = new ArrivalProductViewImpl().findAllView();
                request.setAttribute("arrivalProduct", viewDoc);
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalViewDocument.jsp").forward(request, response);
                break;
            case "/window/sale/view_document":
                viewDoc = new SaleProductViewImpl().findAllView();
                request.setAttribute("saleProduct", viewDoc);
                request.getServletContext().getRequestDispatcher("/view/jsp/SaleProduct/DbSaleViewDocument.jsp").forward(request, response);
                break;
            case "/window/moving/view_document":
                viewDoc = new MovingProductViewImpl().findAllView();
                request.setAttribute("movingProduct", viewDoc);
                request.getServletContext().getRequestDispatcher("/view/jsp/MovingProduct/DbMovingViewDocument.jsp").forward(request, response);
                break;
        }

    }

    private void viewAllDocuments(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {

        switch (requestPath) {
            case "/window/arrival/view_all_documents":
                addFilesOnServer(request);
                this.productList = Converter.toJavaObjectList(requestPath);
                if (this.productList == null) {
                    request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalMenuError.html").forward(request, response);
                } else if (this.productList.isEmpty()) {
                    request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalMenuError.html").forward(request, response);
                } else {
                    request.setAttribute("sentArrivalProduct", this.productList);
                    request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSend.jsp").forward(request, response);
                }
                break;
            case "/window/sale/view_all_documents":
                addFilesOnServer(request);
                this.productList = Converter.toJavaObjectList(requestPath);
                if (this.productList == null) {
                    request.getServletContext().getRequestDispatcher("/view/html/SaleProduct/SaleMenuError.html").forward(request, response);
                } else if ( this.productList.isEmpty()) {
                    request.getServletContext().getRequestDispatcher("/view/html/SaleProduct/SaleMenuError.html").forward(request, response);
                } else {
                    request.setAttribute("sentSaleProduct",  this.productList);
                    request.getServletContext().getRequestDispatcher("/view/jsp/SaleProduct/DbSaleSend.jsp").forward(request, response);
                }
                break;
            case "/window/moving/view_all_documents":
                addFilesOnServer(request);
                this.productList = Converter.toJavaObjectList(requestPath);
                if (this.productList == null) {
                    request.getServletContext().getRequestDispatcher("/view/html/MovingProduct/MovingMenuError.html").forward(request, response);
                } else if ( this.productList.isEmpty()) {
                    request.getServletContext().getRequestDispatcher("/view/html/MovingProduct/MovingMenuError.html").forward(request, response);
                } else {
                    request.setAttribute("sentMovingProduct",  this.productList);
                    request.getServletContext().getRequestDispatcher("/view/jsp/MovingProduct/DbMovingSend.jsp").forward(request, response);
                }
                break;
        }

    }

    private void sendJsonToDataBase(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {

        switch (requestPath) {
            case "/window/arrival/send":
                documentsArrivalDao = new ArrivalProductDaoImpl();
                for (Model product : productList) {
                    documentsArrivalDao.save((ArrivalOfProduct) product);
                }
                if (documentsArrivalDao.isCheckException()) {
                    request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalErrorSendToDb.html").forward(request, response);
                }
                else request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/DbArrivalSentSuccess.html").forward(request, response);
                break;
            case "/window/sale/send":
                documentsSaleDao = new SaleProductDaoImpl();
                for (Model product : productList) {
                    documentsSaleDao.save((SaleOfProduct) product);
                }
                if (documentsSaleDao.isCheckException()) {
                    request.getServletContext().getRequestDispatcher("/view/html/SaleProduct/SaleErrorSendToDb.html").forward(request, response);
                }
               else request.getServletContext().getRequestDispatcher("/view/html/SaleProduct/DbSaleSentSuccess.html").forward(request, response);
                break;


            case "/window/moving/send":
                documentsMovingDao = new MovingProductDaoImpl();
                for (Model product : productList) {
                    documentsMovingDao.save((MovingOfProduct) product);
                }
                if (documentsMovingDao.isCheckException()) {
                    request.getServletContext().getRequestDispatcher("/view/html/MovingProduct/MovingErrorSendToDb.html").forward(request, response);
                }
              else request.getServletContext().getRequestDispatcher("/view/html/MovingProduct/DbMovingSentSuccess.html").forward(request, response);
                break;
        }
    }

    private void sentDocument(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {
        switch (requestPath) {
            case "/window/arrival/send_document":
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSend.jsp").forward(request, response);
                break;
            case "/window/sale/send_document":
                request.getServletContext().getRequestDispatcher("/view/jsp/SaleProduct/DbSaleSend.jsp").forward(request, response);
                break;
            case "/window/moving/send_document":
                request.getServletContext().getRequestDispatcher("/view/jsp/MovingProduct/DbMovingSend.jsp").forward(request, response);
                break;
        }

    }

    private void getReports(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {

        switch (requestPath) {
            case "/window/arrival/send/report_general_list_of_product_error":
                request.setCharacterEncoding("UTF-8");
                String nameListArrival = request.getParameter("productName");
                if (nameListArrival.isEmpty()) {
                    reports = new GeneralListOfProductViewImpl().findAllView();
                    downloadFileFromServer(request, response, reports);
                } else {
                    reports = new GeneralListOfProductViewImpl().findByName(nameListArrival);
                    if (reports.size() == 0) {
                        request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/ErrorList.jsp").forward(request, response);
                    } else {
                        downloadFileFromServer(request, response, reports);
                    }
                }
                break;
            case "/window/arrival/send/report_stock_balances_error":
                request.setCharacterEncoding("UTF-8");
                String nameStockArrival = request.getParameter("stockName");
                if (nameStockArrival.isEmpty()) {
                    reports = new StockBalancesViewImpl().findAllView();
                    downloadFileFromServer(request, response, reports);
                } else {
                    reports = new StockBalancesViewImpl().findByName(nameStockArrival);
                    if (reports.size() == 0) {
                        request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/ErrorList.jsp").forward(request, response);
                    } else {
                        downloadFileFromServer(request, response, reports);
                    }
                }
                break;
            case "/window/arrival/send/report":
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/DbArrivalSentSuccess.html").forward(request, response);
                break;


            case "/window/sale/send/report_general_list_of_product_error":
                request.setCharacterEncoding("UTF-8");
                String nameSale = request.getParameter("productName");
                if (nameSale.isEmpty()) {
                    reports = new GeneralListOfProductViewImpl().findAllView();
                    downloadFileFromServer(request, response, reports);
                } else {
                    reports = new GeneralListOfProductViewImpl().findByName(nameSale);
                    if (reports.size() == 0) {
                        request.getServletContext().getRequestDispatcher("/view/jsp/SaleProduct/ErrorList.jsp").forward(request, response);
                    } else {
                        downloadFileFromServer(request, response, reports);
                    }
                }
                break;
            case "/window/sale/send/report_stock_balances_error":
                request.setCharacterEncoding("UTF-8");
                String nameStockSale = request.getParameter("stockName");
                if (nameStockSale.isEmpty()) {
                    reports = new StockBalancesViewImpl().findAllView();
                    downloadFileFromServer(request, response, reports);
                } else {
                    reports = new StockBalancesViewImpl().findByName(nameStockSale);
                    if (reports.size() == 0) {
                        request.getServletContext().getRequestDispatcher("/view/jsp/SaleProduct/ErrorList.jsp").forward(request, response);
                    } else {
                        downloadFileFromServer(request, response, reports);
                    }
                }
                break;
            case "/window/sale/send/report":
                request.getServletContext().getRequestDispatcher("/view/html/SaleProduct/DbSaleSentSuccess.html").forward(request, response);
                break;


            case "/window/moving/send/report_general_list_of_product_error":
                request.setCharacterEncoding("UTF-8");
                String nameMoving = request.getParameter("productName");
                if (nameMoving.isEmpty()) {
                    reports = new GeneralListOfProductViewImpl().findAllView();
                    downloadFileFromServer(request, response, reports);
                } else {
                    reports = new GeneralListOfProductViewImpl().findByName(nameMoving);
                    if (reports.size() == 0) {
                        request.getServletContext().getRequestDispatcher("/view/jsp/MovingProduct/ErrorList.jsp").forward(request, response);
                    } else {
                        downloadFileFromServer(request, response, reports);
                    }
                }
                break;
            case "/window/moving/send/report_stock_balances_error":
                request.setCharacterEncoding("UTF-8");
                String nameStockMoving = request.getParameter("stockName");
                if (nameStockMoving.isEmpty()) {
                    reports = new StockBalancesViewImpl().findAllView();
                    downloadFileFromServer(request, response, reports);
                } else {
                    reports = new StockBalancesViewImpl().findByName(nameStockMoving);
                    if (reports.size() == 0) {
                        request.getServletContext().getRequestDispatcher("/view/jsp/MovingProduct/ErrorList.jsp").forward(request, response);
                    } else {
                        downloadFileFromServer(request, response, reports);
                    }
                }
                break;
            case "/window/moving/send/report":
                request.getServletContext().getRequestDispatcher("/view/html/MovingProduct/DbMovingSentSuccess.html").forward(request, response);
                break;
        }

    }

    private void addFilesOnServer(HttpServletRequest request) throws IOException, ServletException {
        String applicationPath = request.getServletContext().getRealPath("");
        Folder folder = new Folder();
        folder.createFolder(applicationPath, UPLOAD_DIR, JSON);
        String uploadFilePath = folder.getFolderString(applicationPath, UPLOAD_DIR, JSON);
        for (Part part : request.getParts()) {
            if (part != null && part.getSize() > 0) {
                String fileName = part.getSubmittedFileName();
                String contentType = part.getContentType();
                if (!contentType.equalsIgnoreCase("application/json")) {
                    continue;
                }
                part.write(uploadFilePath + File.separator + fileName);
            }
        }
    }

    private void downloadFileFromServer(HttpServletRequest request, HttpServletResponse response, List<View> productList) throws IOException {
        response.setContentType("application/json");
        String applicationPath = request.getServletContext().getRealPath("");
        Folder folder = new Folder();
        folder.createFolder(applicationPath, DOWNLOAD_DIR, JSON);
        folder.deleteListFolder(applicationPath, DOWNLOAD_DIR, JSON);
        Converter.toJsonListOfProduct(productList);
        String[] files = folder.getFilesInDir(applicationPath, DOWNLOAD_DIR, JSON);
        File dir = folder.getFolder(applicationPath, DOWNLOAD_DIR, JSON);
        if (files != null && files.length > 0) {

            byte[] zip = new ZipArchive().zipFiles(dir, files);
            ServletOutputStream sos = response.getOutputStream();
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=report.zip");
            sos.write(zip);
            sos.flush();

        }
    }
}

