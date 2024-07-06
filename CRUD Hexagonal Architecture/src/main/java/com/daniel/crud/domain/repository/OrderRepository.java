package com.daniel.crud.domain.repository;


import com.daniel.crud.domain.model.OrdenModel;

public interface OrderRepository {
    void saveOrder(OrdenModel order);
}