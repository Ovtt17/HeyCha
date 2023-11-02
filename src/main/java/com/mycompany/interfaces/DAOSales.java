package com.mycompany.interfaces;

import com.mycompany.models.ModelSales;
import com.mycompany.models.ModelSalesProducts;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;

public interface DAOSales {
    public Integer record (ModelSales sale) throws Exception;
    public Integer modify (ModelSales sale) throws Exception;
    public void delete (int saleId) throws Exception;
    public List<ModelSales> consult() throws Exception;
    public ModelSales getSaleById(int saleId) throws Exception;
    
    public void loadClientsCmb(JComboBox<String> cmbClients) throws Exception;
//    public void loadFilterCmb(JComboBox<String> cmbProductsName, JComboBox<String> cmbClientsName) throws Exception;
    public void fillComboBox(Connection con, JComboBox<String> comboBox, String query) throws SQLException;
}
