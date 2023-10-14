package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSales;
import com.mycompany.models.ModelSales;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class DAOSalesImpl extends Database implements DAOSales {

    @Override
    public Integer record(ModelSales sale) throws Exception {
        Integer idSale = null;
        try {
            this.connectDB();
            String query = "{call insertSale(?, ?, ?, ?, ?)}";
            CallableStatement cst = this.connection.prepareCall(query);
            cst.registerOutParameter(1, java.sql.Types.INTEGER);  // Registrar el primer parámetro como OUT
            setSalesFieldsToInsert(cst, sale);
            cst.execute();

            idSale = cst.getInt(1);  // Obtener el valor del primer parámetro

            cst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return idSale;
    }

    private void setSalesFieldsToInsert(CallableStatement cst, ModelSales sale) throws SQLException {
        cst.setInt(2, sale.getClientId() != null ? sale.getClientId() : 0);
        cst.setDate(3, java.sql.Date.valueOf(sale.getDate()));
        cst.setInt(4, sale.getQuantitySold());
        cst.setFloat(5, sale.getTotalMoneySold());

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
    public List<ModelSales> consult() throws Exception {
        List<ModelSales> list = null;
        try {
            this.connectDB();
            String query = "call consultSales();";
            PreparedStatement pst = this.connection.prepareStatement(query);

            list = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModelSales sale = setSalesFieldsToConsult(rs);
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

    private ModelSales setSalesFieldsToConsult(ResultSet rs) throws SQLException {
        Integer saleId = rs.getInt("ID_VENTA");
        Integer clientId = rs.getInt("ID_CLIENTE");
        String clientName = rs.getString("NOMBRE_CLIENTE");
        LocalDate date = rs.getObject("FECHA", LocalDate.class);
        Integer quantitySold = rs.getInt("CANTIDAD_VENDIDA");
        Float totalMoneySold = rs.getFloat("TOTAL");

        return new ModelSales(saleId, clientId, clientName, quantitySold, totalMoneySold, date);

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
        while (rs.next()) {
            comboBox.addItem(rs.getString(1));
        }
        pst.close();
        rs.close();
        comboBox.setSelectedIndex(-1);
        AutoCompleteDecorator.decorate(comboBox);
    }

}
