package com.moysklad.dao.domain.documentsDao;

import com.moysklad.dao.CrudDao;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.model.SaleOfProduct;


import java.util.List;

public interface DocumentsSaleDao extends CrudDao<SaleOfProduct> {
    List<SaleOfProduct> findAll();
}
