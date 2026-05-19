package com.example.product_service.services;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    public Product findByName(String name) {
        return productRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }
}
