package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSales;
import com.mycompany.models.ModelSales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class DAOSalesImpl extends Database implements DAOSales {

    @Override
    public void record(ModelSales sale) throws Exception {
        try {
            this.connectDB();
            String query = "call insertSale(?,?,?,?);";
            PreparedStatement pst = this.connection.prepareStatement(query);
            setSalesFieldsToInsert(pst, sale);
        } catch (Exception e) {
        } finally {
        }
    }

    private void setSalesFieldsToInsert(PreparedStatement pst, ModelSales sale) throws SQLException {
        pst.setInt(1, sale.getProductId());
        pst.setInt(2, sale.getClientId());
        pst.setInt(3, sale.getQuantitySold());
        LocalDate date = LocalDate.now();
    }

    @Override
    public void modify(ModelSales sale) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int saleId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelSales> consult(String name) throws Exception {
        List<ModelSales> list = null;
        try {
            this.connectDB();
            String query = "call consultSales(?);";
            PreparedStatement pst = this.connection.prepareStatement(query);
            pst.setString(1, name);
            list = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModelSales sale = new ModelSales();
                setSalesFieldsToConsult(rs, sale);
                list.add(sale);
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return list;
    }

    private void setSalesFieldsToConsult(ResultSet rs, ModelSales sale) throws SQLException {
        sale.setId(rs.getInt("ID_VENTA"));
        sale.setProductName(rs.getString("NOMBRE_PRODUCTO"));
        sale.setProductId(rs.getInt("ID_PRODUCTO"));
        sale.setClientName(rs.getString("NOMBRE_CLIENTE"));
        sale.setProductPrice(rs.getFloat("PRECIO"));
        sale.setQuantitySold(rs.getInt("CANTIDAD_VENDIDA"));
        sale.setTotalMoneySold(rs.getFloat("TOTAL"));
        sale.setDate(rs.getObject("FECHA", LocalDate.class));
    }

    @Override
    public ModelSales getSaleById(int saleId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void loadCmb(JComboBox<String> cmbProductsName, JComboBox<String> cmbClientsName) throws Exception {
        try {
            this.connectDB();
            String queryProductsName = "select nombre from productos order by id;";
            String queryClientName = "select nombre from clientes order by id;";
            fillComboBox(cmbProductsName, queryProductsName);
            fillComboBox(cmbClientsName, queryClientName);
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public void fillComboBox(JComboBox<String> comboBox, String query) throws SQLException {
        PreparedStatement pst = this.connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            comboBox.addItem(rs.getString(1));
        }
        pst.close();
        rs.close();
        comboBox.setSelectedIndex(-1);
        AutoCompleteDecorator.decorate(comboBox);
    }

}
