package com.daniel.crud.domain.services;


import com.daniel.crud.domain.exepciones.UsuarioExisteExeption;
import com.daniel.crud.domain.model.UserModel;
import com.daniel.crud.domain.ports.repository.OrderRepository;
import org.springframework.stereotype.Service;


//service domain ddd - design pattern
@Service
public class userService {

    private static final String MENSAJE_USUARIO_REPETIDO = "Este correo ya esta registrado";

    private final OrderRepository orderRepository;

    public userService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveUser(UserModel user) {
            existsUserValidacion(user);
            this.orderRepository.saveUser(user);
        }

    public void existsUserValidacion(UserModel user) {
        if(this.orderRepository.existeUser(user.getCorreoElectronico())){
            throw new UsuarioExisteExeption(MENSAJE_USUARIO_REPETIDO);
        }
    }
}
