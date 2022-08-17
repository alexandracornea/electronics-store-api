package com.electronicsstore.api.service;

import com.electronicsstore.api.model.Product;
import com.electronicsstore.api.model.ShoppingCart;
import com.electronicsstore.api.repository.ProductRepository;
import com.electronicsstore.api.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public ShoppingCart createShoppingCart() {
        return shoppingCartRepository.save(new ShoppingCart());
    }

    public Double totalPrice(Integer shoppingCartId) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);

        if (shoppingCart.isPresent()) {
            return shoppingCart.get().totalPrice();
        }
        return -1d;
    }

    public void addProduct(Integer shoppingCartId, Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);

        if (product.isPresent() && shoppingCart.isPresent()) {
            shoppingCart.get().addProduct(product.get());
        }
    }

    public void removeProduct(Integer shoppingCartId, Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);

        if (product.isPresent() && shoppingCart.isPresent()) {
            shoppingCart.get().removeProduct(product.get());
        }
    }
}
