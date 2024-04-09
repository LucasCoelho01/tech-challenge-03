package com.lucas.techchallenge.communication.controllers;

import com.lucas.techchallenge.common.dtos.ProductDto;
import com.lucas.techchallenge.communication.gateways.ProductRepository;
import com.lucas.techchallenge.core.entities.Product;
import com.lucas.techchallenge.core.usecases.ProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductController {
    @Autowired
    private ProductUseCase productUseCase;

    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(ProductDto userDto) throws Exception {
        return productUseCase.createProduct(userDto, productRepository);
    }

    public List<Product> getAllProducts() {
        return productUseCase.getAllProducts(productRepository);
    }

    public Product getById(UUID id) {
        return productUseCase.getById(id, productRepository);
    }
}
