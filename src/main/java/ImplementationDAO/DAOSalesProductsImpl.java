package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOSalesProducts;
import com.mycompany.models.ModelSalesProducts;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOSalesProductsImpl extends Database implements DAOSalesProducts{

    @Override
    public void record(ModelSalesProducts salesProducts) throws Exception {
        try {
            this.connectDB();
            String sql = "call insertSalesProducts(?, ?, ?, ?, ?);";
            final PreparedStatement st = this.connection.prepareStatement(sql);
            try (st) {
                setFieldsToInsert(st, salesProducts);
                st.execute();
            } 
        } catch (SQLException e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }
    private void setFieldsToInsert(PreparedStatement st, ModelSalesProducts salesProducts) throws SQLException {
        st.setInt(1, salesProducts.getIdSale());
        st.setInt(2,salesProducts.getIdProduct());
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
