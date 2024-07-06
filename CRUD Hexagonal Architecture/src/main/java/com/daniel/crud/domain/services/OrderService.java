package com.daniel.crud.domain.services;

import com.daniel.crud.domain.model.OrdenModel;
import com.daniel.crud.domain.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void realizarPedido(OrdenModel order){
        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad miníma debe ser mayor a 0");
        }
        orderRepository.saveOrder(order);
    }

}











