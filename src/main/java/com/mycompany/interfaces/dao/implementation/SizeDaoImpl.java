package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.CategorySizeDao;
import com.mycompany.interfaces.dao.SizeDao;
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
import javax.swing.JOptionPane;

public class SizeDaoImpl extends Database implements SizeDao {

    private final CategorySizeDao categorySizeDao = new CategorySizeDaoImpl();

    @Override
    public void record(Size size) throws Exception {
        try (Connection conn = this.getConnection()) {
            String sql = "insert into tallas (talla) values (?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, size.getName());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                size.setId(generatedKeys.getInt(1));
                recordCategorySizes(size);
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion de tallas para la categoria correspondiente en la base de datos", e);
            throw e;
        }
    }

    private void recordCategorySizes(Size size) throws Exception {
        size.getCategorySizeList().stream().forEach(cs -> {
            try {
                boolean recordedStatus = categorySizeDao.record(cs);
                if (!recordedStatus) {
                    JOptionPane.showMessageDialog(null, "La talla " + cs.getSize().getName() + " ya está asociada con la categoría " + cs.getCategory().getName() + ".", "AVISO", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion de las tallas de cada categoria en la base de datos", ex);
            }
        });
    }

    @Override
    public void modify(Size size) throws Exception {
        try (Connection conn = this.getConnection()) {
            String sql = "update tallas set talla = ? where id = ?;";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, size.getName());
                ps.setInt(2, size.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SizeDaoImpl.class.getName()).log(Level.SEVERE, "Error al modificar la talla.", ex);
            throw ex;
        }
    }

    @Override
    public boolean delete(Size size) throws Exception {
        boolean isDeleted;
        try (Connection conn = this.getConnection()) {
            deleteCategorySizes(size);
            String sql = "delete from tallas where id = ?;";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, size.getId());
                Integer rowsAffected = ps.executeUpdate();
                isDeleted = rowsAffected > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SizeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("La talla " + size.getName() + "no se pudo eliminar porque hay una categoria utilizandola", ex);
        }
        return isDeleted;
    }

    private void deleteCategorySizes(Size size) throws Exception {
        size.getCategorySizeList().stream().forEach(cs -> {
            try {
                cs.setSize(size);
                categorySizeDao.delete(cs);
            } catch (SQLException e) {
                Logger.getLogger(SizeDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            } catch (Exception ex) {
                Logger.getLogger(SizeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public List<Category> getCategoriesBySizeSelected(Integer id) throws Exception {
        List<Category> categoryList = null;
        try (Connection conn = this.getConnection()) {
            String sql = """
                         SELECT ct.*,  c.nombre as nombre_categoria
                         FROM categorias_tallas ct
                         join categorias c on c.id =  ct.id_categoria
                         where ct.id_talla = ?;
                         """;
            PreparedStatement ps = conn.prepareStatement(sql);
            try (ps) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                categoryList = new ArrayList<>();
                while (rs.next()) {
                    Integer categoryId = rs.getInt("id_categoria");
                    String categoryName = rs.getString("nombre_categoria");
                    categoryList.add(new Category(categoryId, categoryName));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SizeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return categoryList;
    }

}
