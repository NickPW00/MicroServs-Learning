package com.example.cart_service.dto;

import java.util.UUID;

public record AddItemRequest(
        UUID productId,
        Integer quantity
) {}