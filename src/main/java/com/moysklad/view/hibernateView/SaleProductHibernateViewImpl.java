package com.moysklad.view.hibernateView;

import com.moysklad.dao.domain.HibernateDaoImpl.service.SaleProductService;
import com.moysklad.model.SaleOfProduct;
import com.moysklad.view.interfaceView.HibernateView;

import java.util.List;

public class SaleProductHibernateViewImpl implements HibernateView<SaleOfProduct> {
    @Override
    public List<SaleOfProduct> findAllView() {
        return new SaleProductService().findAll();
    }
}
