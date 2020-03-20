package com.moysklad.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="list_of_product")
public class ListOfProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @NonNull
    private Product productId;
    @NonNull
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "purchase_price_id", referencedColumnName = "id")
    @NonNull
    private PurchasePrice purchasePriceId;
    @ManyToOne
    @JoinColumn(name = "selling_price_id", referencedColumnName = "id")
    @NonNull
    private SellingPrice sellingPriceId;

    /*@OneToMany(mappedBy = "listOfProductId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ArrivalOfProduct> arrivalOfProductList = new HashSet<>();*/

}
