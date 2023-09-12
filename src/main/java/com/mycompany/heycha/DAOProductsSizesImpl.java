package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProductSizes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class DAOProductsSizesImpl extends Database implements DAOProductSizes {

    @Override
    public void record(ModelProductSizes productSize) throws Exception {
        try {
            this.connectDB();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO PRODUCTOS_TALLAS(ID_PRODUCTO, ID_TALLA, CANTIDAD_INVENTARIO) VALUES (?,?,?);");
            sendProductsSizesFieldsToDB(st, productSize);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }
     private void sendProductsSizesFieldsToDB(PreparedStatement st, ModelProductSizes productSize) throws SQLException {
        st.setInt(1, productSize.getIdProduct());
        st.setInt(2, productSize.getIdSize());
        st.setInt(3, productSize.getAmount());
    }

    @Override
    public void modify(ModelProductSizes product) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int productId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelProductSizes> consult() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelProductSizes getProductSizesById(int productSizeId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
