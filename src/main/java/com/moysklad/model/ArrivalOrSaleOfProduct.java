package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArrivalOrSaleOfProduct {

    //Для Jackson'a создан конструктор по умолчанию
    public ArrivalOrSaleOfProduct() {}

    @JsonProperty("number_id")
    private int numberId;
    @JsonProperty("warehouse_id")
    private int warehouseId;
    @JsonProperty("list_of_product_id")
    private int listOfProductId;

    public int getNumberId() {
        return numberId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public int getListOfProductId() {
        return listOfProductId;
    }

    public ArrivalOrSaleOfProduct(int numberId, int warehouseId, int listOfProductId) {
        this.numberId = numberId;
        this.warehouseId = warehouseId;
        this.listOfProductId = listOfProductId;
    }
}
