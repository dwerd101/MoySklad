package com.moysklad.stockinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = "com.moysklad")
@EnableJpaRepositories(basePackages = "com.moysklad.dao.spring")
@EntityScan(basePackages = "com.moysklad.model")
public class StockInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockInventoryApplication.class, args);
    }

}
