package com.example.user_service.dto;

import java.util.UUID;

public record CartItemResponse(
        UUID cartItemId,
        Integer quantity,
        ProductDTOResponse product   // dado enriquecido
) {}
