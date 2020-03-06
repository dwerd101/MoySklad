package com.moysklad.model;

public class ArrivalOrSaleOfProduct {
    private int numberId, warehouseId, listOfProductId;

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
