package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.CategorySizeDao;
import com.mycompany.models.CategorySize;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategorySizeDaoImpl extends Database implements CategorySizeDao {

    @Override
    public boolean record(CategorySize categorySize) throws Exception {
        boolean recordStatus = false;
        try (Connection conn = this.getConnection()) {
            String sqlCheck = """
                              select ct.*, t.talla as nombre_talla, c.nombre as nombre_categoria
                              from categorias_tallas ct
                              join tallas t on ct.id_talla = t.id
                              join categorias c on ct.id_categoria = c.id
                              where id_categoria = ? and id_talla = ?;""";

            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            try (psCheck) {
                psCheck.setInt(1, categorySize.getCategory().getId());
                psCheck.setInt(2, categorySize.getSize().getId());

                ResultSet rsCheck = psCheck.executeQuery();
                if (rsCheck.next()) {
                    recordStatus = false;
                } else {
                    String sql = "insert into categorias_tallas (id_categoria, id_talla) values (?,?);";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    try (ps) {
                        ps.setInt(1, categorySize.getCategory().getId());
                        ps.setInt(2, categorySize.getSize().getId());
                        int recorded = ps.executeUpdate();
                        recordStatus = recorded > 0;
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de inserción de categorias_tallas en la base de datos", e);
            throw e;
        }
        return recordStatus;
    }

    @Override
    public boolean delete(CategorySize categorySize) throws Exception {
        boolean deleteStatus = false;
        try (Connection conn = this.getConnection()) {
            String sql = "delete from categorias_tallas where id_categoria = ? and id_talla = ?;";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, categorySize.getCategory().getId());
                ps.setInt(2, categorySize.getSize().getId());
                int deleted = ps.executeUpdate();
                deleteStatus = deleted > 0;
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion de categorias_tallas en la base de datos", e);
            throw e;
        }
        return deleteStatus;
    }

}
