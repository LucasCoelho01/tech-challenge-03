package com.lucas.techchallenge.communication.controllers;

import com.lucas.techchallenge.common.dtos.OrderDto;
import com.lucas.techchallenge.communication.gateways.OrderRepository;
import com.lucas.techchallenge.communication.gateways.ProductRepository;
import com.lucas.techchallenge.communication.gateways.UserRepository;
import com.lucas.techchallenge.core.entities.Order;
import com.lucas.techchallenge.core.usecases.OrderUseCase;
import com.lucas.techchallenge.core.usecases.ProductUseCase;
import com.lucas.techchallenge.core.usecases.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderController {
    @Autowired
    private OrderUseCase orderUseCase;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUseCase userUseCase;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductUseCase productUseCase;
    public Order createOrder(OrderDto orderDto) throws Exception {
        return orderUseCase.createOrder(orderDto, orderRepository, userUseCase, userRepository, productUseCase, productRepository);
    }

    public List<Order> getAllOrders() {
        return orderUseCase.getAllOrders(orderRepository);
    }

    public Order getOrderById(String id) {
        return orderUseCase.getOrderById(id, orderRepository);
    }

    public Order updateOrderStatus(String id, String status) {
        return orderUseCase.updateOrderStatus(id, status, orderRepository);
    }
}
