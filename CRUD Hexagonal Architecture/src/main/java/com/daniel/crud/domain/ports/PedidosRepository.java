package com.daniel.crud.domain.ports;

import com.daniel.crud.domain.model.OrdenModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface PedidosRepository {
    void realizarPedido(OrdenModel ordenModel);
}
