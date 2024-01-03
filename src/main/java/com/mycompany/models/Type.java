package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Type {
    Integer id;
    String name;
    Integer categoryId;

    public Type(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    
    @Override
    public String toString() {
        return this.name;
    }
}
