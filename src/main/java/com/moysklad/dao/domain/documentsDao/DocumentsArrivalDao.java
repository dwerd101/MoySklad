package com.moysklad.dao.domain.documentsDao;

import com.moysklad.dao.CrudDao;
import com.moysklad.model.ArrivalOfProduct;

import java.util.List;

public interface DocumentsArrivalDao extends CrudDao<ArrivalOfProduct> {
    List<ArrivalOfProduct> findAll();
}
