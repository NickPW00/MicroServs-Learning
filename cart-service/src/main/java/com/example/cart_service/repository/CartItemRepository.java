package com.example.cart_service.repository;

import com.example.cart_service.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

// CartItemRepository.java
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    List<CartItem> findByUserId(UUID userId);

    @Transactional
    void deleteByIdAndUserId(UUID id, UUID userId);
}
