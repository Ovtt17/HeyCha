package com.mycompany.interfaces.dao;

import com.mycompany.models.Category;
import com.mycompany.models.Size;
import java.util.List;

public interface CategoryDao {
    void record(Category category, Integer categoryExample) throws Exception;
    void modify(Category category) throws Exception;
    List<Category> consult() throws Exception;
    void delete(Category category) throws Exception;
////    List<Size> loadAllCategories() throws Exception;

    void insertSizesInCategory (Integer categoryId, Integer categoryExample) throws Exception;
    List<Size> getSizes(Integer categoryId) throws Exception;
}
