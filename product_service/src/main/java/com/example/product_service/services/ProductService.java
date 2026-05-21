package com.example.product_service.services;

import com.example.product_service.dto.CreateProductRequest;
import com.example.product_service.dto.ProductResponse;
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

    public ProductResponse findById(UUID id) {
        return ProductResponse.from(
                productRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"))
        );
    }

    public ProductResponse findByName(String name) {
        return ProductResponse.from(
                productRepository.findByNameIgnoreCase(name)
                        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"))
        );
    }

    public ProductResponse create(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        return ProductResponse.from(productRepository.save(product));
    }
}