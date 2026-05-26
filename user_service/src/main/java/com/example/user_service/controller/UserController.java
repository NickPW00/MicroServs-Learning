package com.example.user_service.controller;

import com.example.user_service.dto.CreateUserRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(request));
    }
}