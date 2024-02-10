package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.BrandDao;
import com.mycompany.models.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class BrandDaoImpl extends Database implements BrandDao {

    @Override
    public void record(Brand brand) throws Exception {
        try (Connection conn = this.getConnection()) {
            String checkSql = "SELECT * FROM marcas WHERE nombre = ?;";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, brand.getName());
            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {
                String sql = "INSERT INTO marcas (nombre) VALUES (?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, brand.getName());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de inserción en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void modify(Brand brand) throws Exception {
        try (Connection con = this.getConnection()) {
            String query = "update marcas set nombre = ? where id = ?;";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                pst.setString(1, brand.getName());
                pst.setInt(2, brand.getId());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificación en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Brand> consult() throws Exception {
        List<Brand> list = null;
        try (Connection con = this.getConnection()) {
            String query = "select * from marcas order by id;";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                list = new ArrayList();
                final ResultSet rs = pst.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Integer id = rs.getInt("id");
                        String name = rs.getString("nombre");
                        list.add(new Brand(id, name));
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return list;
    }

    @Override
    public void delete(Brand brand) throws Exception {
        try (Connection con = this.getConnection()) {
            String query = "delete from marcas where id = ? and nombre = ?;";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                pst.setInt(1, brand.getId());
                pst.setString(2, brand.getName());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminación en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void loadCombobox(JComboBox<Brand> combobox) throws Exception {
        try (Connection con = this.getConnection()) {
            String queryCategory = "select * from marcas;";
            final PreparedStatement ps = con.prepareStatement(queryCategory);
            try (ps) {
                final ResultSet rs = ps.executeQuery(queryCategory);
                try (rs) {
                    while (rs.next()) {
                        Integer id = rs.getInt("id");
                        String name = rs.getString("nombre");
                        combobox.addItem(new Brand(id, name));
                    }
                }
            }            
            combobox.setSelectedIndex(-1);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar los ComboBox de agregar o modificar en la base de datos", e);
            throw e;
        }
    }

}
