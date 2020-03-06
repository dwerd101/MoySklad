package com.moysklad.dao.domain;

import com.moysklad.dao.CrudDao;
import com.moysklad.model.ArrivalOrSaleOfProduct;


import java.util.List;

public interface DocumentsDao extends CrudDao<ArrivalOrSaleOfProduct> {
    List<ArrivalOrSaleOfProduct> findAll();
}
