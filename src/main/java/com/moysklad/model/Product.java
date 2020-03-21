package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "vendor_code", length = 100)
    @JsonProperty("vendor_code")
    @NonNull
    private String vendorCode;

    @Column(name = "product_name",  length = 50)
    @JsonProperty("product_name")
    @NonNull
    private String productName;

    @Column(name = "last_purchase_price")
    @JsonProperty("last_purchase_price")
    @NonNull
    private int lastPurchasePrice;

    @Column(name = "last_sale_price")
    @JsonProperty("last_sale_price")
    @NonNull
    private int lastSalePrice;

}
