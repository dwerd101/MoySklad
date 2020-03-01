package com.moysklad.service.connection;

import com.moysklad.service.connection.template.ConnectionDataBase;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionImpl extends HttpServlet implements ConnectionDataBase  {
    Connection connection;
    @Override
    public void connection() {
        try {
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        Properties properties = new Properties();
        properties.load(new FileInputStream(getServletContext().getRealPath("/resources/modelDataBase/properties/db.properties")));
        String name = properties.getProperty("db.username");
        String url = properties.getProperty("db.url");
        String password = properties.getProperty("db.password");
        String driverClazz = properties.getProperty("db.Driver");
        Class.forName(driverClazz);
        driverManagerDataSource.setUsername(name);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setPassword(password);
       connection = driverManagerDataSource.getConnection();
        }
        catch (ClassNotFoundException | SQLException | IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
