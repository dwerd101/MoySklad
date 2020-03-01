package com.moysklad.dao;

public interface CrudDao<T> {
    void create( T model);
    void read (T model);
    void update (T model);
    void delete (Integer id);
}
