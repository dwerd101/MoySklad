package com.moysklad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccount {
    private String name, password;

    public UserAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
