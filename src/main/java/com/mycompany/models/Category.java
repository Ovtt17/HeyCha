package com.mycompany.models;

import java.util.List;
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
    List<Size> size;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }    

    
    @Override
    public String toString() {
        return name;
    }

    
}
