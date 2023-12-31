package com.mycompany.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Sale {

    private int id;
    private Integer clientId;
    private String clientName;
    private Integer quantitySold;
    private Float totalMoneyEarned;
    private LocalDate date;  

    
    
    public Sale() {}

    // CONSTRUCTOR PARA ADICIONAR
    public Sale(Integer clientId, Integer quantitySold, Float totalMoneyEarned, LocalDate date) {
        this.clientId = clientId;
        this.quantitySold = quantitySold;
        this.totalMoneyEarned = totalMoneyEarned;
        this.date = date;
    }

    public Sale(int id, Integer clientId, String clientName, Integer quantitySold, Float totalMoneyEarned, LocalDate date) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.quantitySold = quantitySold;
        this.totalMoneyEarned = totalMoneyEarned;
        this.date = date;
    }

}
