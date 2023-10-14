package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOClients;
import com.mycompany.models.ModelClients;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class DAOClientsImpl extends Database implements DAOClients {

    @Override
    public void record(ModelClients client) throws Exception {
        try {
            this.connectDB();
            String query = "call insertClient(?,?,?,?);";
            PreparedStatement pst = this.connection.prepareStatement(query);
            setClientFieldsToInsert(pst, client);
            pst.executeQuery();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    private void setClientFieldsToInsert(PreparedStatement pst, ModelClients client) {
        try {
            pst.setString(1, client.getName());
            pst.setInt(2, client.getCellphone());
            pst.setString(3, client.getCity());
            pst.setString(4, client.getDirection());
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modify(ModelClients client) throws Exception {
        try {
            this.connectDB();
            String query = "call modifyClient(?,?,?,?,?);";
            PreparedStatement pst = this.connection.prepareStatement(query);
            setClientFieldsToModify(pst, client);
            pst.executeQuery();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    private void setClientFieldsToModify(PreparedStatement pst, ModelClients client) {
        try {
            pst.setString(1, client.getName());
            pst.setInt(2, client.getCellphone());
            pst.setString(3, client.getCity());
            pst.setString(4, client.getDirection());
            pst.setInt(5, client.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ModelClients getClientById(int clientId) throws Exception {
        ModelClients client = new ModelClients();
        try {
            this.connectDB();
            String query = "call consultByClientId(?);";
            PreparedStatement pst = this.connection.prepareStatement(query);
            pst.setInt(1, clientId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                setClientFieldsToConsult(rs, client);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return client;
    }

    @Override
    public void delete(int clientId) throws Exception {
        try {
            this.connectDB();
            String deleteProduct = "call deleteClient(?);";
            PreparedStatement pst = this.connection.prepareStatement(deleteProduct);
            pst.setInt(1, clientId);
            String sqlResetId = "ALTER TABLE PRODUCTOS AUTO_INCREMENT = ?;";
            PreparedStatement pstAutoIncrement = this.connection.prepareStatement(sqlResetId);
            pstAutoIncrement.setInt(1, clientId);

            pst.executeUpdate();
            pstAutoIncrement.executeUpdate();
            pst.close();
            pstAutoIncrement.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public List<ModelClients> consult(String name) throws SQLException {
        List<ModelClients> list = null;
        System.out.println("entramos a la consulta de cliente");
        try {
            this.connectDB();
            String query = "select * from clientes where (nombre = '' or nombre like concat('%', '"+name+"','%')) and is_deleted = 0;";
            PreparedStatement pst = this.connection.prepareStatement(query);
            list = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ModelClients client = new ModelClients();
                setClientFieldsToConsult(rs, client);
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

    private void setClientFieldsToConsult(ResultSet rs, ModelClients client) {
        try {
            client.setId(rs.getInt("ID"));
            client.setName(rs.getString("NOMBRE"));
            client.setCellphone(rs.getInt("TELEFONO"));
            client.setCity(rs.getString("CIUDAD"));
            client.setDirection(rs.getString("DIRECCION"));
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadCmb(JComboBox<String> cityCmb) throws Exception {
        try {
            this.connectDB();
            String query = "select nombre from ciudades order by nombre;";
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
