package com.mycompany.models;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductSize {
    Integer id;
    Integer productId;
    String productName;
    Integer sizeId;
    String sizeName;
    Integer amount;
    Float price;

    
    public ProductSize(Integer productId, Integer sizeId) {
        this.productId = productId;
        this.sizeId = sizeId;
    }

    // insert
    public ProductSize(Integer productId, Integer sizeId, Integer amount) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.amount = amount;
    }

    // modify
    public ProductSize(Integer id, Integer productId, Integer sizeId, Integer amount) {
        this.id = id;
        this.productId = productId;
        this.sizeId = sizeId;
        this.amount = amount;
    }

    public ProductSize(Integer id, Integer productId, Integer sizeId, String sizeName, Integer amount) {
        this.id = id;
        this.productId = productId;
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return sizeName;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.productId);
        hash = 83 * hash + Objects.hashCode(this.sizeId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductSize other = (ProductSize) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        return Objects.equals(this.sizeId, other.sizeId);
    }
    
}
