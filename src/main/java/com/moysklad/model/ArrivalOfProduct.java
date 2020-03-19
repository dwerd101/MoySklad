package com.moysklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moysklad.model.interfaceModel.Model;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ArrivalOfProduct implements Model {

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
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @JsonProperty("warehouse_id")
    @NonNull
    private Warehouse warehouseId;
    @ManyToOne
    @JoinColumn(name = "list_of_product_id" , referencedColumnName = "id")
    @JsonProperty("list_of_product_id")
    @NonNull
    private ListOfProduct listOfProductId;

}
