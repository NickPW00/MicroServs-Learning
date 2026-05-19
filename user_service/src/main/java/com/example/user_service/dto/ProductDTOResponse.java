package com.example.user_service.dto;

import java.util.UUID;

public record ProductDTOResponse(UUID id, String name, String description) {
}
