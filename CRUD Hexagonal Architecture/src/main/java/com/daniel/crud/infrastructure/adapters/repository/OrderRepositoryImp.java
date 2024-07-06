package com.daniel.crud.infrastructure.adapters.repository;

import com.daniel.crud.domain.model.OrdenModel;
import com.daniel.crud.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImp implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    @Autowired
    public OrderRepositoryImp(JpaOrderRepository jpaOrderRepository){
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public void saveOrder(OrdenModel order) {
        jpaOrderRepository.save(order);
    }
}
