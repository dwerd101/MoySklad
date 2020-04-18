package com.moysklad.service.servlets.spring;

import com.moysklad.dao.spring.ArrivalOfProductRepository;
import com.moysklad.dao.spring.MovingOfProductRepository;
import com.moysklad.dao.spring.SaleOfProductRepository;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.MovingOfProduct;
import com.moysklad.model.SaleOfProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class WindowController {


    @Resource(name = "arrRep")
    ArrivalOfProductRepository arrivalOfProductRepository;
    @Resource(name = "saleRep")
    SaleOfProductRepository saleOfProductRepository;
    @Resource(name = "movingRep")
    MovingOfProductRepository movingOfProductRepository;

    @RequestMapping(value = "/**", method = { RequestMethod.GET, RequestMethod.POST})
    public String mainWindows() {
        return "redirect:/window";
    }

    @RequestMapping(value = "/window", method = { RequestMethod.POST, RequestMethod.GET })
   public String mainWindow() {
        return "window";
    }

    @PostMapping("/window/{product}")
    public String windowProduct(@PathVariable("product") String product) {
        switch (product){
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
    public String windowProduct(@PathVariable("product") String product, @PathVariable String template, ModelMap map) {
        switch (product){
            case "arrival":
                    List<ArrivalOfProduct> arrivalOfProductList = arrivalOfProductRepository.findAll();
                    map.addAttribute("productFromServer", arrivalOfProductList);
                    return "arrivalViewDocument";
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


  /*  @GetMapping("/f")
    String view(Model model) {
        List<ArrivalOfProduct> ar = arrivalOfProductRepository.findAll();
        model.addAttribute("arrivalProduct", ar);
        return "DbArrivalViewDocument";
    }*/


}
