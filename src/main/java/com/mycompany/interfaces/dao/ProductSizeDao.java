package com.mycompany.interfaces.dao;

import com.mycompany.models.ProductSize;
import java.util.List;

public interface ProductSizeDao {
    boolean record (ProductSize productSize) throws Exception;
    boolean modify (ProductSize productSize) throws Exception;
    void deleteAllSizes (int productId) throws Exception;
    List<ProductSize> consult(int productId) throws Exception;
    List<ProductSize> getProductSizesById(int productId) throws Exception;
    void delete (ProductSize productSize) throws Exception;

}
