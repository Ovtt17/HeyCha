package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSalesProducts;
import com.mycompany.models.ModelSalesProducts;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOSalesProductsImpl extends Database implements DAOSalesProducts {

    @Override
    public void record(ModelSalesProducts salesProducts) throws Exception {
        try {
            String sql = "call insertSalesProducts(?, ?, ?, ?, ?);";
            final PreparedStatement st = this.getConnection().prepareStatement(sql);
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
        st.setInt(1, salesProducts.getIdSale());
        st.setInt(2, salesProducts.getIdProduct());
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelSalesProducts> consult(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelSalesProducts getSaleById(int saleId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
