package com.example.user_service.dto;

import java.util.UUID;

public record ProductResponse(UUID id, String name, String description) {
}
