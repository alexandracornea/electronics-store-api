package com.electronicsstore.api.service;

import com.electronicsstore.api.model.Product;
import com.electronicsstore.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean softDeleteProduct(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            return false; // product does not exist, deletion not succeed
        }
        if (product.get().isDeleted()) {
            return false; // product already deleted, deletion not succeed
        }
        product.get().setDeleted(true);
        productRepository.save(product.get());
        return true; // product successfully deleted
    }

    public List<Product> getAllAvailableProducts() {
        return productRepository.findAll().stream()
                .filter(product -> !product.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateStock(Integer productId, Integer stock) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            return;
        }
        product.get().setStock(stock);
        productRepository.save(product.get());
    }

    public void incrementStock(Integer productId) {
        productRepository.incrementStock(productId);
    }

    public void decrementStock(Integer productId) {
        productRepository.decrementStock(productId);
    }
}
