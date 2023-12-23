package com.mycompany.models;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSizes {

    private Integer id;
    private Integer productId;
    private Integer sizeId;
    private Integer price;
    private Integer amount;

    private String sizeName;
    private String productName;

    public ProductSizes() {
    }

    //save product sizes
    public ProductSizes(Integer productId, Integer sizeId, Integer amount) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.amount = amount;
    }

    public ProductSizes(Integer productId, Integer sizeId, Integer amount, String sizeName) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.amount = amount;
        this.sizeName = sizeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductSizes that = (ProductSizes) obj;
        return productId.equals(that.productId)
                && sizeId.equals(that.sizeId)
                && sizeName.equals(that.sizeName)
                && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sizeId, sizeName, amount);
    }

}
