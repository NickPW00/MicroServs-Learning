package com.example.user_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// CartService.java
@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final WebClient productWebClient;

    public CartItem addItem(UUID userId, UUID productId, Integer quantity) {
        CartItem item = new CartItem();
        item.setUserId(userId);
        item.setProductId(productId);
        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }

    public List<CartItemResponse> getCart(UUID userId) {
        List<CartItem> items = cartItemRepository.findByUserId(userId);

        return items.stream()
                .map(item -> {
                    ProductResponse product = productWebClient.get()
                            .uri("/products/{id}", item.getProductId())
                            .retrieve()
                            .bodyToMono(ProductResponse.class)
                            .block();  // síncrono por enquanto — ok para aprender

                    return new CartItemResponse(item.getId(), item.getQuantity(), product);
                })
                .toList();
    }

    public void removeItem(UUID userId, UUID cartItemId) {
        cartItemRepository.deleteByIdAndUserId(cartItemId, userId);
    }
}
