package com.daniel.crud.application.ports;

import com.daniel.crud.domain.model.OrdenModel;

public interface OrderUseCases {
    void realizarPedidoImpl(OrdenModel ordenModel);
}
