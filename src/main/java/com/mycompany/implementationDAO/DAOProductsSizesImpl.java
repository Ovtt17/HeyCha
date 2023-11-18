package com.mycompany.implementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.models.ModelProductSizes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProductsSizesImpl extends Database implements DAOProductSizes {

    @Override
    public void record(ModelProductSizes productSize) throws Exception {
        try {
            String query = "INSERT INTO PRODUCTOS_TALLAS(ID_PRODUCTO, ID_TALLA, CANTIDAD_INVENTARIO) VALUES (?,?,?);";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                sendRecordedFields(st, productSize);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
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
            String query = "UPDATE PRODUCTOS_TALLAS SET CANTIDAD_INVENTARIO = ? WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                sendModifiedFields(st, productSize);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    isModified = true;
                }
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificacion en la base de datos", e);
            throw e;
        }
        return isModified;
    }

    @Override
    public void delete(int productId) throws Exception {
        try {
            String query = "call deleteProductSize(?);";
            final PreparedStatement pst = this.getConnection().prepareStatement(query);
            try (pst) {
                pst.setInt(1, productId);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<ModelProductSizes> consult(int productId) throws Exception {
        List<ModelProductSizes> list = null;
        try {
            String query = "select pt.id, pt.id_producto, p.nombre, t.talla, p.precio, cantidad_inventario\n"
                    + "from productos_tallas pt \n"
                    + "inner join productos p on p.ID = pt.ID_Producto\n"
                    + "inner join tallas t on t.id = pt.ID_Talla\n"
                    + "where pt.ID_Producto = ? and pt.is_deleted = 0\n"
                    + "order by p.nombre, pt.ID_Producto desc;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ModelProductSizes pSize = new ModelProductSizes();
                        setProductSizesForConsult(rs, pSize);
                        list.add(pSize);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
        return list;
    }

    private void setProductSizesForConsult(ResultSet rs, ModelProductSizes pSize) throws SQLException {
        pSize.setId(rs.getInt("ID"));
        pSize.setIdProduct(rs.getInt("ID_PRODUCTO"));
        pSize.setNameProduct(rs.getString("NOMBRE"));
        pSize.setNameSize(rs.getString("TALLA"));
        pSize.setPrice(rs.getInt("PRECIO"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

    @Override
    public void deleteIfZero(ModelProductSizes productSize) throws Exception {
        try {
            String query = "DELETE FROM PRODUCTOS_TALLAS WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                st.setInt(1, productSize.getIdProduct());
                st.setInt(2, productSize.getIdSize());
                st.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }

    }

    @Override
    public List<ModelProductSizes> getProductSizesById(int productId) throws Exception {
        List<ModelProductSizes> list = null;
        try {
            String query = "SELECT * FROM productos_tallas WHERE ID_Producto = ?;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ModelProductSizes pSize = new ModelProductSizes();
                        setProductSizesForModify(rs, pSize);
                        list.add(pSize);
                    }
                }
            }
            
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de obtener las tallas por id en la base de datos", e);
            throw e;
        }
        return list;
    }

    private void setProductSizesForModify(ResultSet rs, ModelProductSizes pSize) throws SQLException {
        pSize.setIdProduct(rs.getInt("ID_PRODUCTO"));
        pSize.setIdSize(rs.getInt("ID_TALLA"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

}
