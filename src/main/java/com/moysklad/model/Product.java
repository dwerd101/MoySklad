package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    public Product() {}

    @JsonProperty("vendor_code")
    private String vendorCode;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("last_purchase_price")
    private int lastPurchasePrice;
    @JsonProperty("last_sale_price")
    private int lastSalePrice;

    public Product(String vendorCode, String productName, int lastPurchasePrice, int lastSalePrice) {
        this.vendorCode = vendorCode;
        this.productName = productName;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalePrice = lastSalePrice;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public int getLastSalePrice() {
        return lastSalePrice;
    }
}
