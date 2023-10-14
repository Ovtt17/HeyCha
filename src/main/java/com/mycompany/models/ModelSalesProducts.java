package com.mycompany.models;

public class ModelSalesProducts {
    private Integer id;
    private Integer idSale;
    private Integer idProduct;
    private Float priceUnity;
    private int amount;
    private Float subtotal;

    public ModelSalesProducts(Integer idSale, Integer idProduct, Float priceUnity, int amount, Float subtotal) {
        this.idSale = idSale;
        this.idProduct = idProduct;
        this.priceUnity = priceUnity;
        this.amount = amount;
        this.subtotal = subtotal;
    }
    

    public Integer getId() {
        return id;
    }

    public Integer getIdSale() {
        return idSale;
    }

    public Integer getIdProduct() {
        return idProduct;
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
    
}
