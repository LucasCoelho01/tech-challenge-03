package com.lucas.techchallenge.external.apis;

import com.lucas.techchallenge.common.dtos.OrderDto;
import com.lucas.techchallenge.communication.controllers.OrderController;
import com.lucas.techchallenge.core.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    OrderController orderController;

    @PostMapping
    ResponseEntity<Order> createOder(@RequestBody OrderDto orderDto) throws Exception {
        return new ResponseEntity<>(orderController.createOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderController.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return new ResponseEntity<>(orderController.getOrderById(id), HttpStatus.OK);
    }

    @PutMapping("id/{id}")
    ResponseEntity<Order> updateOrderStatus(@PathVariable String id, @RequestBody String status) {
        return new ResponseEntity<>(orderController.updateOrderStatus(id, status), HttpStatus.OK);
    }
}
