package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.models.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.interfaces.dao.SizesDao;

public class SizesDaoImpl extends Database implements SizesDao {

    @Override
    public boolean record(Size productSize) throws Exception {
        boolean isInserted = false;
        try (Connection conn = this.getConnection()) {
            String query = "INSERT INTO PRODUCTOS_TALLAS(ID_PRODUCTO, ID_TALLA, CANTIDAD_INVENTARIO) VALUES (?,?,?);";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                sendRecordedFields(st, productSize);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    isInserted = true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
        return isInserted;
    }

    private void sendRecordedFields(PreparedStatement st, Size productSize) throws SQLException {
        st.setInt(1, productSize.getProductId());
        st.setInt(2, productSize.getSizeId());
        st.setInt(3, productSize.getAmount());
    }

    @Override
    public boolean modify(Size productSize) throws Exception {
        boolean isModified = false;
        try (Connection conn = this.getConnection()) {
            String query = "call modificar_productos_tallas(?,?,?);";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                sendModifiedFields(st, productSize);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    isModified = true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificacion en la base de datos", e);
            return false;
        }
        return isModified;
    }
    private void sendModifiedFields(PreparedStatement st, Size productSize) throws SQLException {
        st.setInt(1, productSize.getAmount());
        st.setInt(2, productSize.getProductId());
        st.setInt(3, productSize.getSizeId());
    }

    @Override
    public void deleteAllSizes(int productId) throws Exception {
        try (Connection conn = this.getConnection()) {
            String query = "call deleteProductSize(?);";
            final PreparedStatement pst = conn.prepareStatement(query);
            try (pst) {
                pst.setInt(1, productId);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminación en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Size> consult(int productId) throws Exception {
        List<Size> list = null;
        try (Connection conn = this.getConnection()) {
            String query = "select pt.id, pt.id_producto, p.nombre, t.talla, p.precio, cantidad_inventario\n"
                    + "from productos_tallas pt \n"
                    + "inner join productos p on p.ID = pt.ID_Producto\n"
                    + "inner join tallas t on t.id = pt.ID_Talla\n"
                    + "where pt.ID_Producto = ? and pt.is_deleted = 0\n"
                    + "order by t.id, pt.id desc;";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Size pSize = new Size();
                        setProductSizesForConsult(rs, pSize);
                        list.add(pSize);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return list;
    }

    private void setProductSizesForConsult(ResultSet rs, Size pSize) throws SQLException {
        pSize.setId(rs.getInt("ID"));
        pSize.setProductId(rs.getInt("ID_PRODUCTO"));
        pSize.setProductName(rs.getString("NOMBRE"));
        pSize.setSizeName(rs.getString("TALLA"));
        pSize.setPrice(rs.getInt("PRECIO"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

    @Override
    public void delete(Size productSize) throws Exception {
        try (Connection conn = this.getConnection()) {
            String query = "UPDATE PRODUCTOS_TALLAS SET is_deleted = 1 WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                st.setInt(1, productSize.getProductId());
                st.setInt(2, productSize.getSizeId());
                st.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion en la base de datos", e);
            throw e;
        }

    }

    @Override
    public List<Size> getProductSizesById(int productId) throws Exception {
        List<Size> list = null;
        try (Connection conn = this.getConnection()) {
            String query = "SELECT pt.*, t.talla as nombre_talla FROM productos_tallas pt join tallas t on t.id = pt.ID_Talla where ID_Producto = ? and is_deleted = 0;";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Size pSize = new Size();
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

    private void setProductSizesForModify(ResultSet rs, Size pSize) throws SQLException {
        pSize.setProductId(rs.getInt("ID_PRODUCTO"));
        pSize.setSizeId(rs.getInt("ID_TALLA"));
        pSize.setSizeName(rs.getString("NOMBRE_TALLA"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

}
