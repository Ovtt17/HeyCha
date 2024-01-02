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

public class BrandDaoImpl extends Database implements BrandDao {

    @Override
    public void record(Brand brand) throws Exception {
        try (Connection con = this.getConnection()) {
            String query = "insert into marcas (nombre) values (?);";
            final PreparedStatement pst = con.prepareStatement(query);
            try (pst) {
                pst.setString(1, brand.getName());
                pst.executeUpdate();
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
            String query = "select * from marcas where is_deleted = 0;";
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
            String query = "update marcas set is_deleted = 1 where id = ? and nombre = ?;";
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

}
