package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Size {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return this.name;
    }
    
}
