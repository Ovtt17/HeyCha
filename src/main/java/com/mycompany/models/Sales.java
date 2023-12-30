package com.mycompany.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Sales {

    private int id;
    private Integer clientId;
    private String clientName;
    private Integer quantitySold;
    private Float totalMoneySold;
    private LocalDate date;  

    
    
    public Sales() {}

    // CONSTRUCTOR PARA ADICIONAR
    public Sales(Integer clientId, Integer quantitySold, Float totalMoneySold, LocalDate date) {
        this.clientId = clientId;
        this.quantitySold = quantitySold;
        this.totalMoneySold = totalMoneySold;
        this.date = date;
    }

    public Sales(int id, Integer clientId, String clientName, Integer quantitySold, Float totalMoneySold, LocalDate date) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.quantitySold = quantitySold;
        this.totalMoneySold = totalMoneySold;
        this.date = date;
    }

}
