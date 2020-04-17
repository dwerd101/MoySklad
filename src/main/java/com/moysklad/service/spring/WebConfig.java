package com.moysklad.service.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

//DispatcherServlet
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.moysklad")
public class WebConfig implements WebMvcConfigurer {
    //<mvc:resources ... />
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      /*  registry.addResourceHandler("/resources/**").addResourceLocations("/").setCachePeriod(31556926);*/
        registry.addResourceHandler("/styles/styles.css").addResourceLocations("/styles").setCachePeriod(31556926);
    }


    // Для Jsp.
 /*   @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/view/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setRequestContextAttribute("requestContext");
        return viewResolver;
    }*/



    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
        freemarkerConfig.setTemplateLoaderPath("/view/freemarker");
        freemarkerConfig.setDefaultEncoding("UTF-8");
        return freemarkerConfig;
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(false);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html; charset=utf-8");
        return viewResolver;
    }



    /*
    @Bean
    ViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setSuffix(".ftl");
        return freeMarkerViewResolver;

    }*/


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(themeChangeInterceptor());

    }

   /* @Bean
    public FreeMarkerConfigurer freeMarkerConfig() throws IOException, TemplateException {

           // freemarker.template.Configuration.VERSION_2_3_29
        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPath("classpath:freemarker");
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
            freeMarkerConfigurer.setConfiguration(factory.createConfiguration());
            return freeMarkerConfigurer;
    }*/

    @Bean
    ThemeChangeInterceptor themeChangeInterceptor() {
        return new ThemeChangeInterceptor();
    }

    @Bean
    ResourceBundleThemeSource themeSource() {
        return new ResourceBundleThemeSource();
    }
}
