package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Category {
    Integer id;
    String name;

    @Override
    public String toString() {
        return name;
    }
    
}
