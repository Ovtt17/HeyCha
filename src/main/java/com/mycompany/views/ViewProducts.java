package com.mycompany.views;

import com.mycompany.heycha.DAOProductsImpl;
import com.mycompany.heycha.Dashboard;
import com.mycompany.interfaces.DAOProducts;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ovett
 */
public class ViewProducts extends javax.swing.JPanel {

    /**
     * Creates new form products
     */
    public ViewProducts() {
        initComponents();
        initStyles();
        loadProducts();
    }

    private void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        productSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto a buscar.");
    }

    private void loadProducts() {
        try {
            DAOProducts dao = new DAOProductsImpl();
            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
            dao.consult().forEach((p) -> model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice(), p.getDescription(), p.getDiscount(), p.getIdBrand(), p.getIdCategory(), p.getIdType()}));
            dao.consult().forEach((p) -> System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getDescription() + " " + p.getDiscount()));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_products = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        productSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(764, 436));

        background_products.setBackground(new java.awt.Color(255, 255, 255));
        background_products.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_products.setMinimumSize(new java.awt.Dimension(0, 0));
        background_products.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Productos");

        btnSearch.setBackground(new java.awt.Color(21, 101, 192));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Descripcion", "Descuento", "ID_Marca", "ID_Categoria", "ID_Tipo"
            }
        ));
        jScrollPane1.setViewportView(jTableProducts);

        btnAdd.setBackground(new java.awt.Color(21, 101, 192));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(21, 101, 192));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDelete.setBackground(new java.awt.Color(21, 101, 192));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout background_productsLayout = new javax.swing.GroupLayout(background_products);
        background_products.setLayout(background_productsLayout);
        background_productsLayout.setHorizontalGroup(
            background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_productsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(659, 659, 659))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_productsLayout.createSequentialGroup()
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_productsLayout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_productsLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(background_productsLayout.createSequentialGroup()
                                .addComponent(productSearch)
                                .addGap(28, 28, 28)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, 33))
        );
        background_productsLayout.setVerticalGroup(
            background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_productsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_products, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Dashboard.ShowPanel(new UpProducts());
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_products;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField productSearch;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
