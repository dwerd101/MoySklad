package com.moysklad.model;


import com.moysklad.model.interfaceModel.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class NumberOfProduct implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NonNull
    private int id;
    @Column(name = "number", nullable = true)
    @NonNull
    private int number;


}
