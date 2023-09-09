package com.mycompany.heycha;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProducts;
import java.sql.PreparedStatement;
import java.util.List;

public class DAOProductsImpl extends Database implements DAOProducts {

    @Override
    public void record(ModelProducts product) throws Exception {
        try {
            this.ConnectDB();
            PreparedStatement st = this.connection.prepareStatement("INSERT INTO PRODUCTOS(NOMBRE, PRECIO, DESCRIPCION, DESCUENTO, ID_MARCA, ID_CATEGORIA, ID_TIPO) VALUES (?,?,?,?,?,?,?);");
            // Asigna los valores para los parámetros de la sentencia SQL
            st.setString(1, product.getName()); // Reemplaza con el método adecuado para obtener el nombre
            st.setFloat(2, product.getPrice());   // Reemplaza con el método adecuado para obtener el precio
            st.setString(3, product.getDescription()); // Reemplaza con el método adecuado para obtener la descripción
            st.setInt(4, product.getDiscount()); // Reemplaza con el método adecuado para obtener el descuento
            st.setInt(5, product.getIdBrand()); // Reemplaza con el método adecuado para obtener el ID de la marca
            st.setInt(6, product.getIdCategory()); // Reemplaza con el método adecuado para obtener el ID de la categoría
            st.setInt(7, product.getIdType()); // Reemplaza con el método adecuado para obtener el ID del tipo

            // Ejecuta la sentencia SQL
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.CloseDB();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
