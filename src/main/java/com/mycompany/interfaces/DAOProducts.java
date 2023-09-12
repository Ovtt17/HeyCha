package com.mycompany.interfaces;

import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import java.util.List;

public interface DAOProducts {
    public void record (ModelProducts product, ModelProductSizes pSizes) throws Exception;
    public void modify (ModelProducts product, ModelProductSizes pSizes) throws Exception;
    public void delete (int productId) throws Exception;
    public List<ModelProducts> consult() throws Exception;
    public ModelProducts getProductById(int productId) throws Exception;
    
}
