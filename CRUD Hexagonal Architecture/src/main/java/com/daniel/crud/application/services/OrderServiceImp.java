package com.daniel.crud.application.services;

import com.daniel.crud.domain.model.OrdenModel;
import com.daniel.crud.domain.repository.OrderRepository;
import com.daniel.crud.domain.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderRepository {

    private final OrderService orderService;

    @Autowired
    public OrderServiceImp(OrderService orderService) {
        this.orderService = orderService;
    }

    /*El método se llama desde el repository de dominio
    pero la logica se inyecta desde el servicio de dominio
    finalmente todo se expone a treves de la capa de infrastructure*/

    @Override
    public void saveOrder(OrdenModel order) {
        orderService.realizarPedido(order);
    }
}











