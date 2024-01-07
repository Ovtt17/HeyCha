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

public class SizeDaoImpl extends Database implements SizeDao {

    private final CategorySizeDao categorySizeDao = new CategorySizeDaoImpl();

    @Override
    public void record(Size size) throws Exception {

        try (Connection conn = this.getConnection()) {
            String sqlVerification = "select * from tallas where talla = ?;";
            PreparedStatement psVerification = conn.prepareStatement(sqlVerification);
            psVerification.setString(1, size.getName());
            ResultSet rsVerification = psVerification.executeQuery();

            if (rsVerification.next()) {
                Integer sizeId = rsVerification.getInt("id");
                createSizes(size, sizeId);
            } else {
                String sql = "insert into tallas (talla) values (?);";
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, size.getName());
                ps.executeUpdate();

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    Integer sizeId = generatedKeys.getInt(1);

                    createSizes(size, sizeId);
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    private void createSizes(Size size, Integer sizeId) {
        size.getCategorySizeList().stream().forEach(cs -> {
            cs.setSizeId(sizeId);
            try {
                categorySizeDao.record(cs);
            } catch (Exception ex) {
                Logger.getLogger(SizeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Error al grabar CategorySize", ex);
            }

        });
    }

    @Override
    public Integer modify(Size size) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer sizeId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Category> getCategoriesBySizeSelected(Integer id) throws Exception{
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
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar las categorias en las cuales se utiliza la talla seleccionada en la base de datos", ex);
            throw ex;
        }
        return categoryList;
    }

}
