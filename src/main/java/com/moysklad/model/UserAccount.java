package com.moysklad.model;

import com.moysklad.model.interfaceModel.Model;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserAccount implements Model {
    @NonNull
    private String name;
    @NonNull
    private String password;


}
