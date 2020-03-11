package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moysklad.model.interfaceModel.Model;

public class Warehouse implements Model {

    @JsonProperty("warehouse_id")
    private int warehouseId;
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("quantity")
    private int quantity;

    public Warehouse(){}

    public Warehouse(int warehouseId, int productId, int quantity) {
        this.warehouseId = warehouseId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
