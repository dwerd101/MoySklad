package com.moysklad.dao.domain.documentsDaoJdbc;

import com.moysklad.dao.jdbcDao.CrudDao;
import com.moysklad.model.ArrivalOfProduct;

import java.util.List;

public interface DocumentsArrivalDao extends CrudDao<ArrivalOfProduct> {
    List<ArrivalOfProduct> findAll();

}
