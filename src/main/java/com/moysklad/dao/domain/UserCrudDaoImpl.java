package com.moysklad.dao.domain;

import com.moySklad.dao.domain.UserAccountDao;
import com.moysklad.dao.CrudDao;
import com.moysklad.model.UserAccount;
import  com.moysklad.service.connection.ConnectionImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCrudDaoImpl implements UserAccountDao {
    //language=sql
    private final String SQL_ADD_USER = "INSERT INTO user_account(name, password) VALUES (?,?)";
    //language=sql
    private final String SQL_DELETE_USER = "DELETE FROM user_account where id = ? ";
    //language=sql
    private final String SQL_UPDATE_USER = "UPDATE user_account SET name=?, password = ? WHERE user_account.id = ?";

    Connection connection;

    public UserCrudDaoImpl() {
        connection = new ConnectionImpl().getConnection();
    }

    @Override
    public void save(UserAccount model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserAccount model, Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}