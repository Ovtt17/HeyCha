package com.mycompany.interfaces.dao;

import com.mycompany.models.Brand;
import java.util.List;
import javax.swing.JComboBox;

public interface BrandDao {
    void record (Brand brand) throws Exception;
    void modify (Brand brand) throws Exception;
    List<Brand> consult () throws Exception;
    void delete (Brand brand) throws Exception;
    
    void loadCombobox(JComboBox<Brand> combobox) throws Exception;
}
