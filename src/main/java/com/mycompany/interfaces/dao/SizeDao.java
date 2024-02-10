package com.mycompany.interfaces.dao;

import com.mycompany.models.Category;
import com.mycompany.models.Size;
import java.util.List;

public interface SizeDao {
    void record (Size size) throws Exception;
    void modify (Size size) throws Exception;
    boolean delete (Size sizeId) throws Exception;

    List<Category> getCategoriesBySizeSelected(Integer id) throws Exception;
}
 