package com.mycompany.views;

import com.mycompany.heycha.DAOProductsImpl;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProducts;
import com.mycompany.db.Database;
import com.mycompany.heycha.DAOProductsSizesImpl;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.models.ModelProductSizes;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class UpProducts extends javax.swing.JPanel {

    boolean isEditable = false;
    ModelProducts productEditable;
    List<ModelProductSizes> listEditable;

    HashMap<String, JSpinner> spinnerMap = new HashMap<>();
    HashMap<String, JCheckBox> checkBoxMap = new HashMap<>();
    String[] sizes = {"XS", "S", "M", "L", "XL"};

    public UpProducts() {
        initComponents();
        initStyles();
    }

    public UpProducts(ModelProducts product, List<ModelProductSizes> list) {
        initComponents();
        isEditable = true;
        productEditable = product;
        listEditable = list;
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
            DAOProducts dao = new DAOProductsImpl();
            dao.loadCmb(brandCmb, categoryCmb, typeCmb);
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

                brandCmb.setSelectedItem(productEditable.getBrand());

                categoryCmb.setSelectedItem(productEditable.getCategory());

                String type = productEditable.getType();
                if (type == null) {
                    typeCmb.setSelectedIndex(-1);
                } else {
                    typeCmb.setSelectedItem(type);
                }
                typeCmb.setSelectedItem(type);

                loadSizes();
            }
        }

    }

    private void loadSizes() {
        spinnerMap.put("XS", spinnerSizeXS);
        spinnerMap.put("S", spinnerSizeS);
        spinnerMap.put("M", spinnerSizeM);
        spinnerMap.put("L", spinnerSizeL);
        spinnerMap.put("XL", spinnerSizeXL);

        checkBoxMap.put("XS", cbXS);
        checkBoxMap.put("S", cbS);
        checkBoxMap.put("M", cbM);
        checkBoxMap.put("L", cbL);
        checkBoxMap.put("XL", cbXL);

        for (ModelProductSizes pSize : listEditable) {
            String size = sizes[pSize.getIdSize() - 1];
            int spinnerValue = pSize.getAmount() == null ? 0 : pSize.getAmount();

            if (spinnerMap.containsKey(size)) {
                spinnerMap.get(size).setValue(spinnerValue);
                if (spinnerValue != 0) {
                    checkBoxMap.get(size).setSelected(true);
                }
            }
        }
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
        cbXS = new javax.swing.JCheckBox();
        cbS = new javax.swing.JCheckBox();
        cbM = new javax.swing.JCheckBox();
        cbL = new javax.swing.JCheckBox();
        cbXL = new javax.swing.JCheckBox();

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

        cbXS.setText("XS");

        cbS.setText("S");

        cbM.setText("M");

        cbL.setText("L");

        cbXL.setText("XL");

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
                                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(typeLbl)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(typeCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(137, 137, 137)))))
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbXS)
                                            .addComponent(cbS))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(spinnerSizeXS, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spinnerSizeS, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(cbM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerSizeM)))
                                .addGap(84, 84, 84)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbL)
                                    .addComponent(cbXL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerSizeXL)
                                    .addComponent(spinnerSizeL))))
                        .addGap(16, 16, 16))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brandCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(134, 134, 134))))
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
                                .addGap(15, 15, 15))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(brandCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbL))
                                        .addGap(20, 20, 20)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeXL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbXL)))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeXS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbXS))
                                        .addGap(20, 20, 20)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbS))
                                        .addGap(27, 27, 27)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spinnerSizeM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbM))))
                                .addGap(32, 32, 32)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
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
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
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
        Integer idBrand = brandCmb.getSelectedIndex() == -1 ? null : brandCmb.getSelectedIndex() + 1;
        Integer idCategory = categoryCmb.getSelectedIndex() == -1 ? null : categoryCmb.getSelectedIndex() + 1;
        Integer idType = typeCmb.getSelectedIndex() == -1 ? null : typeCmb.getSelectedIndex() + 1;

        boolean incorrectData = name.isEmpty() || price == null || idBrand == null || idCategory == null;

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
        product.setIdBrand(idBrand);
        product.setIdCategory(idCategory);
        product.setIdType(idType);

        ModelProductSizes pSizes = new ModelProductSizes();

        spinnerMap.put("XS", spinnerSizeXS);
        spinnerMap.put("S", spinnerSizeS);
        spinnerMap.put("M", spinnerSizeM);
        spinnerMap.put("L", spinnerSizeL);
        spinnerMap.put("XL", spinnerSizeXL);

        checkBoxMap.put("XS", cbXS);
        checkBoxMap.put("S", cbS);
        checkBoxMap.put("M", cbM);
        checkBoxMap.put("L", cbL);
        checkBoxMap.put("XL", cbXL);
        try {
            DAOProducts dao = new DAOProductsImpl();
            DAOProductSizes daoSize = new DAOProductsSizesImpl();
            

            boolean selected = false;
            for (String size : sizes) {
                int spinnervalue = (int) spinnerMap.get(size).getValue();
                if (spinnervalue  != 0 && checkBoxMap.get(size).isSelected()) {
                    selected = true;
                }
            }
            if (!selected) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar correctamente las tallas. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isEditable) {
                dao.record(product, pSizes);
                for (String size : sizes) {
                    int spinnervalue = (int) spinnerMap.get(size).getValue();
                    if (spinnervalue != 0 && checkBoxMap.get(size).isSelected()) {
                        pSizes.setAmount(spinnervalue);
                        pSizes.setIdSize(Arrays.asList(sizes).indexOf(size) + 1);
                        daoSize.record(pSizes);
                    }
                }
            } else {
                dao.modify(product, pSizes);
                for (String size : sizes) {
                    int spinnervalue = (int) spinnerMap.get(size).getValue();
                    boolean isNotSelectedButHasValue = !checkBoxMap.get(size).isSelected() && spinnervalue != 0;

                    if (isNotSelectedButHasValue) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Debe marcar la talla que desea modificar.\n\nSi desea borrar una debe igualar a 0 y marcarla.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    pSizes.setAmount(spinnervalue);
                    pSizes.setIdSize(Arrays.asList(sizes).indexOf(size) + 1);

                    boolean isSelectedButHasNoValue = checkBoxMap.get(size).isSelected() && spinnervalue == 0;
                    if (isSelectedButHasNoValue) {
                        daoSize.deleteIfZero(pSizes);
                        continue;
                    }

                    boolean isSelectedAndHasValue = spinnervalue != 0 && checkBoxMap.get(size).isSelected();
                    if (isSelectedAndHasValue) {
                        boolean isModified = daoSize.modify(pSizes);
                        if (!isModified) {
                            daoSize.record(pSizes);
                        }
                    }
                }
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

        for (String size : sizes) {
            if (spinnerMap.containsKey(size)) {
                spinnerMap.get(size).setValue(0);
                checkBoxMap.get(size).setSelected(false);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> brandCmb;
    private javax.swing.JButton button;
    private javax.swing.JComboBox<String> categoryCmb;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JCheckBox cbL;
    private javax.swing.JCheckBox cbM;
    private javax.swing.JCheckBox cbS;
    private javax.swing.JCheckBox cbXL;
    private javax.swing.JCheckBox cbXS;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JLabel discountLbl;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxt;
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
