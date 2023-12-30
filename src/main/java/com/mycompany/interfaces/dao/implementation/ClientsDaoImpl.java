package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.models.Clients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import com.mycompany.interfaces.dao.ClientsDao;

public class ClientsDaoImpl extends Database implements ClientsDao {

    @Override
    public void record(Clients client) throws Exception {
        try (Connection con = this.getConnection()){
            String query = "call insertClient(?,?,?,?);";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                setClientFieldsToInsert(pst, client);
                pst.executeQuery();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    private void setClientFieldsToInsert(PreparedStatement pst, Clients client) {
        try {
            pst.setString(1, client.getName());
            pst.setInt(2, client.getCellphone());
            pst.setString(3, client.getCity());
            pst.setString(4, client.getDirection());
        } catch (SQLException ex) {
            Logger.getLogger(ClientsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modify(Clients client) throws Exception {
        try (Connection con = this.getConnection()) {
            String query = "call modifyClient(?,?,?,?,?);";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                setClientFieldsToModify(pst, client);
                pst.executeQuery();
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificacion en la base de datos", e);
            throw e;
        }
    }

    private void setClientFieldsToModify(PreparedStatement pst, Clients client) {
        try {
            pst.setString(1, client.getName());
            pst.setInt(2, client.getCellphone());
            pst.setString(3, client.getCity());
            pst.setString(4, client.getDirection());
            pst.setInt(5, client.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ClientsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Clients getClientById(int clientId) throws Exception {
        Clients client = new Clients();
        try (Connection con = this.getConnection()) {
            String query = "call consultByClientId(?);";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                pst.setInt(1, clientId);
                final ResultSet rs = pst.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        setClientFieldsToConsult(rs, client);
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de obtener cliente por id en la base de datos", e);
            throw e;
        }
        return client;
    }

    @Override
    public void delete(int clientId) throws Exception {
        try (Connection con = this.getConnection()) {
            String deleteProduct = "call deleteClient(?);";
            final PreparedStatement pst = con.prepareStatement(deleteProduct);
            try (pst) {
                pst.setInt(1, clientId);
                pst.executeUpdate();
            }
            String sqlResetId = "ALTER TABLE PRODUCTOS AUTO_INCREMENT = ?;";
            final PreparedStatement pstAutoIncrement = this.getConnection().prepareStatement(sqlResetId);
            try (pstAutoIncrement) {
                pstAutoIncrement.setInt(1, clientId);
                pstAutoIncrement.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Clients> consult(String name) throws SQLException {
        List<Clients> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultClient(?);";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                list = new ArrayList();
                pst.setString(1, name);
                final ResultSet rs = pst.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Clients client = new Clients();
                        setClientFieldsToConsult(rs, client);
                        list.add(client);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return list;
    }

    private void setClientFieldsToConsult(ResultSet rs, Clients client) {
        try {
            client.setId(rs.getInt("ID"));
            client.setName(rs.getString("NOMBRE"));
            client.setCellphone(rs.getInt("TELEFONO"));
            client.setCity(rs.getString("CIUDAD"));
            client.setDirection(rs.getString("DIRECCION"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadCmb(JComboBox<String> cityCmb) throws Exception {
        try (Connection con = this.getConnection()) {
            String query = "select nombre from ciudades order by nombre;";
            final Statement st = con.createStatement();
            try (st) {
                st.execute(query);
                final ResultSet resultSet = st.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        cityCmb.addItem(resultSet.getString(1));
                    }
                }

            }
            cityCmb.setSelectedIndex(-1);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar los ComboBox en la base de datos", e);
            throw e;
        }
    }

}
