package com.electronicsstore.api.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Type type;

    @NotNull
    private String name;

    @NotNull
    private Integer stock;

    @NotNull
    private boolean deleted;

    @NotNull
    private Double price;

    public Product(Type type, String name, Integer stock, boolean deleted, Double price) {
        this.type = type;
        this.name = name;
        this.stock = stock;
        this.deleted = deleted;
        this.price = price;
    }
}
