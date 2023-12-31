package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Type {
    private Integer id;
    private String name;
    
    @Override
    public String toString() {
        return this.name;
    }
}
