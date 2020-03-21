package com.moysklad.dao.domain.documentsDaoHibernate;

import com.moysklad.dao.hibernateDao.CrudHibernateDao;
import com.moysklad.model.ArrivalOfProduct;


import java.util.List;

public interface DocumentsArrivalHibDao extends CrudHibernateDao<ArrivalOfProduct, Integer> {
    List<ArrivalOfProduct> findAll();
   ArrivalOfProduct findById(Integer id);
}
