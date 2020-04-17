package com.moysklad.dao.spring;


import com.moysklad.model.ArrivalOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("arrRep")
public interface ArrivalOfProductRepository extends JpaRepository<ArrivalOfProduct, Integer> {

}
