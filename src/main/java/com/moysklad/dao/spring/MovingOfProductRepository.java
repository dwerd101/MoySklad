package com.moysklad.dao.spring;


import com.moysklad.model.MovingOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movingRep")
public interface MovingOfProductRepository extends JpaRepository<MovingOfProduct, Integer> {
}
