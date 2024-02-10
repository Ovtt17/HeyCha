package com.mycompany.models;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter
public class ReservationDetail {
    private Integer id;
    private Integer reservationId;
    private Integer productSizeId;
    private Integer productId;
    private String productName;
    private Integer sizeId;
    private String sizeName;
    private Float priceUnity;
    private Integer amount;
    private Float subtotal;

    //constructor for inserting
    public ReservationDetail(Integer reservationId, Integer productSizeId, Float priceUnity, Integer amount, Float subtotal) {
        this.reservationId = reservationId;
        this.productSizeId = productSizeId;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    //constructor for consulting
    public ReservationDetail(Integer id, Integer productSizeId, Integer reservationId, Integer productId, String productName, String sizeName, Float priceUnity, Integer amount, Float subtotal) {
        this.id = id;
        this.productSizeId = productSizeId;
        this.reservationId = reservationId;
        this.productId = productId;
        this.productName = productName;
        this.sizeName = sizeName;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    //constructor for adding to shopping cart
    public ReservationDetail(Integer productSizeId, Integer productId, String productName, String sizeName, Float price, Integer amount) {
        this.productSizeId = productSizeId;
        this.productId = productId;
        this.productName = productName;
        this.sizeName = sizeName;
        this.priceUnity = price;
        this.amount = amount;
        this.subtotal = this.amount * this.priceUnity;
    }
}
