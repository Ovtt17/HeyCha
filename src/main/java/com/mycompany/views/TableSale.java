package com.mycompany.views;

import ImplementationDAO.DAOProductsImpl;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import com.mycompany.models.ModelSalesProducts;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class TableSale extends javax.swing.JDialog {

    UpSales upSales;
    ViewProducts p = new ViewProducts();
    List<ModelProducts> products;
    Float productPrice;
    

    public TableSale(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTable();
    }

    public TableSale(java.awt.Frame parent, boolean modal, UpSales upSales) {
        super(parent, modal);
        initComponents();
        initTable();
        this.upSales = upSales;
    }

    private TableSale() {

    }

    private void initTable() {
        this.setLocationRelativeTo(null);
        DefaultTableModel modelProduct = (DefaultTableModel) jTableProducts.getModel();
        jTableProducts.setDefaultEditor(Object.class, null);
        modelProduct.setRowCount(0);
        String nameToFind = productSearch.getText();
        String brandSelected = "NINGUNO";
        String categorySelected = "NINGUNO";
        try {
            DAOProducts dao = new DAOProductsImpl();
            products = dao.consult(nameToFind, brandSelected, categorySelected);
            products.forEach((p) -> {
                modelProduct.addRow(new Object[]{p.getId(), p.getName(), p.getBrandName(), p.getCategoryName(), p.getSizeAvailable(), p.getTotalExistence(), p.getPrice()});
                
            });
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        try {
            DAOProducts dao = new DAOProductsImpl();
            dao.loadFilterCmb(BrandFilterCmb, CategoryFilterCmb);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        jTableProducts.setModel(modelProduct);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        BrandFilterCmb = new javax.swing.JComboBox<>();
        CategoryFilterCmb = new javax.swing.JComboBox<>();
        BrandLbl = new javax.swing.JLabel();
        CategoryLbl = new javax.swing.JLabel();
        btnCleanField = new javax.swing.JButton();
        AmountSpinner = new javax.swing.JSpinner();
        amountLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        background_products.setBackground(new java.awt.Color(255, 255, 255));
        background_products.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_products.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Productos");

        productSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productSearchKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Categoria", "Tallas Disponibles", "Total Existencia", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setRowHeight(30);
        jTableProducts.getTableHeader().setReorderingAllowed(false);
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
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

        BrandFilterCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO" }));
        BrandFilterCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BrandFilterCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BrandFilterCmbItemStateChanged(evt);
            }
        });

        CategoryFilterCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO" }));
        CategoryFilterCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CategoryFilterCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CategoryFilterCmbItemStateChanged(evt);
            }
        });

        BrandLbl.setText("Marca:");

        CategoryLbl.setText("Categoria:");

        btnCleanField.setBackground(new java.awt.Color(21, 101, 192));
        btnCleanField.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanField.setText("Limpiar Campos");
        btnCleanField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCleanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFieldActionPerformed(evt);
            }
        });

        AmountSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        amountLbl.setText("Cantidad:");

        javax.swing.GroupLayout background_productsLayout = new javax.swing.GroupLayout(background_products);
        background_products.setLayout(background_productsLayout);
        background_productsLayout.setHorizontalGroup(
            background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_productsLayout.createSequentialGroup()
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(background_productsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amountLbl)
                        .addGap(18, 18, 18)
                        .addComponent(AmountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_productsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(background_productsLayout.createSequentialGroup()
                                .addComponent(productSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BrandLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BrandFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CategoryLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CategoryFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCleanField))
                            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        background_productsLayout.setVerticalGroup(
            background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_productsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BrandFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoryFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BrandLbl)
                    .addComponent(CategoryLbl)
                    .addComponent(btnCleanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountLbl))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_products, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_products, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productSearchKeyReleased
        if (!BrandFilterCmb.isEnabled() || !CategoryFilterCmb.isEnabled() || !btnCleanField.isEnabled() && !productSearch.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No puede realizar búsqueda dentro de los detalles de un producto. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            productSearch.setText("");
            return;
        } else {
            filteredConsult();
        }
    }//GEN-LAST:event_productSearchKeyReleased

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        if (evt.getClickCount() == 1) {
            int selectedRow = jTableProducts.getSelectedRow();
            if (model.getColumnCount() < 7) {
                String cellValue = model.getValueAt(selectedRow, 4).toString();
                int maximumAmount = Integer.parseInt(cellValue);
                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, maximumAmount, 1);
                AmountSpinner.setModel(spinnerModel);
            }
        } else if (evt.getClickCount() == 2) {
            //TODO
            if (model.getColumnCount() > 5) {
                int selectedRow = jTableProducts.getSelectedRow();
                productPrice = (Float) jTableProducts.getValueAt(selectedRow, 6);
                
                p.loadProductSize(jTableProducts);
                
                btnCleanField.setEnabled(false);
                BrandFilterCmb.setEnabled(false);
                CategoryFilterCmb.setEnabled(false);
                productSearch.setText("");
            }

        }

    }//GEN-LAST:event_jTableProductsMouseClicked

    private void BrandFilterCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BrandFilterCmbItemStateChanged
        filteredConsult();
    }//GEN-LAST:event_BrandFilterCmbItemStateChanged

    private void CategoryFilterCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CategoryFilterCmbItemStateChanged
        filteredConsult();
    }//GEN-LAST:event_CategoryFilterCmbItemStateChanged

    private void btnCleanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldActionPerformed
        productSearch.setText("");
        BrandFilterCmb.setSelectedIndex(0);
        CategoryFilterCmb.setSelectedIndex(0);
        filteredConsult();
    }//GEN-LAST:event_btnCleanFieldActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int selectedRow = jTableProducts.getSelectedRow();
        if (selectedRow < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para agregarlo al carrito. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer productSizeId = (Integer) jTableProducts.getValueAt(selectedRow, 0);
        Integer productId = (Integer) jTableProducts.getValueAt(selectedRow, 1);
        String productName = (String) jTableProducts.getValueAt(selectedRow, 2);
        String sizeName = (String) jTableProducts.getValueAt(selectedRow, 3);
        
        Float price = productPrice;
        Integer amount = (Integer) AmountSpinner.getValue();

        ModelSalesProducts salesDetails = new ModelSalesProducts(productSizeId, productId, productName, sizeName, price, amount);
        upSales.addProduct(salesDetails);
        javax.swing.JOptionPane.showMessageDialog(this, "El producto se ha agregado al carrito de compras. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void filteredConsult() {
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        model.setRowCount(0);
        String productNameToSearch = productSearch.getText().toLowerCase();

        for (ModelProducts p : products) {
            if (p.getName().toLowerCase().contains(productNameToSearch)) {
                model.addRow(new Object[]{p.getId(), p.getName(), p.getBrandName(), p.getCategoryName(), p.getPrice()});
                break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AmountSpinner;
    private javax.swing.JComboBox<String> BrandFilterCmb;
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JComboBox<String> CategoryFilterCmb;
    private javax.swing.JLabel CategoryLbl;
    private javax.swing.JLabel amountLbl;
    private javax.swing.JPanel background_products;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCleanField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField productSearch;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
