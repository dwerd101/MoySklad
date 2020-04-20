package com.moysklad.service.spring;

import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.MovingOfProduct;
import com.moysklad.model.SaleOfProduct;
import com.moysklad.view.interfaceView.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.moysklad")
public class ListConfig {


    @Bean
    public List<ArrivalOfProduct> arrivalOfProducts() {
        return new ArrayList<>();
    }
    @Bean
    public List<SaleOfProduct> saleOfProducts() {
        return new ArrayList<>();
    }
    @Bean
    public List<MovingOfProduct> movingOfProducts() {
        return new ArrayList<>();
    }
    @Bean
    public List<View> views() {
        return new ArrayList<>();
    }


}
