package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOClients;
import com.mycompany.models.ModelClients;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class DAOClientsImpl extends Database implements DAOClients {

    @Override
    public void record(ModelClients client) throws Exception {
        try {
            this.connectDB();
            String query = "call insertClient(?,?,?,?);";
            PreparedStatement pst = this.connection.prepareStatement(query);
            setClientFieldsToBD(pst, client);
            pst.executeQuery();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    private void setClientFieldsToBD(PreparedStatement pst, ModelClients client) throws SQLException {
        pst.setString(1, client.getName());
        pst.setInt(2, client.getCellphone());
        pst.setString(3, client.getCity());
        pst.setString(4, client.getDirection());
    }

    @Override
    public void modify(ModelClients client) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelClients getProductById(int clientId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ModelClients client) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModelClients> consult(String name) throws Exception {
        List<ModelClients> list = null;
        try {
            this.connectDB();
            String query = "select * from clientes;";
            PreparedStatement pst = this.connection.prepareStatement(query);
            list = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModelClients client = new ModelClients();
                setClientFieldsFromBBForConsult(rs, client);
                list.add(client);
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return list;
    }

    private void setClientFieldsFromBBForConsult(ResultSet rs, ModelClients client) throws SQLException {
        client.setId(rs.getInt("ID"));
        client.setName(rs.getString("NOMBRE"));
        client.setCellphone(rs.getInt("TELEFONO"));
        client.setCity(rs.getString("CIUDAD"));
        client.setDirection(rs.getString("DIRECCION"));
    }

    @Override
    public void loadCmb(JComboBox<String> cityCmb) throws Exception {
        try {
            this.connectDB();
            String query = "select nombre from ciudades;";
            Statement st = this.connection.createStatement();
            st.execute(query);
            ResultSet resultSet = st.getResultSet();

            while (resultSet.next()) {
                cityCmb.addItem(resultSet.getString(1));
            }

            st.close();
            resultSet.close();
            cityCmb.setSelectedIndex(-1);
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

}
