package com.vk59.buylist.models;

import com.vk59.buylist.db.entities.ProductEntity;

public class Product {
    private ProductEntity entity;

    public Product(ProductEntity productEntity) {
        this.entity = productEntity;
    }

    public Long getId() {
        return entity.id;
    }

    public String getName() {
        return entity.name;
    }
}
