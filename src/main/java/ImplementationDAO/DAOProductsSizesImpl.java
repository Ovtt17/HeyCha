package ImplementationDAO;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.models.ModelProductSizes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProductsSizesImpl extends Database implements DAOProductSizes {

    @Override
    public void record(ModelProductSizes productSize) throws Exception {
        try {
            this.connectDB();
            String query = "INSERT INTO PRODUCTOS_TALLAS(ID_PRODUCTO, ID_TALLA, CANTIDAD_INVENTARIO) VALUES (?,?,?);";
            PreparedStatement st = this.connection.prepareStatement(query);
            sendRecordedFields(st, productSize);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
    }

    private void sendRecordedFields(PreparedStatement st, ModelProductSizes productSize) throws SQLException {
        st.setInt(1, productSize.getIdProduct());
        st.setInt(2, productSize.getIdSize());
        st.setInt(3, productSize.getAmount());
    }

    private void sendModifiedFields(PreparedStatement st, ModelProductSizes productSize) throws SQLException {
        st.setInt(1, productSize.getAmount());
        st.setInt(2, productSize.getIdProduct());
        st.setInt(3, productSize.getIdSize());
    }

    @Override
    public boolean modify(ModelProductSizes productSize) throws Exception {
        boolean isModified = false;
        try {
            this.connectDB();
            String query = "UPDATE PRODUCTOS_TALLAS SET CANTIDAD_INVENTARIO = ? WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            PreparedStatement st = this.connection.prepareStatement(query);
            sendModifiedFields(st, productSize);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                isModified = true;
            }
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }
        return isModified;
    }

    @Override
    public void delete(int productId) throws Exception {
        try {
            this.connectDB();
            String query = "DELETE FROM PRODUCTOS_TALLAS WHERE ID_PRODUCTO = ?;";
            PreparedStatement pst = this.connection.prepareStatement(query);
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
    public List<ModelProductSizes> consult(int productId) throws Exception {
        List<ModelProductSizes> list = null;
        try {
            this.connectDB();
            String query = "select pt.id_producto, p.nombre, t.talla, cantidad_inventario\n"
                    + "from productos_tallas pt \n"
                    + "inner join productos p on p.ID = pt.ID_Producto\n"
                    + "inner join tallas t on t.id = pt.ID_Talla\n"
                    + "where pt.ID_Producto = ?\n"
                    + "order by p.nombre, pt.ID_Producto desc;";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, productId);
            list = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ModelProductSizes pSize = new ModelProductSizes();
                setProductSizesForConsult(rs, pSize);
                list.add(pSize);
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

    private void setProductSizesForConsult(ResultSet rs, ModelProductSizes pSize) throws SQLException {
        pSize.setIdProduct(rs.getInt("ID_PRODUCTO"));
        pSize.setNameProduct(rs.getString("NOMBRE"));
        pSize.setNameSize(rs.getString("TALLA"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

    @Override
    public void deleteIfZero(ModelProductSizes productSize) throws Exception {
        try {
            this.connectDB();
            String query = "DELETE FROM PRODUCTOS_TALLAS WHERE ID_PRODUCTO = ? AND ID_TALLA = ?;";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, productSize.getIdProduct());
            st.setInt(2, productSize.getIdSize());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.closeDB();
        }

    }

    @Override
    public List<ModelProductSizes> getProductSizesById(int productId) throws Exception {
        List<ModelProductSizes> list = null;
        try {
            this.connectDB();
            String query = "SELECT * FROM productos_tallas WHERE ID_Producto = ?;";
            PreparedStatement st = this.connection.prepareStatement(query);
            st.setInt(1, productId);
            list = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ModelProductSizes pSize = new ModelProductSizes();
                setProductSizesForModify(rs, pSize);
                list.add(pSize);
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

    private void setProductSizesForModify(ResultSet rs, ModelProductSizes pSize) throws SQLException {
        pSize.setIdProduct(rs.getInt("ID_PRODUCTO"));
        pSize.setIdSize(rs.getInt("ID_TALLA"));
        pSize.setAmount(rs.getInt("CANTIDAD_INVENTARIO"));
    }

}
