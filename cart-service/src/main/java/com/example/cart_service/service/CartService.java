package com.example.cart_service.service;

import com.example.cart_service.dto.CartItemResponse;
import com.example.cart_service.dto.ProductResponse;
import com.example.cart_service.dto.UserResponse;
import com.example.cart_service.model.CartItem;
import com.example.cart_service.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final WebClient userWebClient;
    private final WebClient productWebClient;

    public CartService(CartItemRepository cartItemRepository,
                       @Qualifier("userWebClient") WebClient userWebClient,
                       @Qualifier("productWebClient") WebClient productWebClient
    ) {
        this.cartItemRepository = cartItemRepository;
        this.userWebClient = userWebClient;
        this.productWebClient = productWebClient;
    }

    public CartItemResponse addItem(UUID userId, UUID productId, Integer quantity) {
        // Apenas valida se o Usuario existe. Se existir, funciona, senão, lança exceção automática.
        userWebClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();

        // Para verificar e montar o reponse
        ProductResponse product = productWebClient.get()
                .uri("/products/{id}", productId)
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();

        CartItem item = new CartItem();
        item.setUserId(userId);
        item.setProductId(productId);
        item.setQuantity(quantity);
        CartItem saved = cartItemRepository.save(item);

        return new CartItemResponse(saved.getId(), saved.getQuantity(), product);
    }

    public List<CartItemResponse> getCart(UUID userId) {
        List<CartItem> items = cartItemRepository.findByUserId(userId);

        return items.stream()
                .map(item -> {
                    ProductResponse product = productWebClient.get()
                            .uri("/products/{id}", item.getProductId())
                            .retrieve()
                            .bodyToMono(ProductResponse.class)
                            .block();

                    return new CartItemResponse(item.getId(), item.getQuantity(), product);
                })
                .toList();
    }

    public void removeItem(UUID userId, UUID cartItemId) {
        cartItemRepository.deleteByIdAndUserId(cartItemId, userId);
    }
}