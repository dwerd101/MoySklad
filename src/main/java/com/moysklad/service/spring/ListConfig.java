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

 /*   @Autowired
    private Environment env;

    @Bean("dataSourceJdbc")
    public DataSource dataSource() {
        try {
            //  BasicDataSource dataSource = new BasicDataSource();
            DriverManagerDataSource dataSource = new DriverManagerDataSource();

            dataSource.setDriverClassName((env.getProperty("db.driver")));
            dataSource.setUrl(env.getProperty("db.url"));
            dataSource.setUsername(env.getProperty("db.username"));
            dataSource.setPassword(env.getProperty("db.password"));
            return dataSource;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

 /*   @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }*/
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
