package com.moysklad.service.connection.template;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public interface ConnectionDataBase{
    Connection getConnection() throws SQLException;
}
