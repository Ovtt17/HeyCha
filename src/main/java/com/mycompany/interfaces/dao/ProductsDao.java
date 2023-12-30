package com.mycompany.interfaces.dao;

import com.mycompany.models.Size;
import com.mycompany.models.Products;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;

public interface ProductsDao {
    Integer record (Products product) throws Exception;
    Integer modify (Products product) throws Exception;
    void delete (int productId) throws Exception;
    List<Products> consult(String name, String brand, String category) throws Exception;
    Products getProductById(int productId) throws Exception;
    
    /**
     * obteniendo datos desde la base de datos para llenar los campos para agregar productos.
     * @param brandCmb
     * @param categoryCmb
     * @param typeCmb
     * @throws Exception 
     */
    void loadCmb(JComboBox<String> brandCmb, JComboBox<String> categoryCmb, JComboBox<String> typeCmb) throws Exception;
    void loadFilterCmb(JComboBox<String> BrandFilterCmb, JComboBox<String> CategoryFilterCmb) throws Exception;
    void fillComboBox(Connection con, JComboBox<String> comboBox, String query) throws SQLException;
    HashMap<String, List<Size>> loadSizes() throws SQLException;
}
