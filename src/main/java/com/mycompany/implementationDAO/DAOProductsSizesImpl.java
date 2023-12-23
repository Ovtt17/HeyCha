package com.mycompany.implementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.models.ProductSizes;
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
    public boolean record(ProductSizes productSize) throws Exception {
        boolean isInserted = false;
        try {
            String query = "INSERT INTO PRODUCTOS_TALLAS(ID_PRODUCTO, ID_TALLA, CANTIDAD_INVENTARIO) VALUES (?,?,?);";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
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

    private void sendRecordedFields(PreparedStatement st, ProductSizes productSize) throws SQLException {
        st.setInt(1, productSize.getProductId());
        st.setInt(2, productSize.getSizeId());
        st.setInt(3, productSize.getAmount());
    }

    @Override
    public boolean modify(ProductSizes productSize) throws Exception {
        boolean isModified = false;
        try {
            String query = "call modificar_productos_tallas(?,?,?);";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                sendModifiedFields(st, productSize);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    isModified = true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificacion en la base de datos", e);
            throw e;
        }
        return isModified;
    }
    private void sendModifiedFields(PreparedStatement st, ProductSizes productSize) throws SQLException {
        st.setInt(1, productSize.getAmount());
        st.setInt(2, productSize.getProductId());
        st.setInt(3, productSize.getSizeId());
    }

    @Override
    public void deleteAllSizes(int productId) throws Exception {
        try {
            String query = "call deleteProductSize(?);";
            final PreparedStatement pst = this.getConnection().prepareStatement(query);
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
    public List<ProductSizes> consult(int productId) throws Exception {
        List<ProductSizes> list = null;
        try {
            String query = "select pt.id, pt.id_producto, p.nombre, t.talla, p.precio, cantidad_inventario\n"
                    + "from productos_tallas pt \n"
                    + "inner join productos p on p.ID = pt.ID_Producto\n"
                    + "inner join tallas t on t.id = pt.ID_Talla\n"
                    + "where pt.ID_Producto = ? and pt.is_deleted = 0\n"
                    + "order by t.id, pt.id desc;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ProductSizes pSize = new ProductSizes();
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

    private void setProductSizesForConsult(ResultSet rs, ProductSizes pSize) throws SQLException {
        pSize.setId(rs.getInt("ID"));
        pSize.setProductId(rs.getInt("ID_PRODUCTO"));
        pSize.setProductName(rs.getString("NOMBRE"));
        pSize.setSizeName(rs.getString("TALLA"));
        pSize.setPrice(rs.getInt("PRECIO"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

    @Override
    public void delete(ProductSizes productSize) throws Exception {
        try {
            String query = "UPDATE PRODUCTOS_TALLAS SET is_deleted = 1 WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                st.setInt(1, productSize.getProductId());
                st.setInt(2, productSize.getSizeId());
                st.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }

    }

    @Override
    public List<ProductSizes> getProductSizesById(int productId) throws Exception {
        List<ProductSizes> list = null;
        try {
            String query = "SELECT pt.*, t.talla as nombre_talla FROM productos_tallas pt join tallas t on t.id = pt.ID_Talla where ID_Producto = ? and is_deleted = 0;";
            final PreparedStatement st = this.getConnection().prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ProductSizes pSize = new ProductSizes();
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

    private void setProductSizesForModify(ResultSet rs, ProductSizes pSize) throws SQLException {
        pSize.setProductId(rs.getInt("ID_PRODUCTO"));
        pSize.setSizeId(rs.getInt("ID_TALLA"));
        pSize.setSizeName(rs.getString("NOMBRE_TALLA"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

}
