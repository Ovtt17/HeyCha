package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProducts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOProductsImpl extends Database implements DAOProducts {

    @Override
    public void record(ModelProducts product) throws Exception {
        try {
            this.connectDB();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO PRODUCTOS(NOMBRE, PRECIO, DESCRIPCION, DESCUENTO, ID_MARCA, ID_CATEGORIA, ID_TIPO) VALUES (?,?,?,?,?,?,?);");
            // Asigna los valores para los parámetros de la sentencia SQL
            st.setString(1, product.getName()); // Reemplaza con el método adecuado para obtener el nombre
            st.setFloat(2, product.getPrice());   // Reemplaza con el método adecuado para obtener el precio
            if(product.getDescription() != null) {
                st.setString(3, product.getDescription()); // Reemplaza con el método adecuado para obtener la descripción
            } else{
                st.setNull(3,Types.VARCHAR);
            }
            if (product.getDiscount() != null){
                st.setInt(4, product.getDiscount()); // Reemplaza con el método adecuado para obtener el descuento
            } else {
                st.setNull(4, Types.INTEGER);
            }
            
            st.setInt(5, product.getIdBrand()); // Reemplaza con el método adecuado para obtener el ID de la marca
            st.setInt(6, product.getIdCategory()); // Reemplaza con el método adecuado para obtener el ID de la categoría
            
            if(product.getIdType() != null) {
                st.setInt(7, product.getIdType()); // Reemplaza con el método adecuado para obtener el ID del tipo
            } else {
                st.setNull(7, Types.INTEGER);
            }
            

            // Ejecuta la sentencia SQL
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    @Override
    public void modify(ModelProducts product) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ModelProducts product) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("Nombre"));
                product.setPrice(rs.getFloat("Precio"));
                product.setDescription(rs.getString("Descripcion"));
                product.setDiscount(rs.getInt("Descuento"));
                product.setIdBrand(rs.getInt("ID_Marca"));
                product.setIdCategory(rs.getInt("ID_Categoria"));
                product.setIdType(rs.getInt("ID_Tipo"));
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
}
