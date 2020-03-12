package com.moysklad.dao.domain.documentsDao;

import com.moysklad.dao.CrudDao;

import com.moysklad.model.MovingOfProduct;

import java.util.List;

public interface DocumentsMovingDao extends CrudDao<MovingOfProduct> {
    List<MovingOfProduct> findAll();
    boolean isCheckException();
}
