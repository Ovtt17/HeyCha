package com.mycompany.interfaces.dao;

import com.mycompany.models.Size;
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
    List<Product> consult(String name, String brand, String category) throws Exception;
    Product getProductById(int productId) throws Exception;
    
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
