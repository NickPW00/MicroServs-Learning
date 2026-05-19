package com.example.user_service.repository;

import com.example.user_service.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// CartItemRepository.java
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    List<CartItem> findByUserId(UUID userId);
    void deleteByIdAndUserId(UUID id, UUID userId);
}
