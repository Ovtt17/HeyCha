package com.mycompany.views;

import com.mycompany.interfaces.exporters.implementation.ExcelExporterImpl;
import com.mycompany.interfaces.dao.implementation.ProductsDaoImpl;
import com.mycompany.interfaces.dao.implementation.ProductSizeDaoImpl;
import com.mycompany.heycha.Dashboard;
import com.mycompany.interfaces.dao.CategoryDao;
import com.mycompany.models.Product;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.mycompany.interfaces.dao.ProductsDao;
import com.mycompany.interfaces.exporters.IExcelExporter;
import com.mycompany.interfaces.style.IStyleable;
import com.mycompany.interfaces.dao.ProductSizeDao;
import com.mycompany.models.Brand;
import com.mycompany.models.Category;
import com.mycompany.models.ProductSize;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class ViewProducts extends javax.swing.JPanel implements IStyleable {

    boolean lightOrDarkMode;
    ProductsDao productDao = new ProductsDaoImpl();
    ProductSizeDao productSizeDao = new ProductSizeDaoImpl();

    public ViewProducts(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        initStyles();
        loadProducts();
    }

    public ViewProducts() {

    }

    @Override
    public void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        ProductDetailsTxt.putClientProperty("FlatLaf.styleClass", "h1");
        productSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto a buscar.");
        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnExport.putClientProperty("JButton.buttonType", "roundRect");
        btnCleanField.putClientProperty("JButton.buttonType", "roundRect");

        jTableProducts.getTableHeader().setBackground(new Color(0, 0, 0));
        TableDetails.getTableHeader().setBackground(new Color(0, 0, 0));
        jTableProducts.getTableHeader().setForeground(new Color(255, 255, 255));
        TableDetails.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        lightOrDarkMode = isDarkModeEnabled;
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            ProductDetailsTxt.setForeground(Color.white);
            background_products.putClientProperty("FlatLaf.style", "background: #172030");
            btnAdd.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnCleanField.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnExport.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            ProductDetailsTxt.setForeground(Color.black);
            background_products.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            btnAdd.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
            btnCleanField.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnExport.putClientProperty("FlatLaf.style", "background: #159734");
        }

        try {
            ItemListener[] ilBrand = BrandFilterCmb.getListeners(ItemListener.class);
            ItemListener[] ilCategories = CategoryFilterCmb.getListeners(ItemListener.class);

            removeEventListener(BrandFilterCmb, ilBrand);
            removeEventListener(CategoryFilterCmb, ilCategories);

            productDao.loadComboboxByBrand(BrandFilterCmb);
            productDao.loadComboboxByCategory(CategoryFilterCmb);

            addEventListener(BrandFilterCmb, ilBrand);
            addEventListener(CategoryFilterCmb, ilCategories);

        } catch (Exception ex) {
            Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnCleanField.setEnabled(true);
        BrandFilterCmb.setEnabled(true);
        CategoryFilterCmb.setEnabled(true);
    }

    private <T> void removeEventListener(JComboBox<T> combobox, ItemListener[] itemListeners) {
        for (ItemListener itemListener : itemListeners) {
            combobox.removeItemListener(itemListener);
        }
    }

    private <T> void addEventListener(JComboBox<T> combobox, ItemListener[] itemListeners) {
        for (ItemListener itemListener : itemListeners) {
            combobox.addItemListener(itemListener);
        }
    }

    private void loadProducts() {
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        try {
            model.setRowCount(0);
            productDao.consultAllProducts()
                    .forEach((p)
                            -> model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice(), p.getBrand().getName(), p.getCategory().getName(), p.getType().getName(), p.getSizeAvailable(), p.getTotalExistence(), p.getTotalPrice()}));

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
        btnExport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDetails = new javax.swing.JTable();
        ProductDetailsTxt = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(764, 540));

        background_products.setBackground(new java.awt.Color(255, 255, 255));
        background_products.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_products.setMinimumSize(new java.awt.Dimension(0, 0));
        background_products.setPreferredSize(new java.awt.Dimension(764, 540));

        title.setText("Productos");

        productSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productSearchKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Marca", "Categoria", "Tipo", "Tallas Disponibles", "Total Existencia", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setGridColor(new java.awt.Color(153, 153, 153));
        jTableProducts.setRowHeight(30);
        jTableProducts.setShowGrid(true);
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

        BrandFilterCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BrandFilterCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BrandFilterCmbItemStateChanged(evt);
            }
        });

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

        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconExcel.png"))); // NOI18N
        btnExport.setContentAreaFilled(false);
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TableDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID del Producto", "Nombre del Producto", "Talla", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDetails.setGridColor(new java.awt.Color(153, 153, 153));
        TableDetails.setRowHeight(30);
        TableDetails.setShowGrid(true);
        TableDetails.getTableHeader().setReorderingAllowed(false);
        TableDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableDetails);

        ProductDetailsTxt.setText("Detalles de Producto");

        javax.swing.GroupLayout background_productsLayout = new javax.swing.GroupLayout(background_products);
        background_products.setLayout(background_productsLayout);
        background_productsLayout.setHorizontalGroup(
            background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_productsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ProductDetailsTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_productsLayout.createSequentialGroup()
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_productsLayout.createSequentialGroup()
                        .addComponent(productSearch)
                        .addGap(18, 18, 18)
                        .addComponent(BrandLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BrandFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CategoryLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CategoryFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnCleanField))
                    .addComponent(title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ProductDetailsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(background_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Dashboard.ShowPanel(new UpProducts(lightOrDarkMode));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        DefaultTableModel modelDetails = (DefaultTableModel) TableDetails.getModel();
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
                    productDao.delete((int) jTableProducts.getValueAt(selectedRow, 0));
                    productSizeDao.deleteAllSizes((int) jTableProducts.getValueAt(selectedRow, 0));
                    model.removeRow(selectedRow);
                    modelDetails.setRowCount(0);
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

                Product product = productDao.getProductById(productId);
                Dashboard.ShowPanel(new UpProducts(product, product.getProductSizeList(), lightOrDarkMode));
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un producto a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        loadProductSize();
        productSearch.setText("");
    }//GEN-LAST:event_jTableProductsMouseClicked

    public void loadProductSize() {
        List<ProductSize> productSizeList = null;
        try {
            int selectedRows = jTableProducts.getSelectedRow();
            int productId = (int) jTableProducts.getValueAt(selectedRows, 0);

            DefaultTableModel model = (DefaultTableModel) TableDetails.getModel();
            model.setRowCount(0);

            productSizeList = productSizeDao.consult(productId);
            productSizeList.forEach((p) -> model.addRow(new Object[]{p.getId(), p.getProductId(), p.getProductName(), p.getSizeName(), p.getPrice(), p.getAmount()}));
            TableDetails.setModel(model);

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

        ItemListener[] ilBrand = BrandFilterCmb.getListeners(ItemListener.class);
        ItemListener[] ilCategories = CategoryFilterCmb.getListeners(ItemListener.class);

        removeEventListener(BrandFilterCmb, ilBrand);
        removeEventListener(CategoryFilterCmb, ilCategories);

        BrandFilterCmb.setSelectedIndex(-1);
        CategoryFilterCmb.setSelectedIndex(-1);

        addEventListener(BrandFilterCmb, ilBrand);
        addEventListener(CategoryFilterCmb, ilCategories);
        loadProducts();

    }//GEN-LAST:event_btnCleanFieldActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        IExcelExporter exporter = new ExcelExporterImpl();
        try {
            exporter.export(jTableProducts);
        } catch (Exception ex) {
            Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void TableDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableDetailsMouseClicked

    private void filterConsult() {
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        Product product = new Product();
        model.setRowCount(0);
        product.setName(productSearch.getText().isEmpty() ? "" : productSearch.getText());

        Brand brand = BrandFilterCmb.getSelectedIndex() != -1 ? (Brand) BrandFilterCmb.getSelectedItem() : new Brand("");
        Category category = CategoryFilterCmb.getSelectedIndex() != -1 ? (Category) CategoryFilterCmb.getSelectedItem() : new Category("");

        product.setBrand(brand);
        product.setCategory(category);

        try {
            productDao.consultFiltered(product)
                    .forEach((p)
                            -> model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice(), p.getBrand().getName(), p.getCategory().getName(), p.getType().getName(), p.getSizeAvailable(), p.getTotalExistence(), p.getTotalPrice()}));
        } catch (Exception ex) {
            Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Brand> BrandFilterCmb;
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JComboBox<Category> CategoryFilterCmb;
    private javax.swing.JLabel CategoryLbl;
    private javax.swing.JLabel ProductDetailsTxt;
    private javax.swing.JTable TableDetails;
    private javax.swing.JPanel background_products;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCleanField;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField productSearch;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
