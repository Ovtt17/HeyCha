package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.ReservationDetailsDao;
import com.mycompany.models.ReservationDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationDetailsDaoImpl extends Database implements ReservationDetailsDao {

    @Override
    public void record(ReservationDetail rDetails) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call insertar_detalles_apartado(?, ?, ?, ?, ?);";
            final PreparedStatement st = con.prepareStatement(sql);
            try (st) {
                setFieldsToInsert(st, rDetails);
                st.execute();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación en la base de datos", e);
            throw e;
        }
    }
    private void setFieldsToInsert(PreparedStatement st, ReservationDetail rDetails) throws SQLException {
        st.setInt(1, rDetails.getReservationId());
        st.setInt(2, rDetails.getProductSizeId());
        st.setFloat(3, rDetails.getPriceUnity());
        st.setInt(4, rDetails.getAmount());
        st.setFloat(5, rDetails.getSubtotal());
    }

    @Override
    public void modify(ReservationDetail rDetails) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call modificar_detalles_apartado(?, ?, ?, ?, ?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                setSalesFieldsToModify(ps, rDetails);
                ps.execute();
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación en la base de datos", e);
            throw e;
        }
    }
    private void setSalesFieldsToModify(PreparedStatement ps, ReservationDetail rDetails) throws SQLException {
        try {
            ps.setInt(1, rDetails.getReservationId());
            ps.setInt(2, rDetails.getProductSizeId());
            ps.setFloat(3, rDetails.getPriceUnity());
            ps.setInt(4, rDetails.getAmount());
            ps.setFloat(5, rDetails.getSubtotal());
        } catch (SQLException ex) {
            Logger.getLogger(SalesDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer reservationId, Integer productSizeId) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call eliminar_producto_de_apartado(?, ?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, reservationId);
                ps.setInt(2, productSizeId);
                ps.execute();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void deleteSoldProduct(int reservationId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservationDetail> consult(int reservationId) throws Exception {
        List<ReservationDetail> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultar_detalles_apartado(?);";
            final PreparedStatement st = con.prepareStatement(query);
            try (st) {
                st.setInt(1, reservationId);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ReservationDetail rDetail = setReservationDetailForConsult(rs);
                        list.add(rDetail);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
        return list;
    }
    private ReservationDetail setReservationDetailForConsult(ResultSet rs) {
        ReservationDetail rd = null;
        try {
            Integer id = rs.getInt("id");
            Integer productSizeId = rs.getInt("id_producto_talla");
            Integer reservationId = rs.getInt("id_apartado");
            Integer productId = rs.getInt("id_producto");
            String productName = rs.getString("nombre_producto");
            String size = rs.getString("talla");
            Float priceUnity = rs.getFloat("precio_unidad");
            Integer amount = rs.getInt("cantidad");
            Float subtotal = rs.getFloat("subtotal");
            rd = new ReservationDetail(id, productSizeId, reservationId, productId, productName, size, priceUnity, amount, subtotal);
        } catch (SQLException ex) {
            Logger.getLogger(SalesDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rd;
    }

    @Override
    public void deleteAll(int reservationId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
