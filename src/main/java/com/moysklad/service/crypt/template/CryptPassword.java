package com.moysklad.service.crypt.template;

public interface CryptPassword {
    String cryptPassword(String password);
    boolean checkPassword(String password, String hashPassword);


}
