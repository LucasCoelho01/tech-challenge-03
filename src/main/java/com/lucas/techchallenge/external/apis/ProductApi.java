package com.lucas.techchallenge.external.apis;

import com.lucas.techchallenge.common.dtos.ProductDto;
import com.lucas.techchallenge.communication.controllers.ProductController;
import com.lucas.techchallenge.core.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    @Autowired
    private ProductController productController;
    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) throws Exception {
        return new ResponseEntity<>(productController.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productController.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Product> getById(@PathVariable UUID id) {
        return new ResponseEntity<>(productController.getById(id), HttpStatus.OK);
    }
}
