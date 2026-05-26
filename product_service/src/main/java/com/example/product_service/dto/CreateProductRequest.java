package com.example.product_service.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,

        String description)
{}