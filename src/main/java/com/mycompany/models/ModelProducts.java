package com.mycompany.models;

public class ModelProducts {

    private int id;
    private String name;
    private Float price;
    private String description;
    private Integer discount;

    private Integer IdBrand;
    private Integer IdCategory;
    private Integer IdType;

    private String brand;
    private String category;
    private String type;

    private String brandAvailable;
    private Integer totalExistence;
    private Float totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getIdBrand() {
        return IdBrand;
    }

    public void setIdBrand(Integer IdBrand) {
        this.IdBrand = IdBrand;
    }

    public Integer getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(Integer IdCategory) {
        this.IdCategory = IdCategory;
    }

    public Integer getIdType() {
        return IdType;
    }

    public void setIdType(Integer IdType) {
        this.IdType = IdType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrandAvailable() {
        return brandAvailable;
    }

    public void setBrandAvailable(String brandAvailable) {
        this.brandAvailable = brandAvailable;
    }

    public Integer getTotalExistence() {
        return totalExistence;
    }

    public void setTotalExistence(Integer totalExistence) {
        this.totalExistence = totalExistence;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
