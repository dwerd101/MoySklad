package com.moysklad.dao;

public interface CrudDao<T> {
    void save (T model);
    void update (T model, Integer id);
    void delete (Integer id);
}
