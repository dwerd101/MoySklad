package com.moysklad.model;

public class ListOfProduct {
    public ListOfProduct(int productId, int quantity, int purchasePriceId, int sellingPriceId) {
        this.productId = productId;
        this.quantity = quantity;
        this.purchasePriceId = purchasePriceId;
        this.sellingPriceId = sellingPriceId;
    }

    private int productId,quantity,purchasePriceId,sellingPriceId;


}
