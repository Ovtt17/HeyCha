/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.models.ModelProducts;
import java.awt.Color;

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
    }

    public UpProducts(ModelProducts product){
        initComponents();
        initStyles();
    }  
    
    private void initStyles(){
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
        descriptionTxt.putClientProperty("JTextField.placeholderText","Ingrese una descripcion para el producto");
        discountTxt.putClientProperty("JTextField.placeholderText", "Ingrese el descuento que tendrá el producto. (opcional)");
//        brandTxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre de la marca.");
//        categoryTxt.putClientProperty("JTextField.placeholderText", "Ingre la categoria a la que pertenece.");
//        typeTxt.putClientProperty("JTextField.placeholderText", "Ingrese el tipo al que pertenece. (opcional)");
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
        TypeCmb = new javax.swing.JComboBox<>();

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
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        descriptionLbl.setText("Descripción:");

        brandCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tommy", "Nautica", "Polo Ralph Lauren", "GAP", "Guess", "Aeropostale", "Levis", "Lacoste" }));
        brandCmb.setSelectedIndex(-1);
        brandCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brandCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        brandCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        categoryCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camisas Normales", "Camisas de Vestir Elegantes", "Camisas de Vestir Clasicas", "Camisas de Vestir Jeans", "Bolsos", "Chinelas", "Vestidos", "Pantalones", "Short", "Mochilas" }));
        categoryCmb.setSelectedIndex(-1);
        categoryCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        categoryCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        TypeCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Cuadrada/Rayada", "Amarrar" }));
        TypeCmb.setSelectedIndex(-1);
        TypeCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TypeCmb.setMinimumSize(new java.awt.Dimension(64, 22));
        TypeCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(248, 248, 248))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(175, 175, 175))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(241, 241, 241))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(177, 177, 177))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(discountTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descriptionTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTxt, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(67, 67, 67)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(300, 300, 300))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TypeCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(categoryCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(brandCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(typeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(292, 292, 292))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(463, 463, 463))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(categoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brandCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(typeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TypeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 764, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed

    }//GEN-LAST:event_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JComboBox<String> TypeCmb;
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
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables
}
