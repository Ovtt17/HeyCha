package com.mycompany.models;

import java.time.temporal.TemporalQueries;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleDetail {
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
    public SaleDetail(Integer saleId, Integer productSizeId, Float priceUnity, int amount, Float subtotal) {
        this.saleId = saleId;
        this.productSizeId = productSizeId;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    //constructor for consulting
    public SaleDetail(Integer id, Integer productSizeId, Integer saleId, Integer productId, String productName, String sizeName, Float priceUnity, Integer amount, Float subtotal) {
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
    public SaleDetail(Integer productSizeId, Integer productId, String productName, String sizeName, Float price, Integer amount) {
        this.productSizeId = productSizeId;
        this.productId = productId;
        this.productName = productName;
        this.sizeName = sizeName;
        this.priceUnity = price;
        this.amount = amount;
        this.subtotal = this.amount * this.priceUnity;
    }
}
