package com.example.user_service.dto;

import com.example.user_service.model.User;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email) {

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}