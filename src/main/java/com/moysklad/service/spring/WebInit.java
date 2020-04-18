package com.moysklad.service.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

//web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    private int maxUploadSizeInMb = 5 * 1024 * 1024;//5 MB


    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        //upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        //register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                maxUploadSizeInMb, maxUploadSizeInMb *  2, maxUploadSizeInMb/2);
        registration.setMultipartConfig(multipartConfigElement);

    }

  /*  private String TMP_FOLDER = "/tmp";
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        ServletRegistration.Dynamic appServlet = sc.addServlet("mvc", new DispatcherServlet(
                new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
        appServlet.setMultipartConfig(multipartConfigElement);
    }*/



    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {DataServiceConfig.class};


}

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};

    }
}
