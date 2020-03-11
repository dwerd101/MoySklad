package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moysklad.model.interfaceModel.Model;

public class ArrivalOfProduct implements Model {

    //Для Jackson'a создан конструктор по умолчанию
    public ArrivalOfProduct() {}

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

    public ArrivalOfProduct(int numberId, int warehouseId, int listOfProductId) {
        this.numberId = numberId;
        this.warehouseId = warehouseId;
        this.listOfProductId = listOfProductId;
    }
}
