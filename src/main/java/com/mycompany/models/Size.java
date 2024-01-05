package com.mycompany.models;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Size {

    Integer id;
    Integer productId;
    Integer sizeId;
    Integer price;
    Integer amount;

    String sizeName;
    String productName;
    
    public Size() {
    }

    //save product sizes
    public Size(Integer productId, Integer sizeId, Integer amount) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.amount = amount;
    }

    // edit sizes
    public Size(Integer productId, Integer sizeId, Integer amount, String sizeName) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.amount = amount;
        this.sizeName = sizeName;
    }

    
    public Size(Integer sizeId, String sizeName) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
    }

    @Override
    public String toString() {
        return this.sizeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Size that = (Size) obj;
        return (productId == null ? that.productId == null : productId.equals(that.productId))
                && (sizeId == null ? that.sizeId == null : sizeId.equals(that.sizeId))
                && (sizeName == null ? that.sizeName == null : sizeName.equals(that.sizeName))
                && (amount == null ? that.amount == null : amount.equals(that.amount));
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sizeId, sizeName, amount);
    }
}
