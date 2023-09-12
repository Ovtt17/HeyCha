package com.mycompany.heycha;

import com.google.protobuf.Empty;
import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProducts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOProductsImpl extends Database implements DAOProducts {

    @Override
    public void record(ModelProducts product) throws Exception {
        try {
            this.connectDB();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO PRODUCTOS(NOMBRE, PRECIO, DESCRIPCION, DESCUENTO, ID_MARCA, ID_CATEGORIA, ID_TIPO) VALUES (?,?,?,?,?,?,?);");
            setProductFieldsToDB(st, product);
            // Ejecuta la sentencia SQL
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    private void setProductFieldsToDB(PreparedStatement st, ModelProducts product) throws SQLException {
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
    public void modify(ModelProducts product) throws Exception {
        try {
            this.connectDB();
            PreparedStatement st = this.connection.prepareCall("UPDATE PRODUCTOS SET NOMBRE = ?, PRECIO = ?, DESCRIPCION = ?, DESCUENTO = ?, ID_MARCA = ?, ID_CATEGORIA = ?, ID_TIPO = ? WHERE ID = ?;");
            setProductFieldsToDB(st, product);
            st.setInt( 8, product.getId());
            st.executeUpdate();
            st.close();            
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public void delete(int productId) throws Exception {
        try {
            this.connectDB();
            PreparedStatement pst = this.connection.prepareStatement("DELETE FROM PRODUCTOS WHERE ID = ?");
            pst.setInt(1, productId);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public List<ModelProducts> consult() throws Exception {
        List<ModelProducts> list = null;
        try {
            this.connectDB();
            String Query = "SELECT * FROM productos;";
            PreparedStatement st = this.connection.prepareStatement(Query);
            list = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ModelProducts product = new ModelProducts();
                setProductFieldsFromDB(rs, product);
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

    private void setProductFieldsFromDB(ResultSet rs, ModelProducts product) throws SQLException {
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("Nombre"));
        product.setPrice(rs.getFloat("Precio"));

        // hacer estas validaciones para evitar que muestre datos que no ordene
        String description = rs.getString("Descripcion");
        product.setDescription(rs.wasNull() ? null : description);

        int discount = rs.getInt("Descuento");
        product.setDiscount(rs.wasNull() ? null : discount);
        
        int idBrand = rs.getInt("ID_Marca");
        product.setIdBrand(idBrand);
        int idCat = rs.getInt("ID_Categoria");
        product.setIdCategory(idCat);

        int idType = rs.getInt("ID_Tipo");
        product.setIdType(rs.wasNull() ? null : idType);
    }

    @Override
    public ModelProducts getProductById(int productId) throws Exception {
        ModelProducts product = new ModelProducts();

        try {
            this.connectDB();
            PreparedStatement st = this.connection.prepareStatement("SELECT * FROM PRODUCTOS WHERE ID = ? LIMIT 1;");
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                setProductFieldsFromDB(rs, product);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return product;
    }
}
