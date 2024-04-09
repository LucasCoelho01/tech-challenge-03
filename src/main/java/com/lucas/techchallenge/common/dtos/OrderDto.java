package com.lucas.techchallenge.common.dtos;

import java.util.List;

public class OrderDto {
    private String user_id;
    private List<String> products_ids;

    public List<String> getProducts_ids() {
        return products_ids;
    }

    public void setProducts_ids(List<String> products_ids) {
        this.products_ids = products_ids;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
