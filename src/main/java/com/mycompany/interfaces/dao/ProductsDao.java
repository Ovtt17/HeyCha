package com.mycompany.interfaces.dao;

import com.mycompany.models.Brand;
import com.mycompany.models.Category;
import com.mycompany.models.Size;
import com.mycompany.models.Type;
import com.mycompany.models.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;

public interface ProductsDao {
    Integer record (Product product) throws Exception;
    Integer modify (Product product) throws Exception;
    void delete (int productId) throws Exception;
    List<Product> consultFiltered(Product product) throws Exception;
    List<Product> consultAllProducts() throws Exception;
    Product getProductById(int productId) throws Exception;
    
    void loadComboboxByCategory(JComboBox<Category> combobox) throws Exception;
    void loadComboboxByBrand(JComboBox<Brand> combobox) throws Exception;
    
    Category loadSizes(Category categorySelected) throws Exception;
    HashMap<String, List<Type>> loadTypes() throws Exception;
}
