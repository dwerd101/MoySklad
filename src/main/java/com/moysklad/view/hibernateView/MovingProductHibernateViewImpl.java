package com.moysklad.view.hibernateView;

import com.moysklad.dao.domain.HibernateDaoImpl.service.MovingProductService;
import com.moysklad.model.MovingOfProduct;
import com.moysklad.view.interfaceView.HibernateView;

import java.util.List;

public class MovingProductHibernateViewImpl implements HibernateView<MovingOfProduct> {
    @Override
    public List<MovingOfProduct> findAllView() {
        return new MovingProductService().findAll();
    }
}
