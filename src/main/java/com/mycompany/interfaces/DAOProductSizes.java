package com.mycompany.interfaces;

import com.mycompany.models.ModelProductSizes;
import java.util.List;

public interface DAOProductSizes {
    public void record (ModelProductSizes productSize) throws Exception;
    public boolean modify (ModelProductSizes productSize) throws Exception;
    public void delete (ModelProductSizes productSize) throws Exception;
    public List<ModelProductSizes> consult(int productId) throws Exception;
    public void deleteIfZero (ModelProductSizes productSize) throws Exception;

}
