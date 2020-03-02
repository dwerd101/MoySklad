package com.moysklad.service.connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.moysklad.service.connection.template.ConnectionDataBase;

public class ConnectionImpl extends HttpServlet implements ConnectionDataBase {

    @Override
    public Connection getConnection() {
        try {
            Connection connection;
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
            return connection = driverManagerDataSource.getConnection();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
