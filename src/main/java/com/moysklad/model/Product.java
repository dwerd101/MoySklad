package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Log
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    @Column(name = "vendor_code", nullable = true, length = 100)
    @JsonProperty("vendor_code")
    @NonNull
    private String vendorCode;
    @Basic
    @Column(name = "product_name", nullable = true, length = 50)
    @JsonProperty("product_name")
    @NonNull
    private String productName;
    @Basic
    @Column(name = "last_purchase_price", nullable = true)
    @JsonProperty("last_purchase_price")
    @NonNull
    private int lastPurchasePrice;
    @Basic
    @Column(name = "last_sale_price", nullable = true)
    @JsonProperty("last_sale_price")
    @NonNull
    private int lastSalePrice;

}
