package com.mycompany.views;

import ImplementationDAO.DAOProductsImpl;
import ImplementationDAO.DAOProductsSizesImpl;
import com.mycompany.heycha.Dashboard;
import com.mycompany.interfaces.DAOProductSizes;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.interfaces.Styleable;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelProducts;
import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewProducts extends javax.swing.JPanel implements Styleable {

    boolean lightOrDarkMode;
    List<ModelProducts> products;

    public ViewProducts(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        ViewProducts.this.loadProducts();
    }

    public ViewProducts() {

    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        lightOrDarkMode = isDarkModeEnabled;
        title.putClientProperty("FlatLaf.styleClass", "h1");

        productSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto a buscar.");

        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnCleanField.putClientProperty("JButton.buttonType", "roundRect");

        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            background_products.putClientProperty("FlatLaf.style", "background: #172030");

            btnAdd.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnCleanField.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            background_products.putClientProperty("FlatLaf.style", "background: #FFFFFF");

            btnAdd.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
            btnCleanField.putClientProperty("FlatLaf.style", "background: #1565C0");
        }
        btnDelete.setEnabled(true);
        btnCleanField.setEnabled(true);
        BrandFilterCmb.setEnabled(true);
        CategoryFilterCmb.setEnabled(true);
    }

    private void loadProducts() {
        DAOProducts dao = new DAOProductsImpl();
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        String nameToFind = "";
        String brandSelected = "NINGUNO";
        String categorySelected = "NINGUNO";
        try {
            products = dao.consult(nameToFind, brandSelected, categorySelected);
            products.forEach((p) -> model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice(), p.getBrand(), p.getCategory(), p.getType(), p.getSizeAvailable(), p.getTotalExistence(), p.getTotalPrice(), p.getDescription()}));
            dao.loadFilterCmb(BrandFilterCmb, CategoryFilterCmb);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        BrandFilterCmb = new javax.swing.JComboBox<>();
        CategoryFilterCmb = new javax.swing.JComboBox<>();
        BrandLbl = new javax.swing.JLabel();
        CategoryLbl = new javax.swing.JLabel();
        btnCleanField = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(764, 436));

        background_products.setBackground(new java.awt.Color(255, 255, 255));
        background_products.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_products.setMinimumSize(new java.awt.Dimension(0, 0));
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
                "ID", "Nombre", "Precio", "Marca", "Categoria", "Tipo", "Tallas Disponibles", "Total Existencia", "Valor Total", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        btnEdit.setBackground(new java.awt.Color(255, 183, 44));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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

        javax.swing.GroupLayout background_productsLayout = new javax.swing.GroupLayout(background_products);
        background_products.setLayout(background_productsLayout);
        background_productsLayout.setHorizontalGroup(
            background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_productsLayout.createSequentialGroup()
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(background_productsLayout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_productsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(background_productsLayout.createSequentialGroup()
                                .addComponent(productSearch)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Dashboard.ShowPanel(new UpProducts(lightOrDarkMode));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();

        int rows = model.getRowCount();
        if (rows == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay productos para eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            btnAdd.requestFocus();
            return;
        } else if (jTableProducts.getSelectedRows().length < 1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar uno o más productos para borrar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirmed = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar estos datos? \n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirmed == javax.swing.JOptionPane.YES_OPTION) {
            DAOProducts dao = new DAOProductsImpl();
            DAOProductSizes daoSize = new DAOProductsSizesImpl();

            int[] selectedRows = jTableProducts.getSelectedRows();
            int continueDeleting;
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                if (i == selectedRows.length - 4) {
                    continueDeleting = javax.swing.JOptionPane.showConfirmDialog(this, "¿Has eliminado 3 productos, deseas continuar eliminando el resto?\n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                    if (continueDeleting == javax.swing.JOptionPane.NO_OPTION) {
                        return;
                    }
                }
                try {
                    int selectedRow = selectedRows[i];
                    dao.delete((int) jTableProducts.getValueAt(selectedRow, 0));
                    daoSize.delete((int) jTableProducts.getValueAt(selectedRow, 0));
                    model.removeRow(selectedRow);
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Los datos se han eliminado correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (jTableProducts.getSelectedRow() > -1) {
            try {
                int productId = (int) jTableProducts.getValueAt(jTableProducts.getSelectedRow(), 0);
                DAOProducts dao = new DAOProductsImpl();
                DAOProductSizes daoSize = new DAOProductsSizesImpl();
                Dashboard.ShowPanel(new UpProducts(dao.getProductById(productId), daoSize.getProductSizesById(productId), lightOrDarkMode));
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un producto a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        if (evt.getClickCount() == 2) {
            loadProductSize(jTableProducts);
            btnDelete.setEnabled(false);
            btnCleanField.setEnabled(false);
            BrandFilterCmb.setEnabled(false);
            CategoryFilterCmb.setEnabled(false);
            productSearch.setText("");
        }
    }//GEN-LAST:event_jTableProductsMouseClicked
//    public void loadProductsDialog(JTable table) {
//        try {
//            DAOProducts dao = new DAOProductsImpl();
//            if (table.getSelectedRow() < 0) {
//                javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un producto para ver sus detalles. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }
//
//            int selectedRows = table.getSelectedRow();
//            String productName = (String) table.getValueAt(selectedRows, 1);
//
//            DefaultTableModel newModel = new DefaultTableModel();
//            table.setDefaultEditor(Object.class, null);
//            newModel.addColumn("ID del producto");
//            newModel.addColumn("Nombre del producto");
//            newModel.addColumn("Precio");
//            newModel.addColumn("Talla");
//            newModel.addColumn("Cantidad");
//
//            dao.consult(productName, "NINGUNO", "NINGUNO").forEach((p) -> newModel.addRow(new Object[]{p.getId(), p.getName(), p.getPrice(), p.getSizeSelected(), p.getAmountSelected()}));
//            table.setModel(newModel);
//        } catch (Exception e) {
//            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
//        }
//    }

    public void loadProductSize(JTable table) {
        List<ModelProductSizes> productSizeList = null;
        try {
            
            DAOProductSizes dao = new DAOProductsSizesImpl();
            if (table.getSelectedRow() < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un producto para ver sus detalles. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int selectedRows = table.getSelectedRow();
            int productId = (int) table.getValueAt(selectedRows, 0);

            DefaultTableModel newModel = new DefaultTableModel();
            table.setDefaultEditor(Object.class, null);
            newModel.addColumn("ID del producto");
            newModel.addColumn("Nombre del producto");
            newModel.addColumn("Talla");
            newModel.addColumn("Cantidad");

            productSizeList = dao.consult(productId);
            productSizeList.forEach((p) -> newModel.addRow(new Object[]{p.getIdProduct(), p.getNameProduct(), p.getNameSize(), p.getAmount()}));
            table.setModel(newModel);
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void productSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productSearchKeyReleased
        if (!btnDelete.isEnabled() || !BrandFilterCmb.isEnabled() || !CategoryFilterCmb.isEnabled() || !btnCleanField.isEnabled() && !productSearch.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No puede realizar búsqueda dentro de los detalles de un producto. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            productSearch.setText("");
            return;
        } else {
            filterConsult();
        }
    }//GEN-LAST:event_productSearchKeyReleased

    private void BrandFilterCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BrandFilterCmbItemStateChanged
        filterConsult();
    }//GEN-LAST:event_BrandFilterCmbItemStateChanged

    private void CategoryFilterCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CategoryFilterCmbItemStateChanged
        filterConsult();
    }//GEN-LAST:event_CategoryFilterCmbItemStateChanged

    private void btnCleanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldActionPerformed
        productSearch.setText("");
        BrandFilterCmb.setSelectedIndex(0);
        CategoryFilterCmb.setSelectedIndex(0);
        filterConsult();
    }//GEN-LAST:event_btnCleanFieldActionPerformed

    private void filterConsult() {
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        model.setRowCount(0);
        String productNameToSearch = productSearch.getText();
        String productBrandToSearch = BrandFilterCmb.getSelectedItem() == null ? "NINGUNO" : BrandFilterCmb.getSelectedItem().toString();
        String productCategoryToSearch = CategoryFilterCmb.getSelectedItem() == null ? "NINGUNO" : CategoryFilterCmb.getSelectedItem().toString();

        for (ModelProducts p : products) {
            if (p.getName().toLowerCase().contains(productNameToSearch)
                    && (productBrandToSearch.equals("NINGUNO") || p.getBrand().equals(productBrandToSearch))
                    && (productCategoryToSearch.equals("NINGUNO") || p.getCategory().equals(productCategoryToSearch))) {
                model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice(), p.getDescription(), p.getDiscount(), p.getBrand(), p.getCategory(), p.getType(), p.getSizeAvailable(), p.getTotalExistence(), p.getTotalPrice()});
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BrandFilterCmb;
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JComboBox<String> CategoryFilterCmb;
    private javax.swing.JLabel CategoryLbl;
    private javax.swing.JPanel background_products;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCleanField;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField productSearch;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
