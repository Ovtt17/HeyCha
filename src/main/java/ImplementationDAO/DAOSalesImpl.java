package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSales;
import com.mycompany.models.ModelSales;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class DAOSalesImpl extends Database implements DAOSales {

    @Override
    public Integer record(ModelSales sale) throws Exception {
        Integer idSale = null;
        try (Connection con = this.getConnection()) {
            String query = "{call insertSale(?, ?, ?, ?, ?)}";
            final CallableStatement cst = con.prepareCall(query);
            try (cst) {
                cst.registerOutParameter(1, java.sql.Types.INTEGER);  // Registrar el primer parámetro como OUT
                setSalesFieldsToInsert(cst, sale);
                cst.execute();

                idSale = cst.getInt(1);  // Obtener el valor del primer parámetro
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
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
    public Integer modify(ModelSales sale) throws Exception {
        Integer saleId = null;
        try (Connection con = this.getConnection()) {
            String query = "call modificar_venta(?, ?, ?);";
            final PreparedStatement ps = con.prepareStatement(query);
            try (ps) {
                setSalesFieldsToModify(ps, sale);
                ps.executeUpdate();
                saleId = sale.getId();
            }
        }
        return saleId;
    }

    private void setSalesFieldsToModify(PreparedStatement cst, ModelSales sale) {
        try {
            cst.setInt(1, sale.getQuantitySold());
            cst.setFloat(2, sale.getTotalMoneySold());
            cst.setInt(3, sale.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DAOSalesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int saleId) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call deleteSales(?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, saleId);
                ps.execute();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<ModelSales> consult() throws Exception {
        List<ModelSales> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultSales();";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                list = new ArrayList();
                final ResultSet rs = pst.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ModelSales sale = setSalesFieldsToConsult(rs);
                        list.add(sale);
                    }
                }

            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
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
        ModelSales sale = null;
        try (Connection con = this.getConnection()) {
            String sql = "call consultSalesById(?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, saleId);
                final ResultSet rs = ps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        sale = setSalesFieldsToConsult(rs);
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return sale;
    }

    @Override
    public void loadClientsCmb(JComboBox<String> cmbClients) throws Exception {
        try (Connection con = this.getConnection()) {
            String queryClientsName = "select nombre from clientes order by id;";
            fillComboBox(con, cmbClients, queryClientsName);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar los ComboBox en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void fillComboBox(Connection con, JComboBox<String> comboBox, String query) throws SQLException {
        final PreparedStatement pst = con.prepareStatement(query);
        try (pst) {
            final ResultSet rs = pst.executeQuery();
            try (rs) {
                while (rs.next()) {
                    comboBox.addItem(rs.getString(1));
                }
            }
            comboBox.setSelectedIndex(0);
            AutoCompleteDecorator.decorate(comboBox);
        }
    }

}
