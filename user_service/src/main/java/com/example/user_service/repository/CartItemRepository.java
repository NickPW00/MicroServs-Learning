package com.example.user_service.repository;
// CartItemRepository.java
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    List<CartItem> findByUserId(UUID userId);
    void deleteByIdAndUserId(UUID id, UUID userId);
}
