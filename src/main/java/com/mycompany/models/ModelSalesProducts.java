package com.mycompany.models;

public class ModelSalesProducts {
    private Integer id;
    private Integer saleId;
    private Integer productId;
    private String productName;
    private Float priceUnity;
    private int amount;
    private Float subtotal;

    //constructor to insert
    public ModelSalesProducts(Integer saleId, Integer productId, Float priceUnity, int amount, Float subtotal) {
        this.saleId = saleId;
        this.productId = productId;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }
    
    //constructor to consult
    public ModelSalesProducts(Integer saleId, Integer productId, String productName, Float priceUnity, int amount, Float subtotal) {
        this.saleId = saleId;
        this.productId = productId;
        this.productName = productName;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
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
    
}
