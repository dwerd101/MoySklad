package com.moysklad.view;

import com.moysklad.service.connection.ConnectionDataBaseFactory;
import lombok.Getter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SaleProductView implements View<SaleProductView> {
    Connection connection;

    //language=sql
    private final String SQL_SELECT_ALL_VIEW = "SELECT * from salelistproduct";

    private int numberId, warehouseId, listOfProductId, productId, quantity, price;
    private String productName;
    public SaleProductView() { }
    public SaleProductView(int numberId, int warehouseId, int listOfProductId, String productName, int productId, int quantity, int price) {
        this.numberId = numberId;
        this.warehouseId = warehouseId;
        this.listOfProductId = listOfProductId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
    }
    public List<SaleProductView> findAllView() {
        try {
            List<SaleProductView> products = new ArrayList<>();
            connection = ConnectionDataBaseFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_VIEW);
            while (resultSet.next()) {
                int numberId = resultSet.getInt("number_id");
                int warehouseId = resultSet.getInt("warehouse_id");
                int listOfProductId = resultSet.getInt("list_of_product_id");
                String productName = resultSet.getString("product_name");
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                SaleProductView productView = new SaleProductView(numberId, warehouseId, listOfProductId, productName, productId, quantity, price);
                products.add(productView);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
