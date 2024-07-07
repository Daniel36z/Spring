package com.daniel.crud;

import com.daniel.crud.domain.model.OrdenModel;
import com.daniel.crud.domain.ports.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Haber implements c2{

    private final PedidosRepository pedidosRepository;

    public Haber(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    @Override
    public void meto1(OrdenModel ordenModel){
        pedidosRepository.realizarPedido(ordenModel);
    }
}


