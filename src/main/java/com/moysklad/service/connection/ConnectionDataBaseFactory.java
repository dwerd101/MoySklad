package com.moysklad.service.connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDataBaseFactory {
    public static Connection getConnection() throws SQLException {
        return SingletonHelper.INSTANCE.dataSource.getConnection();
    }

    private final DataSource dataSource;

         ConnectionDataBaseFactory() {
                DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
                Properties properties = new Properties();
                FileInputStream fis = null;
                try {
                        fis = new FileInputStream("src/main/resources/modelDataBase/properties/db.properties");
                        properties.load(fis);
                        String name = properties.getProperty("db.username");
                        String url = properties.getProperty("db.url");
                        String password = properties.getProperty("db.password");
                        driverManagerDataSource.setUsername(name);
                        driverManagerDataSource.setUrl(url);
                        driverManagerDataSource.setPassword(password);

                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                assert fis != null;
                                fis.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
             this.dataSource = driverManagerDataSource;
        }
        private static class SingletonHelper
        {
            private static final ConnectionDataBaseFactory INSTANCE = new ConnectionDataBaseFactory();
        }
}
