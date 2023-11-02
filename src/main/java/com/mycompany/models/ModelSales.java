package com.mycompany.models;

import java.time.LocalDate;

public class ModelSales {

    private int id;
    private Integer clientId;
    private String clientName;
    private Integer quantitySold;
    private Float totalMoneySold;
    private LocalDate date;  

    
    
    public ModelSales() {}

    // CONSTRUCTOR PARA ADICIONAR
    public ModelSales(Integer clientId, Integer quantitySold, Float totalMoneySold, LocalDate date) {
        this.clientId = clientId;
        this.quantitySold = quantitySold;
        this.totalMoneySold = totalMoneySold;
        this.date = date;
    }

    public ModelSales(int id, Integer clientId, String clientName, Integer quantitySold, Float totalMoneySold, LocalDate date) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.quantitySold = quantitySold;
        this.totalMoneySold = totalMoneySold;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public Float getTotalMoneySold() {
        return totalMoneySold;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void setTotalMoneySold(Float totalMoneySold) {
        this.totalMoneySold = totalMoneySold;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }   

}
