package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CategorySize {
    Integer id;
    Category category;
    Size size;

    public CategorySize(Category category, Size size) {
        this.category = category;
        this.size = size;
    }    
}
