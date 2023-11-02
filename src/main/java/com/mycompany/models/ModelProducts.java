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

    public ModelProducts(int id, String name, Float price, String sizeSelected, int amountSelected) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sizeSelected = sizeSelected;
        this.amountSelected = amountSelected;
    }

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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSizeAvailable() {
        return sizeAvailable;
    }

    public void setSizeAvailable(String sizeAvailable) {
        this.sizeAvailable = sizeAvailable;
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

    public int getAmountSelected() {
        return amountSelected;
    }

    public String getSizeSelected() {
        return sizeSelected;
    }
    
    
}
