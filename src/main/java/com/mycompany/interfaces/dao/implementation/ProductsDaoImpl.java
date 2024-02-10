package com.mycompany.interfaces.dao.implementation;

import com.mycompany.db.Database;
import com.mycompany.interfaces.dao.BrandDao;
import com.mycompany.interfaces.dao.CategoryDao;
import com.mycompany.interfaces.dao.ProductSizeDao;
import com.mycompany.models.Size;
import com.mycompany.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import com.mycompany.interfaces.dao.ProductsDao;
import com.mycompany.models.Brand;
import com.mycompany.models.Category;
import com.mycompany.models.Type;

public class ProductsDaoImpl extends Database implements ProductsDao {
    ProductSizeDao productSizeDao = new ProductSizeDaoImpl();
    CategoryDao categoryDao = new CategoryDaoImpl();
    BrandDao brandDao = new BrandDaoImpl();
    
    @Override
    public Integer record(Product product) throws Exception {
        Integer productId = null;
        try (Connection con = this.getConnection()) {
            String query = "call insertProduct(?,?,?,?,?,?,?);";
            final PreparedStatement st = con.prepareStatement(query);
            try (st) {
                setProductFields(st, product);
                // Ejecuta la sentencia SQL
                st.executeUpdate();
                final ResultSet rs = st.getResultSet();
                try (rs) {
                    if (rs.next()) {
                        //haciendo una consulta dentro del procedure para obtener el ultimo id insertado
                        productId = rs.getInt("idProduct");
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
        return productId;
    }

    private void setProductFields(PreparedStatement st, Product product) throws SQLException {
        // Asigna los valores para los parámetros de la sentencia SQL
        st.setString(1, product.getName());
        st.setFloat(2, product.getPrice());
        st.setObject(3, product.getDescription() != null ? product.getDescription() : null, Types.VARCHAR);
        st.setObject(4, product.getDiscount() != null ? product.getDiscount() : null, Types.INTEGER);

        st.setInt(5, product.getBrand().getId());
        st.setInt(6, product.getCategory().getId());
        st.setInt(7, product.getType().getId());
    }

    @Override
    public Integer modify(Product product) throws Exception {
        Integer productId;
        try (Connection con = this.getConnection()) {
            final PreparedStatement st = con.prepareStatement("call modifyProduct(?, ?, ?, ?, ?, ?, ?, ?);");

            try (st) {
                setProductFields(st, product);
                st.setInt(8, product.getId());
                productId = product.getId();
                st.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificacion en la base de datos", e);
            throw e;
        }
        return productId;
    }

    @Override
    public void delete(int productId) throws Exception {
        try {
            String deleteProduct = "call deleteProduct(?);";
            final PreparedStatement pst = this.getConnection().prepareStatement(deleteProduct);
            try (pst) {
                pst.setInt(1, productId);
                pst.executeUpdate();
            }

            String sqlResetId = "ALTER TABLE PRODUCTOS AUTO_INCREMENT = ?;";
            final PreparedStatement pstAutoIncrement = this.getConnection().prepareStatement(sqlResetId);
            try (pstAutoIncrement) {
                pstAutoIncrement.setInt(1, productId);
                pstAutoIncrement.executeUpdate();
            }

        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de eliminacion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public List<Product> consultFiltered(Product product) throws Exception {
        List<Product> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultProducts(?, ?, ?);";
            PreparedStatement st = con.prepareStatement(query);
            try (st) {
                st.setString(1, product.getName());
                st.setString(2, product.getBrand().getName());
                st.setString(3, product.getCategory().getName());
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Product productResult = setProductFieldsToConsult(rs);
                        list.add(productResult);
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
    public List<Product> consultAllProducts() throws Exception {
        List<Product> list = null;
        try (Connection con = this.getConnection()) {
            String query = "select * from showAllProducts;";
            PreparedStatement st = con.prepareStatement(query);
            try (st) {
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Product productResult = setProductFieldsToConsult(rs);
                        list.add(productResult);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return list;
    }

    private Product setProductFieldsToConsult(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("ID");
        String name = rs.getString("NOMBRE");
        Float price = rs.getFloat("PRECIO");
        // hacer estas validaciones para evitar que muestre datos que no ordene
        String description = rs.getString("DESCRIPCION");
        description = rs.wasNull() ? null : description;
        Integer discount = rs.getInt("DESCUENTO");
        discount = rs.wasNull() ? null : discount;

        Integer brandId = rs.getInt("ID_Marca");
        String brandName = rs.getString("NOMBRE_MARCA");
        Brand brand = new Brand(brandId, brandName);

        Integer categoryId = rs.getInt("ID_Categoria");
        String categoryName = rs.getString("NOMBRE_CATEGORIA");
        Category category = new Category(categoryId, categoryName);

        Integer typeId = rs.getInt("ID_Tipo");
        String typeName = rs.getString("NOMBRE_TIPO");
        Type type = new Type(typeId, typeName);

        String brandAvailable = rs.getString("TALLAS_DISPONIBLES");
        Integer totalExistence = rs.getInt("TOTAL_EXISTENCIA");
        Float totalPrice = rs.getFloat("VALOR_TOTAL");

        return new Product(id, name, price, description, discount, brand, category, type, brandAvailable, totalExistence, totalPrice);

    }

    @Override
    public Product getProductById(int productId) throws Exception {
        Product product = null;

        try (Connection con = this.getConnection()) {
            String query = "call consultByProductId(?);";
            final PreparedStatement st = con.prepareStatement(query);
            try (st) {
                st.setInt(1, productId);
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        product = setProductFieldsToConsult(rs);
                    }
                }
            }
            product.setProductSizeList(productSizeDao.getProductSizesById(productId));
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación obtener producto por id en la base de datos", e);
            throw e;
        }
        return product;
    }

    @Override
    public Category loadSizes(Category categorySelected) throws Exception {
        List<Size> sizeList = new ArrayList<>();
        List<Type> typeList = new ArrayList<>();
        Category category = categorySelected;

        try (Connection conn = this.getConnection()) {
            String query = "call cargar_tallas(?);";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, categorySelected.getId());
                final ResultSet rs = ps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Integer sizeId = rs.getInt("id_talla");
                        String sizeName = rs.getString("talla");

                        Size size = new Size(sizeId, sizeName);
                        sizeList.add(size);
                    }
                }
            }
            
            query = "call cargar_tipos(?);";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, categorySelected.getId());
                final ResultSet rs = ps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        Integer sizeId = rs.getInt("id");
                        String sizeName = rs.getString("nombre_tipo");

                        Type type = new Type(sizeId, sizeName);
                        typeList.add(type);
                    }
                }
            }
            
            category.setSizeList(sizeList);
            category.setTypeList(typeList);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar las tallas de la categoria correspondiente.", e);
            throw e;
        }
        return category;
    }

    @Override
    public HashMap<String, List<Type>> loadTypes() throws SQLException {
        HashMap<String, List<Type>> hashMap = new HashMap<>();
        Type type;

        try (Connection conn = this.getConnection()) {
            String query = "call cargar_tipos();";
            PreparedStatement st = conn.prepareStatement(query);
            try (st) {
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        String categoryName = rs.getString("nombre_categoria");

                        Integer typeId = rs.getInt("id");
                        String typeName = rs.getString("nombre_tipo");

                        type = new Type(typeId, typeName);

                        List<Type> list = hashMap.get(categoryName);
                        if (list == null) {
                            list = new ArrayList<>();
                            hashMap.put(categoryName, list);
                        }
                        list.add(type);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar las tallas de la categoria correspondiente.", e);
            throw e;
        }
        return hashMap;
    }

    @Override
    public void loadComboboxByCategory(JComboBox<Category> combobox) throws Exception {
        categoryDao.loadCombobox(combobox);
    }

    @Override
    public void loadComboboxByBrand(JComboBox<Brand> combobox) throws Exception {
        brandDao.loadCombobox(combobox);
    }
}
