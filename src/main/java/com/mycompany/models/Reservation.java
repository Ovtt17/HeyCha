package com.mycompany.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Reservation {
    private int id;
    private Integer clientId;
    private String clientName;
    private LocalDate date;  
    private Integer quantitySold;
    private Float paid;
    private Float remaining;
    private Float totalMoneyEarned;
    
    
    public Reservation() {}

    // CONSTRUCTOR PARA ADICIONAR

    public Reservation(int id, Integer clientId, LocalDate date, Integer quantitySold, Float paid, Float totalMoneyEarned) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.quantitySold = quantitySold;
        this.paid = paid;
        this.totalMoneyEarned = totalMoneyEarned;
    }
    

    // CONSTRUCTOR PARA GUARDAR CONSULTA
    public Reservation(int id, Integer clientId, String clientName, LocalDate date, Integer quantitySold, Float paid, Float totalMoneyEarned) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.date = date;
        this.quantitySold = quantitySold;
        this.paid = paid;
        this.totalMoneyEarned = totalMoneyEarned;
        this.remaining = totalMoneyEarned - paid;
    }
    
}
