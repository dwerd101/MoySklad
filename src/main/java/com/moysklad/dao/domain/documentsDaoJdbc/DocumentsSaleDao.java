package com.moysklad.dao.domain.documentsDaoJdbc;

import com.moysklad.dao.jdbcDao.CrudDao;
import com.moysklad.model.SaleOfProduct;


import java.util.List;

public interface DocumentsSaleDao extends CrudDao<SaleOfProduct> {
    List<SaleOfProduct> findAll();
    boolean isCheckException();
}
