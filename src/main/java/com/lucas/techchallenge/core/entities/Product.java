package com.lucas.techchallenge.core.entities;

import com.lucas.techchallenge.common.daos.ProductDao;
import com.lucas.techchallenge.common.dtos.ProductDto;
import com.lucas.techchallenge.core.enums.CategoryEnum;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class Product {
    private UUID id;
    private String productName;
    private BigDecimal productPrice;

    private CategoryEnum category;

    public Product() {}

    public Product(ProductDto productDto) {
        this.id = UUID.randomUUID();
        this.productName = productDto.getProductName();
        this.productPrice = productDto.getProductPrice();
        this.category = productDto.getCategory();
    }

    public Product(ProductDao productDao) {
        this.id = productDao.getId();
        this.productName = productDao.getProductName();
        this.productPrice = productDao.getProductPrice();
        this.category = CategoryEnum.valueOf(productDao.getCategory());
    }

    public Product(Optional<ProductDao> productDao) {
        this.id = productDao.get().getId();
        this.productName = productDao.get().getProductName();
        this.productPrice = productDao.get().getProductPrice();
        this.category = CategoryEnum.valueOf(productDao.get().getCategory());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Enum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
