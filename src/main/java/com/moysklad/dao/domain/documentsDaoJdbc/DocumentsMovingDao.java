package com.moysklad.dao.domain.documentsDaoJdbc;

import com.moysklad.dao.jdbcDao.CrudDao;

import com.moysklad.model.MovingOfProduct;

import java.util.List;

public interface DocumentsMovingDao extends CrudDao<MovingOfProduct> {
    List<MovingOfProduct> findAll();

}
