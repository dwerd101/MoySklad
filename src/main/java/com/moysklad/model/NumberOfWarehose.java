package com.moysklad.model;

import com.moysklad.model.interfaceModel.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class NumberOfWarehose implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NonNull
    private int id;
    @Column(name = "warehouse_name")
    @NonNull
    private String warehouseName;
}
