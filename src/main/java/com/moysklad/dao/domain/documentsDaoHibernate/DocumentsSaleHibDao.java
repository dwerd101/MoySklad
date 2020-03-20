package com.moysklad.dao.domain.documentsDaoHibernate;



import com.moysklad.dao.hibernateDao.CrudHibernateDao;
import com.moysklad.model.SaleOfProduct;

import java.util.List;

public interface DocumentsSaleHibDao extends CrudHibernateDao {
    List<SaleOfProduct> findAll();
    boolean isCheckException();
}
