package com.moysklad.dao.domain.documentsDao;

import com.moysklad.dao.CrudDao;

import com.moysklad.model.MovingOfProduct;

import java.util.List;

public interface MovingOfProductDao extends CrudDao<MovingOfProduct> {
    List<MovingOfProduct> findAll();
}
