package com.mycompany.views;

import com.mycompany.heycha.DAOProductsImpl;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProducts;
import com.mycompany.db.Database;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Ovett
 */
public class UpProducts extends javax.swing.JPanel {

    /**
     * Creates new form UpProducts
     */
    public UpProducts() {
        initComponents();
        initStyles();
        try {
            loadCategories(brandCmb, categoryCmb, typeCmb);
        } catch (Exception ex) {
            Logger.getLogger(UpProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UpProducts(ModelProducts product) {
        initComponents();
        initStyles();
        try {
            loadCategories(brandCmb, categoryCmb, typeCmb);
        } catch (Exception ex) {
            Logger.getLogger(UpProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadCategories(JComboBox<String> brandCmb, JComboBox<String> categoryCmb, JComboBox<String> typeCmb) throws Exception {
        Database d = new Database();

        try {
            d.connectDB();
            java.sql.Statement statement = d.connection.createStatement();
            String query = "SELECT M.NOMBRE AS NOMBRE_MARCA, C.NOMBRE AS NOMBRE_CATEGORIA, T.NOMBRE AS NOMRBE_TIPO FROM PRODUCTOS P INNER JOIN MARCAS M ON P.ID_MARCA = M.ID INNER JOIN CATEGORIAS C ON P.ID_CATEGORIA = C.ID INNER JOIN TIPO T ON P.ID_TIPO = T.ID;";
            boolean result = statement.execute(query);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                brandCmb.addItem(resultSet.getString(1));
                categoryCmb.addItem(resultSet.getString(2));
                typeCmb.addItem(resultSet.getString(3));
            }
            brandCmb.setSelectedIndex(-1);
            categoryCmb.setSelectedIndex(-1);
            typeCmb.setSelectedIndex(-1);

        } catch (Exception e) {
            throw e;
        } finally {
            d.closeDB();
        }

    }

    private void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        nameLbl.putClientProperty("FlatLaf.styleClass", "h2");
        priceLbl.putClientProperty("FlatLaf.styleClass", "h2");
        descriptionLbl.putClientProperty("FlatLaf.styleClass", "h2");
        discountLbl.putClientProperty("FlatLaf.styleClass", "h2");
        BrandLbl.putClientProperty("FlatLaf.styleClass", "h2");
        categoryLbl.putClientProperty("FlatLaf.styleClass", "h2");
        typeLbl.putClientProperty("FlatLaf.styleClass", "h2");

        title.setForeground(Color.black);

        nameTxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto.");
        priceTxt.putClientProperty("JTextField.placeholderText", "Ingrese el precio del producto.");
        descriptionTxt.putClientProperty("JTextField.placeholderText", "Ingrese una descripcion para el producto");
        discountTxt.putClientProperty("JTextField.placeholderText", "Ingrese el descuento que tendrá el producto. (opcional)");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        priceLbl = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        descriptionTxt = new javax.swing.JTextField();
        BrandLbl = new javax.swing.JLabel();
        discountLbl = new javax.swing.JLabel();
        discountTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        categoryLbl = new javax.swing.JLabel();
        typeLbl = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        descriptionLbl = new javax.swing.JLabel();
        brandCmb = new javax.swing.JComboBox<>();
        categoryCmb = new javax.swing.JComboBox<>();
        typeCmb = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(764, 436));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Subir nuevo producto.");

        nameLbl.setText("Nombre:");

        priceLbl.setText("Precio:");

        BrandLbl.setText("Marca:");

        discountLbl.setText("Descuento (Opcional):");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        categoryLbl.setText("Categoria:");

        typeLbl.setText("Tipo (Opcional):");

        button.setBackground(new java.awt.Color(18, 90, 173));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Subir");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        descriptionLbl.setText("Descripción (Opcional):");

        brandCmb.setSelectedIndex(-1);
        brandCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brandCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        brandCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        categoryCmb.setSelectedIndex(-1);
        categoryCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        categoryCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        typeCmb.setSelectedIndex(-1);
        typeCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        typeCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        typeCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addGap(619, 619, 619))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(181, 181, 181))
                            .addComponent(nameTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(160, 160, 160))
                            .addComponent(priceTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(158, 158, 158))
                            .addComponent(descriptionTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(137, 137, 137))
                            .addComponent(discountTxt))
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(209, 209, 209))
                            .addComponent(categoryCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(188, 188, 188))
                            .addComponent(brandCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(typeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(205, 205, 205))
                            .addComponent(typeCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(categoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(BrandLbl)
                        .addGap(6, 6, 6)
                        .addComponent(brandCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(typeLbl)
                        .addGap(6, 6, 6)
                        .addComponent(typeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(priceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(descriptionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(discountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        String name = nameTxt.getText();
        Float price = null;
        if (!priceTxt.getText().isEmpty()) {
            try {
                price = Float.valueOf(priceTxt.getText());
                if (price < 1) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El precio no puede ser menor que 1. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    priceTxt.requestFocus();
                    return;
                }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el precio correctamente. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                priceTxt.requestFocus();
                return;
            }
        }
        String description = descriptionTxt.getText().isEmpty() ? null : descriptionTxt.getText();
        Integer discount = discountTxt.getText().isEmpty() ? null : Integer.valueOf(discountTxt.getText());
        Integer brand = brandCmb.getSelectedIndex() == -1 ? null : brandCmb.getSelectedIndex() + 1;
        Integer category = categoryCmb.getSelectedIndex() == -1 ? null : categoryCmb.getSelectedIndex() + 1;
        Integer type = typeCmb.getSelectedIndex() == -1 ? null : typeCmb.getSelectedIndex() + 1;

        boolean incorrectData = name.isEmpty() || price == null || brand == null || category == null;

        if (incorrectData) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            nameTxt.requestFocus();
            return;
        }

        ModelProducts product = new ModelProducts();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setIdBrand(brand);
        product.setIdCategory(category);
        product.setIdType(type);

        try {
            DAOProducts dao = new DAOProductsImpl();
            dao.record(product);
            javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            emptyFields();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar los datos. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_buttonActionPerformed

    private void emptyFields() {
        nameTxt.setText("");
        priceTxt.setText("");
        descriptionTxt.setText("");
        discountTxt.setText("");
        brandCmb.setSelectedIndex(-1);
        categoryCmb.setSelectedIndex(-1);
        typeCmb.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> brandCmb;
    private javax.swing.JButton button;
    private javax.swing.JComboBox<String> categoryCmb;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JLabel discountLbl;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<String> typeCmb;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables
}
