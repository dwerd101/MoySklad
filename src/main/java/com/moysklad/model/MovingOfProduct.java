package com.moysklad.model;


 public class MovingOfProduct {
    private int numberId, warehouseAId,warehouseBId, listOfProductId;

     public int getNumberId() {
         return numberId;
     }

     public int getWarehouseAId() {
         return warehouseAId;
     }

     public int getWarehouseBId() {
         return warehouseBId;
     }

     public int getListOfProductId() {
         return listOfProductId;
     }

     public MovingOfProduct(int numberId, int warehouseAId, int warehouseBId, int listOfProductId) {
         this.numberId = numberId;
         this.warehouseAId = warehouseAId;
         this.warehouseBId = warehouseBId;
         this.listOfProductId = listOfProductId;
     }
 }
