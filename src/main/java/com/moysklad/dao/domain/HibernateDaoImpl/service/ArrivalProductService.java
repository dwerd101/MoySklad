package com.moysklad.dao.domain.HibernateDaoImpl.service;

import com.moysklad.dao.domain.HibernateDaoImpl.ArrivalProductHibDaoImpl;
import com.moysklad.model.ArrivalOfProduct;
import lombok.Data;

import java.util.List;


@Data
public class ArrivalProductService {
    private static ArrivalProductHibDaoImpl product;
    public ArrivalProductService() {
        product = new ArrivalProductHibDaoImpl();
    }
    public void save( ArrivalOfProduct product) {
    getProduct().openCurrentSessionWithTransaction();
    getProduct().save(product);
    getProduct().closeCurrentSessionWithTransaction();
    }
    public void update(  ArrivalOfProduct product) {
     getProduct().openCurrentSessionWithTransaction();
     getProduct().update(product);
     getProduct().closeCurrentSessionWithTransaction();
    }
    public ArrivalOfProduct findById(Integer id) {
        getProduct().openCurrentSession();
       final ArrivalOfProduct product = getProduct().findById(id);
        getProduct().closeCurrentSession();
        return product;
    }
    public void delete(Integer id) {
        getProduct().openCurrentSessionWithTransaction();
        final ArrivalOfProduct product = getProduct().findById(id);
        getProduct().delete(product);
        getProduct().closeCurrentSessionWithTransaction();
    }
    public List<ArrivalOfProduct> findAll() {
        getProduct().openCurrentSession();
        List<ArrivalOfProduct> books = getProduct().findAll();
        getProduct().closeCurrentSession();
        return books;
    }

    public ArrivalProductHibDaoImpl getProduct() {
        return product;
    }
}
