package com.lucas.techchallenge.core.usecases;

import com.lucas.techchallenge.common.daos.OrderDao;
import com.lucas.techchallenge.common.daos.UserDao;
import com.lucas.techchallenge.common.dtos.OrderDto;
import com.lucas.techchallenge.communication.gateways.OrderRepository;
import com.lucas.techchallenge.communication.gateways.ProductRepository;
import com.lucas.techchallenge.communication.gateways.UserRepository;
import com.lucas.techchallenge.core.entities.Order;
import com.lucas.techchallenge.core.entities.Product;
import com.lucas.techchallenge.core.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderUseCase {

    public Order createOrder(OrderDto orderDto,
                             OrderRepository orderRepository,
                             UserUseCase userUseCase,
                             UserRepository userRepository,
                             ProductUseCase productUseCase,
                             ProductRepository productRepository) throws Exception {
        Order order = new Order();

        if (Objects.nonNull(orderDto.getUser_id())) {
            Optional<UserDao> user = userUseCase.getUserById(orderDto.getUser_id(), userRepository);
            order.setUsername(user.get().getUsername());
        }

        List<Product> productList = new ArrayList<>();

        List<BigDecimal> totalPrice = new ArrayList<>();

        orderDto.getProducts_ids().forEach(product_id -> {
            UUID productIdUUID = UUID.fromString(product_id);
            Product productFound = productUseCase.getById(productIdUUID, productRepository);

            totalPrice.add(productFound.getProductPrice());
            productList.add(productFound);
        });

        order.setProducts(productList);

        OrderDao orderCreated = orderRepository.save(new OrderDao(order));
        order.setPrice(orderCreated.getPrice());

        return order;
    }

    public List<Order> getAllOrders(OrderRepository orderRepository) {
        List<Order> orders = new ArrayList<>();
        List<OrderDao> ordersDao = orderRepository.findAll();

        ordersDao.forEach(orderDao -> {
            Order order = new Order(orderDao);
            orders.add(order);
        });

        return orders;
    }

    public Order getOrderById(String id, OrderRepository orderRepository) {
        UUID id_uuid = UUID.fromString(id);
        Optional<OrderDao> orderDao = orderRepository.findById(id_uuid);

        if (Objects.nonNull(orderDao)) {
            return new Order(orderDao);
        }

        return new Order();
    }

    public Order updateOrderStatus(String id, String status, OrderRepository orderRepository) {
        Order order = getOrderById(id, orderRepository);

        switch (status) {
            case "PRONTO":
                order.setStatus(OrderStatusEnum.PRONTO);
            case "EM_PREPARACAO" :
                order.setStatus(OrderStatusEnum.EM_PREPARACAO);
            case "RECEBIDO":
                order.setStatus(OrderStatusEnum.RECEBIDO);
            case "FINALIZADO" :
                order.setStatus(OrderStatusEnum.FINALIZADO);
            default:
                order.setStatus(OrderStatusEnum.RECEBIDO);
        }

        OrderDao orderDao = new OrderDao(order);

        orderDao.setStatus(status);

        orderRepository.save(orderDao);

        return order;
    }
}
