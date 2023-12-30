package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.models.SalesProducts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.interfaces.dao.SalesDetailsDao;

public class SalesDetailsDaoImpl extends Database implements SalesDetailsDao {

    @Override
    public void record(SalesProducts salesProducts) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call insertSalesProducts(?, ?, ?, ?, ?, ?);";
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

    private void setFieldsToInsert(PreparedStatement st, SalesProducts salesProducts) throws SQLException {
        st.setInt(1, salesProducts.getSaleId());
        st.setInt(2, salesProducts.getProductSizeId());
        st.setFloat(3, salesProducts.getPriceUnity());
        st.setInt(4, salesProducts.getAmount());
        st.setFloat(5, salesProducts.getSubtotal());
        st.setInt(6, salesProducts.getProductId());
    }

    @Override
    public void modify(SalesProducts sale) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call modificar_detalles_venta(?, ?, ?, ?, ?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                setSalesFieldsToModify(ps, sale);
                ps.execute();
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación en la base de datos", e);
            throw e;
        }
    }

    private void setSalesFieldsToModify(PreparedStatement ps, SalesProducts sale) throws SQLException {
        try {
            ps.setInt(1, sale.getSaleId());
            ps.setInt(2, sale.getProductSizeId());
            ps.setFloat(3, sale.getPriceUnity());
            ps.setInt(4, sale.getAmount());
            ps.setFloat(5, sale.getSubtotal());
        } catch (SQLException ex) {
            Logger.getLogger(SalesDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer saleId, Integer productSizeId) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call deleteSalesProducts(?, ?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, saleId);
                ps.setInt(2, productSizeId);
                ps.execute();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<SalesProducts> consult(int saleId) throws Exception {
        List<SalesProducts> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultSalesProducts(?);";
            final PreparedStatement st = con.prepareStatement(query);
            try (st) {
                st.setInt(1, saleId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        SalesProducts salesProducts = setSalesProductsForConsult(rs);
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

    private SalesProducts setSalesProductsForConsult(ResultSet rs) {
        SalesProducts sp = null;
        try {
            Integer id = rs.getInt("id");
            Integer productSizeId = rs.getInt("id_producto_talla");
            Integer saleId = rs.getInt("id_venta");
            Integer productId = rs.getInt("id_producto");
            String productName = rs.getString("nombre_producto");
            String size = rs.getString("talla");
            Float priceUnity = rs.getFloat("precio_unidad");
            Integer amount = rs.getInt("cantidad");
            Float subtotal = rs.getFloat("subtotal");
            sp = new SalesProducts(id, productSizeId, saleId, productId, productName, size, priceUnity, amount, subtotal);
        } catch (SQLException ex) {
            Logger.getLogger(SalesDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }

    @Override
    public void deleteSoldProduct(int saleId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll(int saleId) {
        
    }

}
