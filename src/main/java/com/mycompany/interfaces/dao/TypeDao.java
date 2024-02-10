
package com.mycompany.interfaces.dao;

import com.mycompany.models.Category;
import com.mycompany.models.Type;
import java.util.List;

public interface TypeDao {
    void record(Type type)throws Exception;
    void modify(Type type)throws Exception;
    List<Type> consultByCategory(Category category) throws Exception;
    void delete(Type type)throws Exception;
}
