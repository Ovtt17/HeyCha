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
    Integer categoryId;
    Integer sizeId;

    public CategorySize(Integer categoryId, Integer sizeId) {
        this.categoryId = categoryId;
        this.sizeId = sizeId;
    }

    public CategorySize(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
}
