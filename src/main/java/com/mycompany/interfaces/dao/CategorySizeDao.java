package com.mycompany.interfaces.dao;

import com.mycompany.models.CategorySize;

public interface CategorySizeDao {
    boolean record(CategorySize categorySize) throws Exception;
    boolean delete(CategorySize categorySize) throws Exception;
}
