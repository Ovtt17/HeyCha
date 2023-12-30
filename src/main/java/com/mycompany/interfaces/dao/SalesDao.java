package com.mycompany.interfaces.dao;

import com.mycompany.models.Sales;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javax.swing.JComboBox;

public interface SalesDao {
    public Integer record (Sales sale) throws Exception;
    public Integer modify (Sales sale) throws Exception;
    public void delete (int saleId) throws Exception;
    public List<Sales> consult(Date date) throws Exception;
    public Sales getSaleById(int saleId) throws Exception;
    
    public void loadClientsCmb(JComboBox<String> cmbClients) throws Exception;
//    public void loadFilterCmb(JComboBox<String> cmbProductsName, JComboBox<String> cmbClientsName) throws Exception;
    public void fillComboBox(Connection con, JComboBox<String> comboBox, String query) throws SQLException;
}
