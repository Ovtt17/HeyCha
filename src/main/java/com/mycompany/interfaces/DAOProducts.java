package com.mycompany.interfaces;

import com.mycompany.db.Database;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JComboBox;

public interface DAOProducts {
    public void record (ModelProducts product, ModelProductSizes pSizes) throws Exception;
    public void modify (ModelProducts product, ModelProductSizes pSizes) throws Exception;
    public void delete (int productId) throws Exception;
    public List<ModelProducts> consult() throws Exception;
    public ModelProducts getProductById(int productId) throws Exception;
    
    /**
     * obteniendo datos desde la base de datos para llenar los campos para agregar productos.
     * @param brandCmb
     * @param categoryCmb
     * @param typeCmb
     * @throws Exception 
     */
    public void loadCmb(JComboBox<String> brandCmb, JComboBox<String> categoryCmb, JComboBox<String> typeCmb) throws Exception;
    public void fillComboBox(JComboBox<String> comboBox, String query) throws SQLException;

}
