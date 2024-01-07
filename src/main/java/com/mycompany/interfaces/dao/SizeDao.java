package com.mycompany.interfaces.dao;

import com.mycompany.models.Category;
import com.mycompany.models.Size;
import java.util.List;

public interface SizeDao {
    void record (Size size) throws Exception;
    Integer modify (Size size) throws Exception;
    void delete (Integer sizeId) throws Exception;

    List<Category> getCategoriesBySizeSelected(Integer id) throws Exception;
}
 