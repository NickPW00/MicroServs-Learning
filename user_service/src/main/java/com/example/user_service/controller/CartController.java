package com.example.user_service.controller;

import com.example.user_service.dto.AddItemRequest;
import com.example.user_service.dto.CartItemResponse;
import com.example.user_service.model.CartItem;
import com.example.user_service.services.CartService;
import lombok.RequiredArgsConstructor;
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
    public List<CartItemResponse> getCart(@PathVariable UUID userId) {
        return cartService.getCart(userId);
    }

    @PostMapping
    public CartItem addItem(@PathVariable UUID userId,
                            @RequestBody AddItemRequest request) {
        return cartService.addItem(userId, request.productId(), request.quantity());
    }

    @DeleteMapping("/{cartItemId}")
    public void removeItem(@PathVariable UUID userId,
                           @PathVariable UUID cartItemId) {
        cartService.removeItem(userId, cartItemId);
    }
}

