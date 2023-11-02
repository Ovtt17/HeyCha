package com.mycompany.models;

import java.time.temporal.TemporalQueries;

public class ModelSalesProducts {

    private Integer id;
    private Integer saleId;
    private Integer productSizeId;
    private Integer productId;
    private String productName;
    private Integer sizeId;
    private String sizeName;
    private Float priceUnity;
    private int amount;
    private Float subtotal;

    //constructor to inserting
    public ModelSalesProducts(Integer saleId, Integer productSizeId, Float priceUnity, int amount, Float subtotal) {
        this.saleId = saleId;
        this.productSizeId = productSizeId;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    //constructor for consulting
    public ModelSalesProducts(Integer id, Integer productSizeId, Integer saleId, Integer productId, String productName, String sizeName, Float priceUnity, Integer amount, Float subtotal) {
        this.id = id;
        this.productSizeId = productSizeId;
        this.saleId = saleId;
        this.productId = productId;
        this.productName = productName;
        this.sizeName = sizeName;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    //constructor for adding to shopping cart
    public ModelSalesProducts(Integer productSizeId, Integer productId, String productName, String sizeName, Float price, Integer amount) {
        this.productSizeId = productSizeId;
        this.productId = productId;
        this.productName = productName;
        this.sizeName = sizeName;
        this.priceUnity = price;
        this.amount = amount;
        this.subtotal = this.amount * this.priceUnity;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public Float getPriceUnity() {
        return priceUnity;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public String getProductName() {
        return productName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public Integer getProductSizeId() {
        return productSizeId;
    }

}
