package com.electronicsstore.api.controller;

import com.electronicsstore.api.model.ShoppingCart;
import com.electronicsstore.api.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PostMapping
    public ShoppingCart createShoppingCart() {
        return shoppingCartService.createShoppingCart();
    }

    @GetMapping("{shoppingCartId}")
    public Double totalPrice(@PathVariable Integer shoppingCartId) {
        return shoppingCartService.totalPrice(shoppingCartId);
    }

    @PutMapping("{productId}/{shoppingCartId}")
    public void addProduct(@PathVariable Integer shoppingCartId,
                           @PathVariable Integer productId) {
        shoppingCartService.addProduct(shoppingCartId, productId);
    }

    @DeleteMapping("{productId}/{shoppingCartId}")
    public void removeProduct(@PathVariable Integer shoppingCartId,
                              @PathVariable Integer productId) {
        shoppingCartService.removeProduct(shoppingCartId, productId);
    }
}
