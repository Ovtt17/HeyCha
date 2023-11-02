package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class DAOProductsImpl extends Database implements DAOProducts {

    @Override
    public void record(ModelProducts product, ModelProductSizes pSizes) throws Exception {
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
                        int idProducto = rs.getInt("idProduct");
                        pSizes.setIdProduct(idProducto);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de insercion en la base de datos", e);
            throw e;
        }
    }

    private void setProductFields(PreparedStatement st, ModelProducts product) throws SQLException {
        // Asigna los valores para los parámetros de la sentencia SQL
        st.setString(1, product.getName()); // Reemplaza con el método adecuado para obtener el nombre
        st.setFloat(2, product.getPrice());   // Reemplaza con el método adecuado para obtener el precio
        if (product.getDescription() != null) {
            st.setString(3, product.getDescription()); // Reemplaza con el método adecuado para obtener la descripción
        } else {
            st.setNull(3, Types.VARCHAR);
        }
        if (product.getDiscount() != null) {
            st.setInt(4, product.getDiscount()); // Reemplaza con el método adecuado para obtener el descuento
        } else {
            st.setNull(4, Types.INTEGER);
        }

        st.setInt(5, product.getIdBrand()); // Reemplaza con el método adecuado para obtener el ID de la marca
        st.setInt(6, product.getIdCategory()); // Reemplaza con el método adecuado para obtener el ID de la categoría

        if (product.getIdType() != null) {
            st.setInt(7, product.getIdType()); // Reemplaza con el método adecuado para obtener el ID del tipo
        } else {
            st.setNull(7, Types.INTEGER);
        }
    }

    @Override
    public void modify(ModelProducts product, ModelProductSizes pSizes) throws Exception {
        try (Connection con = this.getConnection()) {
            final PreparedStatement st = con.prepareStatement("call modifyProduct(?, ?, ?, ?, ?, ?, ?, ?);");

            try (st) {
                setProductFields(st, product);
                st.setInt(8, product.getId());
                pSizes.setIdProduct(product.getId());
                st.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de modificacion en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void delete(int productId) throws Exception {
        try (Connection con = this.getConnection()) {
            String deleteProduct = "call deleteProduct(?);";
            final PreparedStatement pst = con.prepareStatement(deleteProduct);
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
    public List<ModelProducts> consult(String name, String brand, String category) throws Exception {
        List<ModelProducts> list = null;
        try (Connection con = this.getConnection()) {
            String query = "call consultProducts(?, ?, ?);";
            PreparedStatement st = con.prepareStatement(query);
            try (st) {
                st.setString(1, name);
                st.setString(2, brand);
                st.setString(3, category);
                list = new ArrayList();
                final ResultSet rs = st.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        ModelProducts product = setProductFieldsToConsult(rs);
                        list.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de consulta en la base de datos", e);
            throw e;
        }
        return list;
    }

    private ModelProducts setProductFieldsToConsult(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("ID");
        String name = rs.getString("NOMBRE");
        Float price = rs.getFloat("PRECIO");
        // hacer estas validaciones para evitar que muestre datos que no ordene
        String description = rs.getString("DESCRIPCION");
        description = rs.wasNull() ? null : description;
        Integer discount = rs.getInt("DESCUENTO");
        discount = rs.wasNull() ? null : discount;
        Integer brandId = rs.getInt("ID_Marca");
        Integer categoryId = rs.getInt("ID_Categoria");
        Integer typeId = rs.getInt("ID_Tipo");

        String brandName = rs.getString("NOMBRE_MARCA");
        String categoryName = rs.getString("NOMBRE_CATEGORIA");
        String typeName = rs.getString("NOMBRE_TIPO");
        typeName = rs.wasNull() ? null : typeName;

        String brandAvailable = rs.getString("TALLAS_DISPONIBLES");
        Integer totalExistence = rs.getInt("TOTAL_EXISTENCIA");
        Float totalPrice = rs.getFloat("VALOR_TOTAL");

        return new ModelProducts(id, name, price, description, discount, brandId, categoryId, typeId, brandName, categoryName, typeName, brandAvailable, totalExistence, totalPrice);

    }

    @Override
    public ModelProducts getProductById(int productId) throws Exception {
        ModelProducts product = null;

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
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación obtener producto por id en la base de datos", e);
            throw e;
        }
        return product;
    }

    @Override
    public void loadCmb(JComboBox<String> brandCmb, JComboBox<String> categoryCmb, JComboBox<String> typeCmb) throws Exception {

        try (Connection con = this.getConnection()) {
            String queryBrand = "select nombre from marcas;";
            String queryCategory = "select nombre from categorias;";
            String queryType = "select nombre from tipo;";
            fillComboBox(con, brandCmb, queryBrand);
            brandCmb.setSelectedIndex(-1);
            fillComboBox(con, categoryCmb, queryCategory);
            categoryCmb.setSelectedIndex(-1);
            fillComboBox(con, typeCmb, queryType);
            typeCmb.setSelectedIndex(-1);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar los ComboBox de agregar o modificar en la base de datos", e);
            throw e;
        }
    }

    @Override
    public void fillComboBox(Connection con, JComboBox<String> comboBox, String query) throws SQLException {
        final Statement statement = con.createStatement();
        try (statement) {
            statement.execute(query);
            final ResultSet resultSet = statement.getResultSet();
            try (resultSet) {
                while (resultSet.next()) {
                    comboBox.addItem(resultSet.getString(1));
                }
                comboBox.setSelectedIndex(0);
            }
        }

    }

    @Override
    public void loadFilterCmb(JComboBox<String> BrandFilterCmb, JComboBox<String> CategoryFilterCmb) throws Exception {
        try (Connection con = this.getConnection()) {
            String queryBrand = "select nombre from marcas;";
            String queryCategory = "select nombre from categorias;";
            fillComboBox(con, BrandFilterCmb, queryBrand);
            fillComboBox(con, CategoryFilterCmb, queryCategory);
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Error al ejecutar la operación de cargar los ComboBox de los filtros en la base de datos", e);
            throw e;
        }
    }

}
