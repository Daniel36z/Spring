package com.daniel.crud.domain.ports;

import com.daniel.crud.domain.model.OrdenModel;
import org.springframework.stereotype.Service;

public interface OrderRepository {
    void saveOrder(OrdenModel order);
}