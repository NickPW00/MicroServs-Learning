package com.example.cart_service.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddItemRequest(
        @NotNull(message = "ProductId é obrigatório")
        UUID productId,

        @NotNull(message = "Quantidade é obrigatoria")
        Integer quantity
) {}