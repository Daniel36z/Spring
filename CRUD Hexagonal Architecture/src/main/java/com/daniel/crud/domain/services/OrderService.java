package com.daniel.crud.domain.services;

import com.daniel.crud.domain.model.OrdenModel;
import com.daniel.crud.domain.ports.OrderRepository;
import com.daniel.crud.domain.ports.PedidosRepository;
import org.springframework.stereotype.Repository;

public class OrderService implements PedidosRepository {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void realizarPedido(OrdenModel order) {
        if (order.getQuantity() <= 0) {
            throw new RuntimeException("La cantidad miníma debe ser mayor a 0");
        }
        System.out.println("okey valor admitido");
        orderRepository.saveOrder(order);
    }

}











