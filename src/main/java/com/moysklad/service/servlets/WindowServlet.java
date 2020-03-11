package com.moysklad.service.servlets;

import com.moysklad.dao.domain.ArrivalProductDaoImpl;
import com.moysklad.dao.domain.documentsDao.DocumentsArrivalDao;
import com.moysklad.model.ArrivalOfProduct;
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

@WebServlet(name = "MainWindowServlet", urlPatterns = { "/window/*" }, loadOnStartup = 1)
@MultipartConfig
public class WindowServlet extends HttpServlet {

    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private List<Model> productList;
    private List<MovingProductViewImpl> movingProductViewImpls;
    private List<View> reports;
    private List<View> viewDoc;

    private static final String UPLOAD_DIR = "uploads";
    private static final String DOWNLOAD_DIR = "downloads";
    private static final String JSON = "json";
    private DocumentsArrivalDao arrivalDocumentsDao;

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
                modelMenu(productList, request, response, requestPath);
                break;
            case "/window/arrival/view_document":
                viewDocument(viewDoc, request, response, requestPath);
                break;
            case "/window/arrival/view_all_documents":
                viewAllDocuments(productList,request,response,requestPath);
                break;
            case "/window/arrival/send":
                sendJsonToDataBase(request, response, requestPath);
                break;
            case "/window/arrival/send_document":
               sentDocument(request,response, requestPath);
                case "/window/arrival/send/report_general_list_of_product":
                    String name = request.getParameter("productName");

                   // request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/DbArrivalSentSuccess.html").forward(request, response);
                    if(name.isEmpty()) {
                        reports = new GeneralListOfProductViewImpl().findAllView();
                        request.setAttribute("reports", reports);
                        downloadFileFromServer(request, response, reports);
                      //  request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DB.jsp").forward(request, response);
                      //  downloadFileFromServer(request, response, reports);

                      //  response.sendRedirect(request.getContextPath()+"/arrival/send");
                       // request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ReportSucces.html").forward(request, response);
                    }
                    else {
                        reports = new GeneralListOfProductViewImpl().findByName(name);
                        if(reports.size()==0) {
                            request.setAttribute("reports", reports);
                            downloadFileFromServer(request, response, reports);
                            ///Должные вставить метод в
                            request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ErrorListProduct.html").forward(request, response);

                        }
                        else if(reports.size()>0) {
                            Converter.toJsonListOfProduct(reports);
                            request.setAttribute("reports", reports);
                            downloadFileFromServer(request, response, reports);
                          //  request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DB.jsp").forward(request, response);

                          //  response.sendRedirect(request.getContextPath()+"/window/arrival/send");
                        //    request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DB.jsp").forward(request, response);
                            //request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ReportSuccess.html").forward(request, response);

                        }
                       // request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DB.jsp").forward(request, response);

                    }
                   // request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DB.jsp");

                    break;
            case "/window/arrival/send/report_general_list_of_product/error":
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/DbArrivalSentSuccess.html").forward(request, response);

                break;
            case "window/arrival/report_general_list_of_product_parameter_success":
            case "window/arrival/report_general_list_of_product_parameter_fail":
                break;

            case "/window/sale":
              //  request.getServletContext().getRequestDispatcher("/view/html/Sale.html").forward(request, response);
                break;
            case "/window/sale/view_all_document":
                List<View> saleProducts = new SaleProductViewImpl().findAllView();
                request.setAttribute("SaleProduct", saleProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/SaleProduct/DbSaleViewDocument.jsp").forward(request, response);
                break;
            case "/window/moving":
                request.getServletContext().getRequestDispatcher("/view/html/Moving.html").forward(request, response);
                break;
            case "/window/moving/view_all_document":
                List<View> movingProducts = new MovingProductViewImpl().findAllView();
                request.setAttribute("MovingProduct", movingProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp//MovingProduct/DbMovingViewDocument.jsp").forward(request, response);
                break;
        }
    }





    private void modelMenu(List<Model> productList, HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {
        productList = null;
        switch (requestPath) {
            case "/window/arrival":
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalMenu.html").forward(request, response);
                break;

        }
    }

    private void viewDocument(List<View> viewDoc, HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {
        switch (requestPath) {
            case "/window/arrival/view_document":
                viewDoc = new ArrivalProductViewImpl().findAllView();
                request.setAttribute("ArrivalProduct", viewDoc);
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalViewDocument.jsp").forward(request, response);
                break;
        }
    }

    private void viewAllDocuments(List<Model> productList, HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {

        switch (requestPath) {
            case "/window/arrival/view_all_documents":
            addFilesOnServer(request, response);
            this.productList = Converter.toJavaObjectList(requestPath);
            if (this.productList == null) {
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalMenuError.html").forward(request, response);
            } else if ( this.productList.isEmpty()) {
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/ArrivalMenuError.html").forward(request, response);
            } else {
                request.setAttribute("sentArrivalProduct",  this.productList);
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSend.jsp").forward(request, response);
            }
            break;
        }
    }

    private void sendJsonToDataBase(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {

        switch (requestPath) {
            case "/window/arrival/send":
                arrivalDocumentsDao = new ArrivalProductDaoImpl();
                for (Model product : productList) {
                    arrivalDocumentsDao.save((ArrivalOfProduct) product);
                }
                request.getServletContext().getRequestDispatcher("/view/html/ArrivalProduct/DbArrivalSentSuccess.html").forward(request, response);
              //  response.sendRedirect(requestPath+"/report_general_list_of_product");
               // request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DB.jsp").forward(request, response);
                break;
        }
    }

    private void sentDocument(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {
        switch (requestPath) {
            case "/window/arrival/send_document":
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSend.jsp").forward(request, response);
                break;
        }
    }

    private void getReports(HttpServletRequest request, HttpServletResponse response, String requestPath) throws  ServletException, IOException {


    }

    private void addFilesOnServer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

    private void downloadFileFromServer(HttpServletRequest request, HttpServletResponse response, List<View> productList) throws IOException, ServletException {
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

      ///  response.sendRedirect(request.getContextPath()+"/window/");
    }
}

