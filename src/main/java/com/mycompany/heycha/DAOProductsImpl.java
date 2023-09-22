package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class DAOProductsImpl extends Database implements DAOProducts {

    @Override
    public void record(ModelProducts product, ModelProductSizes pSizes) throws Exception {
        try {
            this.connectDB();
            String query = "call insertProduct(?,?,?,?,?,?,?);";
            PreparedStatement st = this.connection.prepareStatement(query);
            setProductFieldsToModify(st, product);
            // Ejecuta la sentencia SQL
            st.executeUpdate();
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                //haciendo una consulta dentro del procedure para obtener el ultimo id insertado
                int idProducto = rs.getInt("idProduct");
                pSizes.setIdProduct(idProducto);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public void modify(ModelProducts product, ModelProductSizes pSizes) throws Exception {
        try {
            this.connectDB();
            PreparedStatement st = this.connection.prepareStatement("call modifyProduct(?, ?, ?, ?, ?, ?, ?, ?);");
            setProductFieldsToModify(st, product);
            st.executeUpdate();
            st.close();

            pSizes.setIdProduct(product.getId());
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    private void setProductFieldsToModify(PreparedStatement st, ModelProducts product) throws SQLException {
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
        st.setInt(8, product.getId());
    }

    @Override
    public void delete(int productId) throws Exception {
        try {
            this.connectDB();
            String deleteProduct = "call deleteProduct(?);";
            PreparedStatement pst = this.connection.prepareStatement(deleteProduct);

            String sqlResetId = "ALTER TABLE PRODUCTOS AUTO_INCREMENT = ?;";
            PreparedStatement pstAutoIncrement = this.connection.prepareStatement(sqlResetId);
            pst.setInt(1, productId);
            pstAutoIncrement.setInt(1, productId);

            pst.executeUpdate();
            pstAutoIncrement.executeUpdate();
            pst.close();
            pstAutoIncrement.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public List<ModelProducts> consult(String name, String brand, String category) throws Exception {
        List<ModelProducts> list = null;
        try {
            this.connectDB();
            String query = "call consultProducts(?, ?, ?);";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, brand);
            st.setString(3, category);
            list = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ModelProducts product = new ModelProducts();
                setProductFieldsToConsult(rs, product);
                list.add(product);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return list;
    }

    private void setProductFieldsToConsult(ResultSet rs, ModelProducts product) throws SQLException {
        product.setId(rs.getInt("ID"));
        product.setName(rs.getString("NOMBRE_PRODUCTO"));
        product.setPrice(rs.getFloat("PRECIO"));

        // hacer estas validaciones para evitar que muestre datos que no ordene
        String description = rs.getString("DESCRIPCION");
        product.setDescription(rs.wasNull() ? null : description);

        Integer discount = rs.getInt("DESCUENTO");
        product.setDiscount(rs.wasNull() ? null : discount);

        product.setBrand(rs.getString("NOMBRE_MARCA"));

        product.setCategory(rs.getString("NOMBRE_CATEGORIA"));

        String type = rs.getString("NOMBRE_TIPO");
        product.setType(rs.wasNull() ? null : type);
        
        product.setBrandAvailable(rs.getString("TALLAS_DISPONIBLES"));
        product.setTotalExistence(rs.getInt("TOTAL_EXISTENCIA"));
        product.setTotalPrice(rs.getFloat("VALOR_TOTAL"));
    }

    @Override
    public ModelProducts getProductById(int productId) throws Exception {
        ModelProducts product = new ModelProducts();

        try {
            this.connectDB();
            String query = "call consultByProductId(?);";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                setProductFieldsToConsult(rs, product);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return product;
    }

    @Override
    public void loadCmb(JComboBox<String> brandCmb, JComboBox<String> categoryCmb, JComboBox<String> typeCmb) throws Exception {

        try {
            this.connectDB();
            String queryBrand = "select nombre from marcas;";
            String queryCategory = "select nombre from categorias;";
            String queryType = "select nombre from tipo;";
            fillComboBox(brandCmb, queryBrand);
            fillComboBox(categoryCmb, queryCategory);
            fillComboBox(typeCmb, queryType);

        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public void fillComboBox(JComboBox<String> comboBox, String query) throws SQLException {
        Statement statement = this.connection.createStatement();
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            comboBox.addItem(resultSet.getString(1));
        }

        statement.close();
        resultSet.close();
        comboBox.setSelectedIndex(-1);
    }

    @Override
    public void loadFilterCmb(JComboBox<String> BrandFilterCmb, JComboBox<String> CategoryFilterCmb) throws Exception {
        try {
            this.connectDB();
            String queryBrand = "select nombre from marcas;";
            String queryCategory = "select nombre from categorias;";
            BrandFilterCmb.addItem("NINGUNO");
            CategoryFilterCmb.addItem("NINGUNO");
            fillComboBox(BrandFilterCmb, queryBrand);
            fillComboBox(CategoryFilterCmb, queryCategory); 
            BrandFilterCmb.setSelectedIndex(0);
            CategoryFilterCmb.setSelectedIndex(0);
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

}