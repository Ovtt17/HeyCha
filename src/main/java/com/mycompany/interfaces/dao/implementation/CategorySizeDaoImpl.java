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
import javax.swing.JOptionPane;

public class CategorySizeDaoImpl extends Database implements CategorySizeDao {

    @Override
    public void record(CategorySize categorySize) throws Exception {
        try (Connection conn = this.getConnection()) {
            String sqlCheck = """
                              select ct.*, t.talla as nombre_talla, c.nombre as nombre_categoria
                              from categorias_tallas ct
                              join tallas t on ct.id_talla = t.id
                              join categorias c on ct.id_categoria = c.id
                              where id_categoria = ? and id_talla = ?;""";
            
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            try (psCheck) {
                psCheck.setInt(1, categorySize.getCategoryId());
                psCheck.setInt(2, categorySize.getSizeId());
                
                ResultSet rsCheck = psCheck.executeQuery();
                if (rsCheck.next()) {
                    String categoryName = rsCheck.getString("nombre_categoria");
                    String sizeName = rsCheck.getString("nombre_talla");
                    JOptionPane.showMessageDialog(null, "La talla " + sizeName + " ya está asociada con la categoría " + categoryName + ".","AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                } else {
                    String sql = "insert into categorias_tallas (id_categoria, id_talla) values (?,?);";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    try (ps) {
                        ps.setInt(1, categorySize.getCategoryId());
                        ps.setInt(2, categorySize.getSizeId());
                        ps.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de inserción de categorias_tallas en la base de datos", e);
            throw e;
        }
    }

}
