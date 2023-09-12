package com.mycompany.interfaces;

import com.mycompany.models.ModelProductSizes;
import java.util.List;

public interface DAOProductSizes {
    public void record (ModelProductSizes productSize) throws Exception;
    public void modify (ModelProductSizes product) throws Exception;
    public void delete (int productId) throws Exception;
    public List<ModelProductSizes> consult() throws Exception;
    public ModelProductSizes getProductSizesById(int productSizeId) throws Exception;
}
