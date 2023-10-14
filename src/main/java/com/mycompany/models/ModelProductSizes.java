package com.mycompany.models;

public class ModelProductSizes {
    private Integer idProduct;
    private Integer idSize;
    private Integer amount;
    
    private String nameSize;
    private String nameProduct;
    
    private Float price;
    private Float totalPrice;

    //save product sizes
    public ModelProductSizes(int idProduct, String nameProduct, String nameSize, int amount) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameSize = nameSize;
        this.amount = amount;
    }   
    
    // pass product size to sale
    public ModelProductSizes(Integer idProduct, Integer amount, String nameSize, String nameProduct, Float price) {
        this.idProduct = idProduct;
        this.amount = amount;
        this.nameSize = nameSize;
        this.nameProduct = nameProduct;
        this.price = price;
        this.totalPrice = price * amount;
    }
    

    public ModelProductSizes() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNameSize() {
        return nameSize;
    }

    public void setNameSize(String nameSize) {
        this.nameSize = nameSize;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Float getPrice() {
        return price;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }
    
}
