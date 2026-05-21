package com.example.cart_service.dto;

import java.util.UUID;

public record CartItemResponse(
        UUID cartItemId,
        Integer quantity,
        ProductResponse product
) {}