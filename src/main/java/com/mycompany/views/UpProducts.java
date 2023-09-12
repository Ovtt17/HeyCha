package com.mycompany.views;

import com.mycompany.heycha.DAOProductsImpl;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProducts;
import com.mycompany.db.Database;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JComboBox;

/**
 *
 * @author Ovett
 */
public class UpProducts extends javax.swing.JPanel {

    boolean isEditable = false;
    ModelProducts productEditable;

    public UpProducts() {
        initComponents();
        initStyles();
    }

    public UpProducts(ModelProducts product) {
        initComponents();
        isEditable = true;
        productEditable = product;
        initStyles();
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

        try {
            loadCmb(brandCmb, categoryCmb, typeCmb);
        } catch (Exception ex) {
            Logger.getLogger(UpProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (isEditable) {
            title.setText("Editar producto.");
            button.setText("Guardar");
            if (productEditable != null) {
                nameTxt.setText(productEditable.getName());
                priceTxt.setText(productEditable.getPrice().toString());

                descriptionTxt.setText(productEditable.getDescription());

                Integer discount = productEditable.getDiscount() == null ? 0 : productEditable.getDiscount();
                discountTxt.setText(discount.toString());
                
                /**
                 * disminuir 1 para no generar un overflow, por el hecho de que los indices de los comboBox empiezan de 0
                 */
                int indexBrand = productEditable.getIdBrand() - 1;
                brandCmb.setSelectedIndex(indexBrand);

                int indexCategory = productEditable.getIdCategory() - 1;
                categoryCmb.setSelectedIndex(indexCategory);

                Integer type = productEditable.getIdType() == null ? -1 : productEditable.getIdType();
                typeCmb.setSelectedIndex(type);
            }
        }

    }

    public void loadCmb(JComboBox<String> brandCmb, JComboBox<String> categoryCmb, JComboBox<String> typeCmb) throws Exception {

        Database d = new Database();

        try {
            d.connectDB();
            String queryBrand = "select nombre from marcas;";
            String queryCategory = "select nombre from categorias;";
            String queryType = "select nombre from tipo;";
            fillComboBox(brandCmb, queryBrand, d);
            fillComboBox(categoryCmb, queryCategory, d);
            fillComboBox(typeCmb, queryType, d);

        } catch (Exception e) {
            throw e;
        } finally {
            d.closeDB();
        }

    }

    private void fillComboBox(JComboBox<String> comboBox, String query, Database d) throws SQLException {
        Statement statement = d.connection.createStatement();
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            comboBox.addItem(resultSet.getString(1));
        }

        statement.close();
        resultSet.close();
        comboBox.setSelectedIndex(-1);
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
        categoryLbl = new javax.swing.JLabel();
        typeLbl = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        descriptionLbl = new javax.swing.JLabel();
        brandCmb = new javax.swing.JComboBox<>();
        categoryCmb = new javax.swing.JComboBox<>();
        typeCmb = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        spinnerSizeXS = new javax.swing.JSpinner();
        spinnerSizeM = new javax.swing.JSpinner();
        spinnerSizeS = new javax.swing.JSpinner();
        spinnerSizeL = new javax.swing.JSpinner();
        spinnerSizeXL = new javax.swing.JSpinner();
        sizeXSLbl = new javax.swing.JLabel();
        sizeSLbl = new javax.swing.JLabel();
        sizeMLbl = new javax.swing.JLabel();
        sizeLLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(764, 436));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Subir nuevo producto.");

        nameLbl.setText("Nombre:");

        priceLbl.setText("Precio:");

        BrandLbl.setText("Marca:");

        discountLbl.setText("Descuento (Opcional):");

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

        brandCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brandCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        brandCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        categoryCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        categoryCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        typeCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        typeCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        typeCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        spinnerSizeXS.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerSizeM.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerSizeS.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerSizeL.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerSizeXL.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        sizeXSLbl.setText("XS");

        sizeSLbl.setText("S");

        sizeMLbl.setText("M");

        sizeLLbl.setText("L");

        jLabel5.setText("XL");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addGap(288, 288, 288))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(299, 299, 299))
                            .addComponent(priceTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(210, 210, 210))
                            .addComponent(descriptionTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(216, 216, 216))
                            .addComponent(discountTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeLbl))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(286, 286, 286))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(308, 308, 308))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brandCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                        .addComponent(sizeMLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(4, 4, 4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                        .addComponent(sizeXSLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                        .addComponent(sizeSLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(15, 15, 15)))
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(spinnerSizeM))
                                    .addComponent(spinnerSizeXS, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerSizeS, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(134, 134, 134)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(sizeLLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerSizeXL)
                                    .addComponent(spinnerSizeL))))
                        .addGap(16, 16, 16))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(brandCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sizeLLbl))
                                        .addGap(20, 20, 20)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeXL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(34, 34, 34)
                                        .addComponent(sizeMLbl))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeXS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sizeXSLbl))
                                        .addGap(20, 20, 20)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sizeSLbl))
                                        .addGap(27, 27, 27)
                                        .addComponent(spinnerSizeM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))))
                .addContainerGap())
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
                    javax.swing.JOptionPane.showMessageDialog(this, "El precio no puede ser menor que $1. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
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
        Integer discount = (discountTxt.getText().isEmpty() || Integer.valueOf(discountTxt.getText()) <= 1) ? null : Integer.valueOf(discountTxt.getText());
        Integer brand = brandCmb.getSelectedIndex() == -1 ? null : brandCmb.getSelectedIndex() + 1;
        Integer category = categoryCmb.getSelectedIndex() == -1 ? null : categoryCmb.getSelectedIndex() + 1;
        Integer type = typeCmb.getSelectedIndex() == -1 ? null : typeCmb.getSelectedIndex() + 1;

        boolean incorrectData = name.isEmpty() || price == null || brand == null || category == null;

        if (incorrectData) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            nameTxt.requestFocus();
            return;
        }

        ModelProducts product = isEditable ? productEditable : new ModelProducts();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setIdBrand(brand);
        product.setIdCategory(category);
        product.setIdType(type);

        try {
            DAOProducts dao = new DAOProductsImpl();
            if (!isEditable) {
                dao.record(product);
            } else {
                dao.modify(product);
            }

            String succecssMsg = isEditable ? "modificado" : "registrado";
            javax.swing.JOptionPane.showMessageDialog(this, "Datos " + succecssMsg + " correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (!isEditable) {
                emptyFields();
            }
        } catch (Exception e) {
            String errorMsg = isEditable ? "modificar" : "registrar";
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al " + errorMsg + " los datos. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JLabel sizeLLbl;
    private javax.swing.JLabel sizeMLbl;
    private javax.swing.JLabel sizeSLbl;
    private javax.swing.JLabel sizeXSLbl;
    private javax.swing.JSpinner spinnerSizeL;
    private javax.swing.JSpinner spinnerSizeM;
    private javax.swing.JSpinner spinnerSizeS;
    private javax.swing.JSpinner spinnerSizeXL;
    private javax.swing.JSpinner spinnerSizeXS;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<String> typeCmb;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables
}
