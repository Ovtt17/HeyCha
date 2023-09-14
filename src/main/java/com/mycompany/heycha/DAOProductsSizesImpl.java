package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOProductsSizesImpl extends Database implements DAOProductSizes {

    @Override
    public void record(ModelProductSizes productSize) throws Exception {
        try {
            this.connectDB();
            String query = "INSERT INTO PRODUCTOS_TALLAS(ID_PRODUCTO, ID_TALLA, CANTIDAD_INVENTARIO) VALUES (?,?,?);";
            PreparedStatement st = this.connection.prepareStatement(query);
            sendRecordedFields(st, productSize);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }
    private void sendRecordedFields(PreparedStatement st, ModelProductSizes productSize) throws SQLException {
         st.setInt(1, productSize.getIdProduct());
         st.setInt(2, productSize.getIdSize());
         st.setInt(3, productSize.getAmount());
    }

    private void sendModifiedFields(PreparedStatement st, ModelProductSizes productSize) throws SQLException {
        st.setInt(1, productSize.getAmount());
        st.setInt(2, productSize.getIdProduct());
        st.setInt(3, productSize.getIdSize());
    }

    @Override
    public boolean modify(ModelProductSizes productSize) throws Exception {
        boolean isModified = false;
        try {
            this.connectDB();
            String query = "UPDATE PRODUCTOS_TALLAS SET CANTIDAD_INVENTARIO = ? WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            PreparedStatement st = this.connection.prepareStatement(query);
            sendModifiedFields(st, productSize);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                isModified = true;
            }
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return isModified;
    }

    @Override
    public void delete(int productId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelProductSizes> consult(int productId) throws Exception {
        List<ModelProductSizes> list = null;
        try {
            this.connectDB();
            String query = "SELECT * FROM productos_tallas WHERE ID_Producto = ?;";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, productId);
            list = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ModelProductSizes pSize = new ModelProductSizes();
                setProductSizesForConsult(rs, pSize);
                list.add(pSize);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return list;
    }

    @Override
    public ModelProductSizes getProductSizesById(int productId) throws Exception {
        ModelProductSizes pSize = new ModelProductSizes();

        try {
            this.connectDB();
            String query = "SELECT * FROM productos_tallas WHERE ID_Producto = ?;";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                setProductSizesForConsult(rs, pSize);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return pSize;
    }

    private void setProductSizesForConsult(ResultSet rs, ModelProductSizes pSize) throws SQLException {
        pSize.setIdProduct(rs.getInt("ID_PRODUCTO"));
        pSize.setIdSize(rs.getInt("ID_TALLA"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

}
