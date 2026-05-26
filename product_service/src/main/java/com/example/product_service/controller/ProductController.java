package com.example.product_service.controller;

import com.example.product_service.dto.CreateProductRequest;
import com.example.product_service.dto.ProductResponse;
import com.example.product_service.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<ProductResponse> findByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid CreateProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.create(request));
    }
}