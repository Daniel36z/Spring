package com.daniel.crud.domain.ports.repository;

import com.daniel.crud.domain.model.UserModel;

//patron de diseño - contrato DAO
public interface OrderRepository {
    void saveUser(UserModel user);
    boolean existeUser(String email);
}