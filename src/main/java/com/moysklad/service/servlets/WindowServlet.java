package com.moysklad.service.servlets;

import com.moysklad.dao.domain.ArrivalProductDaoImpl;
import com.moysklad.dao.domain.DocumentsDao;
import com.moysklad.model.ArrivalOrSaleOfProduct;
import com.moysklad.service.json.Converter;
import com.moysklad.view.ArrivalProductViewImpl;
import com.moysklad.view.GeneralListOfProductViewImpl;
import com.moysklad.view.MovingProductViewImpl;
import com.moysklad.view.SaleProductViewImpl;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
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
    private List<ArrivalOrSaleOfProduct> arrivalOrSaleOfProducts;
    private List<MovingProductViewImpl> movingProductViewImpls;
    private List<GeneralListOfProductViewImpl> generalListOfProductViewImpl;

    private static final String UPLOAD_DIR = "uploads";
    private static final String DOWNLOAD_DIR = "downloads";
    private static final String JSON = "json";
    private DocumentsDao documents;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/view/jsp/Window.jsp").forward(req, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestPath = request.getRequestURI();
        switch (requestPath) {
            case "/window/":
                doGet(request, response);
                break;
            case "/window/arrival":
                arrivalOrSaleOfProducts = null;
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/ArrivalMenu.jsp").forward(request, response);
                break;
            case "/window/arrival/view_all_document":
                List<ArrivalProductViewImpl> arrivalProducts = new ArrivalProductViewImpl().findAllView();
                request.setAttribute("ArrivalProduct", arrivalProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalViewDocument.jsp").forward(request, response);
                break;
            case "/window/arrival/view_all_documents":
                addFilesOnServer(request, response);
                arrivalOrSaleOfProducts = Converter.toJavaObjectList();
                if (arrivalOrSaleOfProducts.isEmpty()) {
                    //Изменить реализацию ошибки, если файл был другой.
                    response.setStatus(HttpServletResponse.SC_CONFLICT);
                } else {
                    request.setAttribute("sentArrivalProduct", arrivalOrSaleOfProducts);
                    request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSent.jsp").forward(request, response);
                }
                break;
            case "/window/arrival/send":
                documents = new ArrivalProductDaoImpl();
                for (ArrivalOrSaleOfProduct product : arrivalOrSaleOfProducts) {
                    documents.save(product);
                }
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSentSuccess.jsp").forward(request, response);
                break;
            case "/window/arrival/sent_document":
                request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/DbArrivalSent.jsp").forward(request, response);

            case "/window/arrival/report_general_list_of_product_success":


                String productName = request.getParameter("productName");
                if (!productName.isEmpty()) {
                    generalListOfProductViewImpl = new GeneralListOfProductViewImpl().findByName(productName);
                    Converter.toJsonListOfProduct(generalListOfProductViewImpl);
                    downloadFileFromServer(request,response, generalListOfProductViewImpl);

                } else {
                     generalListOfProductViewImpl = new GeneralListOfProductViewImpl().findAllView();
                   //  Converter.toJsonListOfProduct(generalListOfProductViewImpl);
                     downloadFileFromServer(request,response, generalListOfProductViewImpl);
                 //    request.getServletContext().getRequestDispatcher("/view/jsp/ArrivalProduct/SuccessReport.jsp").forward(request,response);
                }
                break;

            case "/window/sale":
                request.getServletContext().getRequestDispatcher("/view/jsp/Sale.jsp").forward(request, response);
                break;
            case "/window/sale/view_all_document":
                List<SaleProductViewImpl> saleProducts = new SaleProductViewImpl().findAllView();
                request.setAttribute("SaleProduct", saleProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/DbSaleViewDocument.jsp").forward(request, response);
                break;
            case "/window/moving":
                request.getServletContext().getRequestDispatcher("/view/jsp/Moving.jsp").forward(request, response);
                break;
            case "/window/moving/view_all_document":
                List<MovingProductViewImpl> movingProducts = new MovingProductViewImpl().findAllView();
                request.setAttribute("MovingProduct", movingProducts);
                request.getServletContext().getRequestDispatcher("/view/jsp/DbMovingViewDocument.jsp").forward(request, response);
                break;
        }
    }


    private void addFilesOnServer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String applicationPath = request.getServletContext().getRealPath("");
        // создает путь к каталогу для сохранения загруженного файла
        // Не забудь добавтьь для товара и склад CRUD
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR + File.separator + JSON;
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
                if (!contentType.equalsIgnoreCase("application/json")) {
                    continue;
                }
                part.write(uploadFilePath + File.separator + fileName);
            }
        }
    }

    private void downloadFileFromServer(HttpServletRequest request, HttpServletResponse response, List<GeneralListOfProductViewImpl> list ) throws IOException, ServletException {



        String requestPath = request.getRequestURI();
        switch (requestPath) {
            case "/window/arrival/report_general_list_of_product_success":

                response.setContentType("application/json");
                String applicationPath = request.getServletContext().getRealPath("");
                String downloadFilePath = applicationPath + File.separator + DOWNLOAD_DIR + File.separator + JSON + File.separator;

                File downloadFolder = new File(downloadFilePath);
                if (!downloadFolder.exists()) {
                    downloadFolder.mkdirs();
                }
                Converter.toJsonListOfProduct(list);
                String filepath = downloadFilePath;

                File dir = new File(filepath);
                String[] files = dir.list();
                if (files != null && files.length > 0) {

                    byte[] zip = zipFiles(dir, files);

                    ServletOutputStream sos = response.getOutputStream();
                    response.setContentType("application/zip");
                    response.setHeader("Content-Disposition", "attachment; filename=report.zip");

                    sos.write(zip);
                    sos.flush();
                    break;
                }

        }
    }

    private byte[] zipFiles(File directory, String[] files) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);
        byte bytes[] = new byte[2048];

        for (String fileName : files) {
            FileInputStream fis = new FileInputStream(directory.getPath() +
                    WindowServlet.FILE_SEPARATOR + fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            zos.putNextEntry(new ZipEntry(fileName));

            int bytesRead;
            while ((bytesRead = bis.read(bytes)) != -1) {
                zos.write(bytes, 0, bytesRead);
            }
            zos.closeEntry();
            bis.close();
            fis.close();
        }
        zos.flush();
        baos.flush();
        zos.close();
        baos.close();

        return baos.toByteArray();
    }

}

