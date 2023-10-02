package com.mycompany.interfaces;

import com.mycompany.models.ModelProductSizes;
import java.util.List;

public interface DAOProductSizes {
    public void record (ModelProductSizes productSize) throws Exception;
    public boolean modify (ModelProductSizes productSize) throws Exception;
    public void delete (int productId) throws Exception;
    public List<ModelProductSizes> consult(int productId) throws Exception;
//    public ModelProductSizes consultBySize(int productId, String productName, String productSize) throws Exception;
    public List<ModelProductSizes> getProductSizesById(int productId) throws Exception;
    public void deleteIfZero (ModelProductSizes productSize) throws Exception;

}
