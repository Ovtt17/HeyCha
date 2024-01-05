package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.CategoryDao;
import com.mycompany.models.Category;
import com.mycompany.models.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDaoImpl extends Database implements CategoryDao {

    @Override
    public void record(Category category, Integer categoryExample) throws Exception {
        try (Connection conn = this.getConnection()) {
            String checkSql = "SELECT * FROM categorias WHERE nombre = ?;";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, category.getName());
            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {
                String sql = "INSERT INTO categorias (nombre) VALUES (?);";
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, category.getName());
                ps.executeUpdate();

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int insertedId = generatedKeys.getInt(1);
                    insertSizesInCategory(insertedId, categoryExample);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void modify(Category category) throws Exception {
        try (Connection conn = this.getConnection()) {
            String query = "udpate categorias set nombre = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            try (ps) {
                ps.setString(1, category.getName());
                ps.setInt(2, category.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificación de tipos por categoría en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Category> consult() throws Exception {
        List<Category> list;
        try (Connection conn = this.getConnection()) {
            String query = "select * from categorias;";
            PreparedStatement ps = conn.prepareStatement(query);
            try (ps) {
                list = new ArrayList();
                ResultSet rs = ps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Integer id = rs.getInt("id");
                        String name = rs.getString("nombre");
                        list.add(new Category(id, name));
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
    public void delete(Category category) throws Exception {
        try (Connection conn = this.getConnection()) {
            String queryDetails = "delete from categorias_tallas where id_categoria = ?;";
            PreparedStatement psDetails = conn.prepareStatement(queryDetails);
            try (psDetails) {
                psDetails.setInt(1, category.getId());
                psDetails.executeUpdate();
            }
            
            String queryCategory = "delete from categorias where id = ?;";
            PreparedStatement psCategory = conn.prepareStatement(queryCategory);
            try (psCategory) {
                psCategory.setInt(1, category.getId());
                psCategory.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void insertSizesInCategory(Integer categoryId, Integer categoryExample) throws Exception {
        try (Connection conn = this.getConnection()) {
            String sql = "INSERT INTO categorias_tallas (id_categoria, id_talla) SELECT ?, id_talla FROM categorias_tallas WHERE id_categoria = ?;";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, categoryId);
                ps.setInt(2, categoryExample);
                ps.executeUpdate();
            }
        }catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion de tallas por categoria en la base de datos", e);
            throw e;
        }
    }
    @Override
    public List<Size> getSizes(Integer categoryId) throws Exception {
        List<Size> list = null;
        try (Connection conn = this.getConnection()) {
            String query = "call consultar_tallas_de_categorias(?);";
            PreparedStatement ps = conn.prepareStatement(query);
            try (ps) {
                ps.setInt(1, categoryId);
                list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Integer sizeId = rs.getInt("id_talla");
                        String sizeName = rs.getString("talla");
                        list.add(new Size(sizeId, sizeName));
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion en la base de datos", e);
            throw e;
        }
        return list;
    }

}
