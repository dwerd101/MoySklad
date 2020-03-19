package com.moysklad.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class ListOfProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NonNull
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @NonNull
    private Product productId;
    @NonNull
    @Column(name = "quantity",nullable = true)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "purchase_price_id", referencedColumnName = "id")
    @NonNull
    private PurchasePrice purchasePriceId;
    @ManyToOne
    @JoinColumn(name = "selling_price_id", referencedColumnName = "id")
    @NonNull
    private SellingPrice sellingPriceId;

}
