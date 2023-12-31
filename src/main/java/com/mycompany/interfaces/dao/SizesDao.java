package com.mycompany.interfaces.dao;

import com.mycompany.models.Size;
import java.util.List;

public interface SizesDao {
    boolean record (Size productSize) throws Exception;
    boolean modify (Size productSize) throws Exception;
    void deleteAllSizes (int productId) throws Exception;
    List<Size> consult(int productId) throws Exception;
    List<Size> getProductSizesById(int productId) throws Exception;
    void delete (Size productSize) throws Exception;

}
