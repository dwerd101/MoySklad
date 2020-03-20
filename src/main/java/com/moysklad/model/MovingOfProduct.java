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
@Table(name="moving_of_product")
public class MovingOfProduct implements Model {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id")
     private int id;

     @ManyToOne
     @JoinColumn(name = "number_id", referencedColumnName = "id")
     @JsonProperty("number_id")
     @NonNull
     private NumberOfProduct numberId;

     @ManyToOne
     @JoinColumn(name = "warehousea_id", referencedColumnName = "id")
     @JsonProperty("warehousea_id")
     @NonNull
     private Warehouse warehouseAId;

     @ManyToOne
     @JoinColumn(name = "warehouseb_id", referencedColumnName = "id")
     @JsonProperty("warehouseb_id")
     @NonNull
     private Warehouse warehouseBId;

     @ManyToOne
     @JoinColumn(name ="list_of_product_id", referencedColumnName = "id")
     @JsonProperty("list_of_product_id")
     @NonNull
     private ListOfProduct listOfProductId;





 }
