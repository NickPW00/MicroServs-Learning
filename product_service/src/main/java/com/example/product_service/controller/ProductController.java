package com.example.product_service.controller;

import com.example.product_service.dto.ProductDTOResponse;
import com.example.product_service.model.Product;
import com.example.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDTOResponse findById(@PathVariable UUID id) {
        return ProductDTOResponse.from(productService.findById(id));
    }

    @GetMapping
    public ProductDTOResponse findByName(@RequestParam String name) {
        return ProductDTOResponse.from(productService.findByName(name));
    }
}
