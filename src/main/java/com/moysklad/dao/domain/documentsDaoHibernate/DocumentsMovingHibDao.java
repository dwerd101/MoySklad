package com.moysklad.dao.domain.documentsDaoHibernate;

import com.moysklad.dao.hibernateDao.CrudHibernateDao;
import com.moysklad.model.MovingOfProduct;

import java.util.List;

public interface DocumentsMovingHibDao extends CrudHibernateDao<MovingOfProduct, Integer> {
    List<MovingOfProduct> findAll();
     MovingOfProduct findById(Integer id);
    boolean isCheckException();
}
