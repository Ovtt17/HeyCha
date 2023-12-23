package com.mycompany.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CategorySize {
    private Integer id;
    private Integer categoryId;
    private Integer sizeId;

    public CategorySize(Integer categoryId, Integer sizeId) {
        this.categoryId = categoryId;
        this.sizeId = sizeId;
    }

    public CategorySize() {
    }
    
}
