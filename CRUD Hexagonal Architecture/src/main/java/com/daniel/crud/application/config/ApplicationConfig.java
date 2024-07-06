package com.daniel.crud.application.config;

import com.daniel.crud.application.ports.OrderUseCases;
import com.daniel.crud.application.services.OrderServiceImp;
import com.daniel.crud.domain.repository.OrderRepository;
import com.daniel.crud.domain.services.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    public OrderUseCases orderUseCases(OrderService orderService) {
        return new OrderServiceImp(orderService);
    }
}










