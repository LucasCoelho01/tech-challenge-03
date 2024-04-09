package com.lucas.techchallenge.common.dtos;

import com.lucas.techchallenge.core.enums.CategoryEnum;

import java.math.BigDecimal;

public class ProductDto {
    private String productName;
    private BigDecimal productPrice;

    private CategoryEnum category;

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

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
