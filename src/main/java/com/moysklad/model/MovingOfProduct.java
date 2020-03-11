package com.moysklad.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.moysklad.model.interfaceModel.Model;

public class MovingOfProduct implements Model {
     @JsonProperty("number_id")
     private int numberId;
     @JsonProperty("warehousea_id")
     private int warehouseAId;
     @JsonProperty("warehouseb_id")
     private int warehouseBId;
     @JsonProperty("list_of_product_id")
     private int listOfProductId;

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
