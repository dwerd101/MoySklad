package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Product {

    @JsonProperty("vendor_code")
    @NonNull
    private String vendorCode;
    @JsonProperty("product_name")
    @NonNull
    private String productName;
    @JsonProperty("last_purchase_price")
    @NonNull
    private int lastPurchasePrice;
    @JsonProperty("last_sale_price")
    @NonNull
    private int lastSalePrice;


}
