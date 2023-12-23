package com.mycompany.interfaces;

import com.mycompany.models.ProductSizes;
import java.util.List;

public interface DAOProductSizes {
    boolean record (ProductSizes productSize) throws Exception;
    boolean modify (ProductSizes productSize) throws Exception;
    void deleteAllSizes (int productId) throws Exception;
    List<ProductSizes> consult(int productId) throws Exception;
    List<ProductSizes> getProductSizesById(int productId) throws Exception;
    void delete (ProductSizes productSize) throws Exception;

}
