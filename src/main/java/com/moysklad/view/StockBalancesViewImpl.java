package com.moysklad.view;

import com.moysklad.service.connection.ConnectionDataBaseFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockBalancesViewImpl implements View<StockBalancesViewImpl> {

    Connection connection;

    //language=sql
    private final String SELECT_ALL_VIEW ="SELECT * from stock_balances";
    //language=sql
    private final String SELECT_ALL_VIEW_BY_ID = "SELECT * FROM stock_balances where warehouse_name = ?";

    private String vendorCode;
    private String productName;
    private String warehouse_name;

    public StockBalancesViewImpl() {}

    public StockBalancesViewImpl(String vendorCode, String productName, String warehouse_name) {
        this.vendorCode = vendorCode;
        this.productName = productName;
        this.warehouse_name = warehouse_name;
    }

    @Override
    public List<StockBalancesViewImpl> findAllView() {

        try {
            List<StockBalancesViewImpl> products = new ArrayList<>();
            connection = ConnectionDataBaseFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_VIEW);
            while (resultSet.next()) {
                String vendorCode = resultSet.getString("vendor_code");
                String productName = resultSet.getString("product_name");
                String warehouseId = resultSet.getString("warehouse_name");
                StockBalancesViewImpl productView = new StockBalancesViewImpl(vendorCode, productName, warehouseId);
                products.add(productView);
            }
            return products;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<StockBalancesViewImpl> findByName(GeneralListOfProductViewImpl model, String name) {
        try {
            List<StockBalancesViewImpl> products = findAllView();
            connection = ConnectionDataBaseFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_VIEW_BY_ID);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String vendorCode = resultSet.getString("vendor_code");
                String productName = resultSet.getString("product_name");
                String warehouseId = resultSet.getString("warehouse_name");
                StockBalancesViewImpl productView = new StockBalancesViewImpl(vendorCode, productName, warehouseId);
                products.add(productView);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
