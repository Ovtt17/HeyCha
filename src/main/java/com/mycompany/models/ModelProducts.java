package com.mycompany.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ModelProducts {

    private int id;
    private String name;
    private Float price;
    private String description;
    private Integer discount;

    private Integer IdBrand;
    private Integer IdCategory;
    private Integer IdType;
    
    private String brandName;
    private String categoryName;
    private String typeName;

    private String sizeAvailable;
    private Integer totalExistence;
    private Float totalPrice;
    
    private int amountSelected;
    private String sizeSelected;

    public ModelProducts() {
    }
    
    // save new product
    public ModelProducts(String name, Float price, String description, Integer discount, Integer IdBrand, Integer IdCategory, Integer IdType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.IdBrand = IdBrand;
        this.IdCategory = IdCategory;
        this.IdType = IdType;
    }

    //consult product
    public ModelProducts(Integer id, String name, Float price, String description, Integer discount, String brand, String category, String type, String brandAvailable, Integer totalExistence, Float totalPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.brandName = brand;
        this.categoryName = category;
        this.typeName = type;
        this.sizeAvailable = brandAvailable;
        this.totalExistence = totalExistence;
        this.totalPrice = totalPrice;
    }

//    public ModelProducts(int id, String name, Float price, String sizeSelected, int amountSelected) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.sizeSelected = sizeSelected;
//        this.amountSelected = amountSelected;
//    }

    // return all query from database
    public ModelProducts(Integer id, String name, Float price, String description, Integer discount, Integer brandId, Integer categoryId, Integer typeId, String brandName, String categoryName, String typeName, String brandAvailable, Integer totalExistence, Float totalPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.IdBrand = brandId;
        this.IdCategory = categoryId;
        this.IdType = typeId;
        this.brandName = brandName;
        this.categoryName = categoryName;
        this.typeName = typeName;
        this.sizeAvailable = brandAvailable;
        this.totalExistence = totalExistence;
        this.totalPrice = totalPrice;
    }
}
