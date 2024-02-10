package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.TypeDao;
import com.mycompany.models.Category;
import com.mycompany.models.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TypeDaoImpl extends Database implements TypeDao {

    @Override
    public void record(Type type) throws Exception {
        try (Connection conn = this.getConnection()) {
            String checkSql = "SELECT * FROM tipos WHERE nombre = ? AND id_categoria = ?;";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, type.getName());
            checkPs.setInt(2, type.getCategoryId());
            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {
                String sql = "INSERT INTO tipos (nombre, id_categoria) VALUES (?, ?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, type.getName());
                ps.setInt(2, type.getCategoryId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de inserción de tipos por categoría en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void modify(Type type) throws Exception {
        try (Connection conn = this.getConnection()) {
            String sql = "UPDATE tipos SET nombre = ?, id_categoria = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, type.getName());
            ps.setInt(2, type.getCategoryId());
            ps.setInt(3, type.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificación de tipos por categoría en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Type> consultByCategory(Category category) throws Exception {
        List<Type> list;
        try (Connection conn = this.getConnection()) {
            String query = "select * from tipos where id_categoria = ?;";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                st.setInt(1, category.getId());
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Integer id = rs.getInt("id");
                        String name = rs.getString("nombre");
                        list.add(new Type(id, name));
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta de tipos por categoria en la base de datos", e);
            throw e;
        }
        return list;
    }

    @Override
    public void delete(Type type) throws Exception {
        try (Connection conn = this.getConnection()) {
            String query = "delete from tipos where id = ? and nombre = ?;";
            final PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                st.setInt(1, type.getId());
                st.setString(2, type.getName());
                st.executeUpdate();
            }
        }catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion en la base de datos", e);
            throw e;
        }
    }
}
