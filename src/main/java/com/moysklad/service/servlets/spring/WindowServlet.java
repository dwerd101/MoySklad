package com.moysklad.service.servlets.spring;

import com.moysklad.dao.spring.ArrivalOfProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller

public class WindowServlet {


    @Resource(name = "arrRep")
    ArrivalOfProductRepository arrivalOfProductRepository;


    @GetMapping("/")
   public String mainWindow() {
        return "window";
    }

  /*  @GetMapping("/f")
    String view(Model model) {
        List<ArrivalOfProduct> ar = arrivalOfProductRepository.findAll();
        model.addAttribute("arrivalProduct", ar);
        return "DbArrivalViewDocument";
    }*/


}
