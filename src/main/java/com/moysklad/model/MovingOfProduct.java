package com.moysklad.model;

public class MovingOfProduct {
    public MovingOfProduct(int numberId, int warehouseId, int listOfProductId) {
        this.numberId = numberId;
        this.warehouseId = warehouseId;
        this.listOfProductId = listOfProductId;
    }

    private int numberId, warehouseId, listOfProductId;
}
