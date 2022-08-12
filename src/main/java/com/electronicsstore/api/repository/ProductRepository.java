package com.electronicsstore.api.repository;

import com.electronicsstore.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Product product set product.stock = product.stock + 1 WHERE product.id = :productId")
    void incrementStock(Integer productId);

    @Transactional
    @Modifying
    @Query("UPDATE Product product set product.stock = product.stock - 1 WHERE product.id = :productId")
    void decrementStock(Integer productId);
}
