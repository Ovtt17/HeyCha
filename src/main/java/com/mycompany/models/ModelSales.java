package com.mycompany.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

}
