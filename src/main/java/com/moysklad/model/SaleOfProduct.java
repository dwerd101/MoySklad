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
public class SaleOfProduct implements Model {

    @JsonProperty("number_id")
    @NonNull
    private int numberId;
    @JsonProperty("warehouse_id")
    @NonNull
    private int warehouseId;
    @JsonProperty("list_of_product_id")
    @NonNull
    private int listOfProductId;

}
