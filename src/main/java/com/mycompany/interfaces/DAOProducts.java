package com.mycompany.interfaces;

import com.mycompany.models.Category;
import com.mycompany.models.Size;
import com.mycompany.models.ProductSizes;
import com.mycompany.models.ModelProducts;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;

public interface DAOProducts {
    Integer record (ModelProducts product) throws Exception;
    Integer modify (ModelProducts product) throws Exception;
    void delete (int productId) throws Exception;
    List<ModelProducts> consult(String name, String brand, String category) throws Exception;
    ModelProducts getProductById(int productId) throws Exception;
    
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
