package com.moysklad.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.moysklad.model.interfaceModel.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MovingOfProduct implements Model {
     @JsonProperty("number_id")
     @NonNull
     private int numberId;
     @JsonProperty("warehousea_id")
     @NonNull
     private int warehouseAId;
     @JsonProperty("warehouseb_id")
     @NonNull
     private int warehouseBId;
     @JsonProperty("list_of_product_id")
     @NonNull
     private int listOfProductId;
 }
