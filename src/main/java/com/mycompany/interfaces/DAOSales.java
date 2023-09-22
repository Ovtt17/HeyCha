package com.mycompany.interfaces;

import com.mycompany.models.ModelSales;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;

public interface DAOSales {
    public void record (ModelSales sale) throws Exception;
    public void modify (ModelSales sale) throws Exception;
    public void delete (int saleId) throws Exception;
    public List<ModelSales> consult(String name) throws Exception;
    public ModelSales getSaleById(int saleId) throws Exception;
    
    public void loadCmb(JComboBox<String> cmbProductsName, JComboBox<String> cmbClientsName) throws Exception;
//    public void loadFilterCmb(JComboBox<String> cmbProductsName, JComboBox<String> cmbClientsName) throws Exception;
    public void fillComboBox(JComboBox<String> comboBox, String query) throws SQLException;
}
