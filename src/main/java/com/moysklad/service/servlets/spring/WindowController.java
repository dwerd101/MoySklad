package com.moysklad.service.servlets.spring;

import com.moysklad.dao.spring.ArrivalOfProductRepository;
import com.moysklad.dao.spring.MovingOfProductRepository;
import com.moysklad.dao.spring.SaleOfProductRepository;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.MovingOfProduct;
import com.moysklad.model.SaleOfProduct;
import com.moysklad.model.interfaceModel.Model;
import com.moysklad.service.json.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public String windowProduct(@PathVariable("product") String product, @PathVariable String template, ModelMap map, HttpServletRequest request, @RequestParam("fileName1") MultipartFile[] files) {
        switch (product) {
            case "arrival":
                if (template.equals("view_document")) {
                    List<ArrivalOfProduct> arrivalOfProductList = arrivalOfProductRepository.findAll();
                    map.addAttribute("productFromServer", arrivalOfProductList);
                    return "arrivalViewDocument";
                }

                else if(template.equals("view_all_documents")) {
                    String page = "arrivalSendConfirm";
                   return uploadFilesOnServerAndReturnPage(files, map, request, page, page, "sentArrivalProduct" );
                }
                else return "redirect:/window";

            case "sale":
                List<SaleOfProduct> saleOfProductsList = saleOfProductRepository.findAll();
                map.addAttribute("productFromServer", saleOfProductsList);
                return "saleViewDocument";
            case "moving":
                List<MovingOfProduct> movingOfProductsList = movingOfProductRepository.findAll();
                map.addAttribute("productFromServer", movingOfProductsList);
                return "movingViewDocument";
        }
        return "redirect:/window";
    }

    public String uploadFilesOnServerAndReturnPage(MultipartFile[] files, ModelMap map, HttpServletRequest request, String errReturnPage, String successReturnPage, String ModelMapAttribute) {
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue;
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());
                Files.write(path, bytes);
            }
            List<Model> json = Converter.toJavaObjectList(request.getRequestURI());
            map.addAttribute(ModelMapAttribute, json);
            return successReturnPage;
        } catch (Exception e) {
            return errReturnPage;
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



