package com.lucas.techchallenge.common.daos;

import com.lucas.techchallenge.core.entities.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Document
public class ProductDao {
    @Id
    private UUID id;
    private String productName;
    private BigDecimal productPrice;
    private String category;

    public ProductDao() {}

    public ProductDao(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.category = product.getCategory().name();
    }
}