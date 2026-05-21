package com.example.product_service.dto;

import com.example.product_service.model.Product;
import java.util.UUID;

public record ProductResponse(UUID id, String name, String description) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription()
        );
    }
}