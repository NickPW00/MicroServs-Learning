package com.example.user_service.controller;

import com.example.user_service.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

public class CartController {
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

    // AddItemRequest.java
    public record AddItemRequest(UUID productId, Integer quantity) {}
}
