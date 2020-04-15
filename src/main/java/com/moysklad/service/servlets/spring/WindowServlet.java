package com.moysklad.service.servlets.spring;

import com.moysklad.dao.spring.ArrivalOfProductRepository;
import com.moysklad.model.ArrivalOfProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class WindowServlet {


    @Autowired
    ArrivalOfProductRepository arrivalOfProductRepository;

    @GetMapping("/")
    String view(Model model) {
        List<ArrivalOfProduct> ar = arrivalOfProductRepository.findAll();
        model.addAttribute("arrivalProduct", ar);
        return "DbArrivalViewDocument";
    }

}
