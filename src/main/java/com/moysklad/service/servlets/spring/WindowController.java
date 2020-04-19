package com.moysklad.service.servlets.spring;

import com.moysklad.dao.spring.ArrivalOfProductRepository;
import com.moysklad.dao.spring.MovingOfProductRepository;
import com.moysklad.dao.spring.SaleOfProductRepository;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.MovingOfProduct;
import com.moysklad.model.SaleOfProduct;
import com.moysklad.model.interfaceModel.Model;
import com.moysklad.service.json.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WindowController {

    private static final String UPLOAD_DIR = "D:\\IDEA\\apache-tomcat-8.5.50\\temp";
    private static final String JSON = "json";
    @Resource(name = "arrRep")
    ArrivalOfProductRepository arrivalOfProductRepository;
    @Resource(name = "saleRep")
    SaleOfProductRepository saleOfProductRepository;
    @Resource(name = "movingRep")
    MovingOfProductRepository movingOfProductRepository;

    @Autowired
    private List<ArrivalOfProduct> productArList;
    @Autowired
    private List<SaleOfProduct> productSaList;
    @Autowired
    private List<MovingOfProduct> productMoList;

    private List json;


    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    public String mainWindows() {
        return "redirect:/window";
    }

    @RequestMapping(value = "/window", method = {RequestMethod.POST, RequestMethod.GET})
    public String mainWindow() {
        return "window";
    }

    @PostMapping("/window/{product}")
    public String windowProduct(@PathVariable("product") String product) {
        switch (product) {
            case "arrival":
                return "arrivalMenu";
            case "sale":
                return "saleMenu";
            case "moving":
                return "movingMenu";
        }
        return "redirect:/window";
    }

    //Реализовать Template
    @PostMapping("/window/{product}/{template}")
    public String windowProduct(@PathVariable("product") String product, @PathVariable String template, ModelMap map, @RequestParam("fileName1") MultipartFile[] files) {
        switch (product) {
            case "arrival":
                switch (template) {
                    case "view_document":

                        return returnPageViewDocument(productArList, arrivalOfProductRepository, "arrivalViewDocument", map);

                    case "view_all_documents":

                        return uploadFilesOnServerAndReturnPage(files, map, new ArrivalOfProduct(), "arrivalSendConfirm",
                                "arrivalSendConfirm", "sentArrivalProduct");
                    case "send":
                        return sendToDataBaseAndReturnPage(map, arrivalOfProductRepository, "arrivalSendSuccessAndGetFiles",
                                "arrivalSendSuccessAndGetFiles");

                    default:
                        return "redirect:/window";
                }

            case "sale":
                switch (template) {
                    case "view_document":
                        return returnPageViewDocument(productSaList, saleOfProductRepository, "saleViewDocument", map);

                    case "view_all_documents":

                        return uploadFilesOnServerAndReturnPage(files, map, new SaleOfProduct(), "saleSendConfirm",
                                "saleSendConfirm", "sentSaveProduct");
                    case "send":
                        sendToDataBaseAndReturnPage(map,saleOfProductRepository, "saleSendSuccessAndGetFiles",
                                "saleSendSuccessAndGetFiles");
                    default:
                        return "redirect:/window";
                }

            case "moving":
                switch (template) {
                    case "view_document":

                        return returnPageViewDocument(productMoList, movingOfProductRepository, "movingViewDocument", map);

                    case "view_all_documents":

                        return uploadFilesOnServerAndReturnPage(files, map, new MovingOfProduct(), "movingSendConfirm",
                                "movingSendConfirm", "movingSaveProduct");
                    case "send":
                        sendToDataBaseAndReturnPage(map,movingOfProductRepository, "movingSendSuccessAndGetFiles",
                                "movingSendSuccessAndGetFiles" );

                    default:
                        return "redirect:/window";
                }
        }
        return "redirect:/window";
    }


    private String returnPageViewDocument(List productList, JpaRepository a, String page, ModelMap map ){
        productList = a.findAll();
        map.addAttribute("productFromServer", productList);
        return page;
    }
    private String uploadFilesOnServerAndReturnPage(MultipartFile[] files, ModelMap map, Model clazz, String errReturnPage, String successReturnPage,
                                                    String ModelMapAttribute) {
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue;
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());
                Files.write(path, bytes);
            }
            json = Converter.toJavaObjectList(clazz);
            map.addAttribute(ModelMapAttribute, json);
            return successReturnPage;
        } catch (Exception e) {
            return errReturnPage;
        }
    }


    private String sendToDataBaseAndReturnPage(ModelMap map, JpaRepository a, String pageSuccess, String pageError) {
        Object marker = new Object();
        List<Object> root = new ArrayList<>();
        try {
            root.addAll(json);
            a.saveAll(root);
            map.addAttribute("success", marker);
            json.clear();
            return pageSuccess;
        } catch (Exception e) {
            map.addAttribute("success", null);
            json.clear();
            return pageError;
        }
    }




}



  /* Для одного файла

    byte[] bytes = file.getBytes();
    Path path = Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);
    List<Model> json = Converter.toJavaObjectList(request.getRequestURI());
            modelMap.addAttribute("sentArrivalProduct", json);
            return "arrivalSendConfirm";
} catch (AccessDeniedException e) {
        e.printStackTrace();
        return "arrivalSendConfirm";*/



