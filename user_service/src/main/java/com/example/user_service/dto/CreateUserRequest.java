package com.example.user_service.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,

        @NotBlank(message = "Email é obrigatório")
        String email
) {}
