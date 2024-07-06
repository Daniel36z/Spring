package com.daniel.crud.application.services;

import com.daniel.crud.application.ports.OrderUseCases;
import com.daniel.crud.domain.model.OrdenModel;
import com.daniel.crud.domain.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderUseCases {

    private final OrderService orderService;

    //DI para acceder a la logica del dominio desde esta clase
    @Autowired
    public OrderServiceImp(OrderService orderService) {
        this.orderService = orderService;
    }

    /*
    El método se llama desde el repository de dominio
    pero la logica se inyecta desde el servicio de dominio
    finalmente todo se expone atraves de la capa de infrastructure
    */

    @Override
    public void realizarPedidoImpl(OrdenModel ordenModel) {
        orderService.realizarPedido(ordenModel);
    }
}











