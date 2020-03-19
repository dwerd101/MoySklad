package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moysklad.model.interfaceModel.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Warehouse implements Model {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "warehouse_id" , referencedColumnName = "id")
    @JsonProperty("warehouse_id")
    @NonNull
    private int warehouseId;
    @ManyToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    @JsonProperty("product_id")
    @NonNull
    private int productId;
    @Column(name = "quantity", nullable = true)
    @JsonProperty("quantity")
    @NonNull
    private int quantity;

}
