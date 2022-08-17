package com.electronicsstore.api.controller;

import com.electronicsstore.api.model.Product;
import com.electronicsstore.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("add")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @PutMapping("delete/{productId}")
    public boolean softDeleteProduct(@PathVariable Integer productId) {
        return productService.softDeleteProduct(productId);
    }

    @GetMapping("available")
    public List<Product> getAllAvailableProducts() {
        return productService.getAllAvailableProducts();
    }

    @GetMapping("all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("update/{productId}/{stock}")
    public void updateStock(@PathVariable Integer productId, @PathVariable Integer stock) {
        productService.updateStock(productId, stock);
    }

    @PutMapping("increment/{productId}")
    public void incrementStock(@PathVariable Integer productId) {
        productService.incrementStock(productId);
    }

    @PutMapping("decrement/{productId}")
    public void decrementStock(@PathVariable Integer productId) {
        productService.decrementStock(productId);
    }
}
