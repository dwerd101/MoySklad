package com.moysklad.model;

import com.moysklad.model.interfaceModel.Model;

public class UserAccount implements Model {
    private String name, password;

    public UserAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
