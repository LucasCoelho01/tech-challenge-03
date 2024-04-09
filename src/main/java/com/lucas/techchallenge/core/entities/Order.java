package com.lucas.techchallenge.core.entities;

import com.lucas.techchallenge.common.daos.OrderDao;
import com.lucas.techchallenge.common.daos.ProductDao;
import com.lucas.techchallenge.core.enums.OrderStatusEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order {
    private UUID id;
    private String username;
    private List<Product> products = new ArrayList<>();
    private OrderStatusEnum status;
    private BigDecimal price;

    public Order() {
        this.id = UUID.randomUUID();
        this.status = OrderStatusEnum.RECEBIDO;
    }

    public Order(OrderDao orderDao) {
        this.id = orderDao.getId();
        this.username = orderDao.getUsername();
        this.products = convertProducts(orderDao.getProducts());
        this.status = convertStatus(orderDao.getStatus());
        this.price = orderDao.getPrice();
    }

    public Order(Optional<OrderDao> orderDao) {
        this.id = orderDao.get().getId();
        this.username = orderDao.get().getUsername();
        this.products = convertProducts(orderDao.get().getProducts());
        this.status = convertStatus(orderDao.get().getStatus());
        this.price = orderDao.get().getPrice();
    }

    private OrderStatusEnum convertStatus(String status) {
        switch (status) {
            case "PRONTO":
                return OrderStatusEnum.PRONTO;
            case "EM_PREPARACAO" :
                return OrderStatusEnum.EM_PREPARACAO;
            case "RECEBIDO":
                return OrderStatusEnum.RECEBIDO;
            case "FINALIZADO" :
                return OrderStatusEnum.FINALIZADO;
            default:
                return OrderStatusEnum.RECEBIDO;
        }
    }

    private List<Product> convertProducts(List<ProductDao> productsDao) {
            List<Product> products = new ArrayList<>();

            productsDao.forEach(productDao -> {
                Product product = new Product(productDao);
                products.add(product);
            });

            return products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
