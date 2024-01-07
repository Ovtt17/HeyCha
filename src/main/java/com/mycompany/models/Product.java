package com.mycompany.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {

    private Integer id;
    private String name;
    private Float price;
    private String description;
    private Integer discount;

    Brand brand;
    Category category;
    Type type;

    private String sizeAvailable;
    private Integer totalExistence;
    private Float totalPrice;
    
    List<ProductSize> productSizeList;

    public Product() {
    }

    // insert
    public Product(String name, Float price, String description, Integer discount, Brand brand, Category category, Type type) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.brand = brand;
        this.category = category;
        this.type = type;
    }

    // consult
    public Product(Integer id, String name, Float price, String description, Integer discount, Brand brand, Category category, Type type, String sizeAvailable, Integer totalExistence, Float totalPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.brand = brand;
        this.category = category;
        this.type = type;
        this.sizeAvailable = sizeAvailable;
        this.totalExistence = totalExistence;
        this.totalPrice = totalPrice;
    }    
    
}
