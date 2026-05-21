package com.example.cart_service.controller;

import com.example.cart_service.dto.AddItemRequest;
import com.example.cart_service.dto.CartItemResponse;
import com.example.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// CartController.java
@RestController
@RequestMapping("/users/{userId}/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartItemResponse>> getCart(@PathVariable UUID userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping
    public ResponseEntity<CartItemResponse> addItem(@PathVariable UUID userId,
                                                    @RequestBody AddItemRequest request) {
        CartItemResponse response = cartService.addItem(userId, request.productId(), request.quantity());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<Void> removeItem(@PathVariable UUID userId,
                                           @PathVariable UUID cartItemId) {
        cartService.removeItem(userId, cartItemId);
        return ResponseEntity.noContent().build();
    }
}

