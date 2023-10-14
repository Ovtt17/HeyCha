package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSalesProducts;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelSalesProducts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOSalesProductsImpl extends Database implements DAOSalesProducts {

    @Override
    public void record(ModelSalesProducts salesProducts) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call insertSalesProducts(?, ?, ?, ?, ?);";
            final PreparedStatement st = con.prepareStatement(sql);
            try (st) {
                setFieldsToInsert(st, salesProducts);
                st.execute();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación en la base de datos", e);
            throw e;
        }
    }

    private void setFieldsToInsert(PreparedStatement st, ModelSalesProducts salesProducts) throws SQLException {
        st.setInt(1, salesProducts.getSaleId());
        st.setInt(2, salesProducts.getProductId());
        st.setFloat(3, salesProducts.getPriceUnity());
        st.setInt(4, salesProducts.getAmount());
        st.setFloat(5, salesProducts.getSubtotal());
    }

    @Override
    public void modify(ModelSalesProducts sale) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int saleId) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call deleteSaleProducts(?);";
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
    public List<ModelSalesProducts> consult(int saleId) throws Exception {
        List<ModelSalesProducts> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultSalesProducts(?);";
            final PreparedStatement st = con.prepareStatement(query);
            try (st) {
                st.setInt(1, saleId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ModelSalesProducts salesProducts = setSalesProductsForConsult(rs);
                        list.add(salesProducts);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
        return list;
    }

    private ModelSalesProducts setSalesProductsForConsult(ResultSet rs) {
        ModelSalesProducts sp = null;
        try {
            Integer saleId = rs.getInt("id_venta");
            Integer productId = rs.getInt("id_producto");
            String productName = rs.getString("nombre_producto");
            Float priceUnity = rs.getFloat("precio_unidad");
            Integer amount = rs.getInt("cantidad");
            Float subtotal = rs.getFloat("subtotal");
            sp = new ModelSalesProducts(saleId, productId, productName, priceUnity, amount, subtotal);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSalesProductsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }

    @Override
    public ModelSalesProducts getSaleById(int saleId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
