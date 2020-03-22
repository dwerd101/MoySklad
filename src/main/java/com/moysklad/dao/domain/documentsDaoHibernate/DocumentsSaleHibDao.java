package com.moysklad.dao.domain.documentsDaoHibernate;



import com.moysklad.dao.hibernateDao.CrudHibernateDao;
import com.moysklad.model.SaleOfProduct;

import java.util.List;

public interface DocumentsSaleHibDao extends CrudHibernateDao<SaleOfProduct, Integer> {
    List<SaleOfProduct> findAll();
    SaleOfProduct findById(Integer id);
}
