package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.ReservationDao;
import com.mycompany.models.Reservation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ReservationDaoImpl extends Database implements ReservationDao {

    @Override
    public Integer record(Reservation reservation) throws Exception {
        Integer reservationId = null;
        try (Connection con = this.getConnection()) {
            String query = "call insertar_apartado(?, ?, ?, ?, ?, ?);";
            final CallableStatement cst = con.prepareCall(query);
            try (cst) {
                cst.registerOutParameter(1, java.sql.Types.INTEGER);  // Registrar el primer parámetro como OUT
                cst.setInt(2, reservation.getClientId());
                cst.setDate(3, java.sql.Date.valueOf(reservation.getDate()));
                cst.setInt(4, reservation.getQuantitySold());
                cst.setFloat(5, reservation.getPaid());
                cst.setFloat(6, reservation.getTotalMoneyEarned());

                cst.execute();

                reservationId = cst.getInt(1);  // Obtener el valor del primer parámetro
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
        return reservationId;
    }

    @Override
    public Integer modify(Reservation reservation) throws Exception {
        Integer reservationId = null;
        try (Connection con = this.getConnection()) {
            String query = "call modificar_apartado(?, ?, ?, ?);";
            final PreparedStatement ps = con.prepareStatement(query);
            try (ps) {
                ps.setInt(1, reservation.getQuantitySold());
                ps.setFloat(2, reservation.getPaid());
                ps.setFloat(3, reservation.getTotalMoneyEarned());
                ps.setInt(4, reservation.getId());
                ps.executeUpdate();
                reservationId = reservation.getId();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificación en la base de datos", e);
            throw e;
        }
        return reservationId;
    }

    @Override
    public void delete(int reservationId) throws Exception {
        try (Connection con = this.getConnection()) {
            String sql = "call eliminar_apartado(?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, reservationId);
                ps.execute();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminación en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Reservation> consult(Date date) throws Exception {
        List<Reservation> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultar_apartados(?);";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                pst.setDate(1, date);
                list = new ArrayList();
                final ResultSet rs = pst.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Reservation reservation = setSalesFieldsToConsult(rs);
                        list.add(reservation);
                    }
                }

            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return list;
    }
    private Reservation setSalesFieldsToConsult(ResultSet rs) throws SQLException {
        Integer reservationId = rs.getInt("ID_APARTADO");
        Integer clientId = rs.getInt("ID_CLIENTE");
        String clientName = rs.getString("NOMBRE_CLIENTE");
        LocalDate date = rs.getObject("FECHA", LocalDate.class);
        Integer quantitySold = rs.getInt("CANTIDAD_VENDIDA");
        Float paid = rs.getFloat("ABONADO");
        Float totalMoneySold = rs.getFloat("TOTAL");

        return new Reservation(reservationId, clientId, clientName, date, quantitySold, paid, totalMoneySold);

    }

    @Override
    public Reservation getReservationById(int reservationId) throws Exception {
        Reservation reservation = null;
        try (Connection con = this.getConnection()) {
            String sql = "call consultar_apartado_por_id(?);";
            final PreparedStatement ps = con.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, reservationId);
                final ResultSet rs = ps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        reservation = setSalesFieldsToConsult(rs);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de obtener los apartados por id en la base de datos", e);
            throw e;
        }
        return reservation;
    }

    @Override
    public void loadClientsCmb(JComboBox<String> cmbClients) throws Exception {
        try (Connection con = this.getConnection()) {
            String queryClientsName = "select nombre from clientes where is_deleted = 0 order by id;";
            fillComboBox(con, cmbClients, queryClientsName);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar los ComboBox en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void fillComboBox(Connection conn, JComboBox<String> comboBox, String query) throws SQLException {
        final PreparedStatement pst = conn.prepareStatement(query);
        try (pst) {
            final ResultSet rs = pst.executeQuery();
            try (rs) {
                while (rs.next()) {
                    comboBox.addItem(rs.getString(1));
                }
            }
            comboBox.setSelectedIndex(0);
            AutoCompleteDecorator.decorate(comboBox);
        }
    }

}
