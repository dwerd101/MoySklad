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
public class Warehouse implements Model {

    @JsonProperty("warehouse_id")
    @NonNull
    private int warehouseId;
    @JsonProperty("product_id")
    @NonNull
    private int productId;
    @JsonProperty("quantity")
    @NonNull
    private int quantity;

}
