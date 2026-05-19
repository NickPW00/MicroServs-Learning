package com.example.product_service.dto;

import com.example.product_service.model.Product;

import java.util.UUID;

public record ProductDTOResponse(UUID id, String name, String description) {

    public static ProductDTOResponse from(Product product) {
        return new ProductDTOResponse(product.getId(), product.getName(), product.getDescription());
    }
}
