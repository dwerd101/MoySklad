package com.moysklad.dao.domain;

import com.moysklad.model.ArrivalOrSaleOfProduct;

import com.moysklad.service.connection.ConnectionDataBaseFactory;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArrivalProductDaoImpl implements DocumentsDao{
    Connection connection;
    //language=SQL
    private final String SQL_SELECT_ALL = " SELECT * from arrival_of_product";
    //language=sql
    private final String SQL_ADD_PRODUCT = "INSERT INTO arrival_of_product(number_id, warehouse_id, list_of_product_id) VALUES (?,?,?)";
    //language=sql
    private final String SQL_DELETE_PRODUCT = "DELETE FROM arrival_of_product where id = ? ";
    //language=sql
    private final String SQL_UPDATE_PRODUCT = "UPDATE arrival_of_product SET number_id=?, warehouse_id = ?, list_of_product_id= ? WHERE id = ?";

    private static class SingletonHelper {
        private static final UserCrudDaoImpl INSTANCE = new UserCrudDaoImpl();
    }



    @Override
    public void save(ArrivalOrSaleOfProduct model) {
        try {
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_PRODUCT);
            preparedStatement.setInt(1, model.getNumberId());
            preparedStatement.setInt(2, model.getWarehouseId());
            preparedStatement.setInt(3, model.getListOfProductId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ArrivalOrSaleOfProduct model, Integer id) {
        try {
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PRODUCT);
            preparedStatement.setInt(1, model.getNumberId());
            preparedStatement.setInt(2, model.getWarehouseId());
            preparedStatement.setInt(3, model.getListOfProductId());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    @Override
    public List<ArrivalOrSaleOfProduct> findAll() {
        try {
            List<ArrivalOrSaleOfProduct> products = new ArrayList<>();
            connection = ConnectionDataBaseFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                int numberId = resultSet.getInt("number_id");
                int warehouseId = resultSet.getInt("warehouse_id");
                int listOfProductId = resultSet.getInt("list_of_product_id");
                ArrivalOrSaleOfProduct arrivalOrSaleOfProduct = new ArrivalOrSaleOfProduct(numberId,warehouseId,listOfProductId);
                products.add(arrivalOrSaleOfProduct);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
