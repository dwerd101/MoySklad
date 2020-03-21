package com.moysklad.view.hibernateView;


import com.moysklad.dao.domain.HibernateDaoImpl.service.ArrivalProductService;
import com.moysklad.model.ArrivalOfProduct;
import com.moysklad.view.interfaceView.HibernateView;


import java.util.List;

public class ArrivalProductHibernateViewImpl implements HibernateView<ArrivalOfProduct> {
    @Override
    public List<ArrivalOfProduct> findAllView() {
        return new ArrivalProductService().findAll();
    }
}
