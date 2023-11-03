package com.mycompany.views;

import com.mycompany.exporters.JTableToExcelExporter;
import com.mycompany.implementationDAO.DAOSalesImpl;
import com.mycompany.implementationDAO.DAOSalesProductsImpl;
import com.mycompany.heycha.Dashboard;
import com.mycompany.interfaces.DAOSales;
import com.mycompany.interfaces.DAOSalesProducts;
import com.mycompany.interfaces.ExcelExporter;
import com.mycompany.interfaces.Styleable;
import com.mycompany.models.ModelSalesProducts;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewSales extends javax.swing.JPanel implements Styleable {

    boolean lightOrDarkMode;

    public ViewSales(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        initStyles();
        loadSales();
    }

    private void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        saleSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto vendido a buscar.");
        title.putClientProperty("FlatLaf.styleClass", "h1");
        saleSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto a buscar.");
        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnSearch.putClientProperty("JButton.buttonType", "roundRect");
        btnExport.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.setEnabled(true);
        btnEdit.setEnabled(true);
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        lightOrDarkMode = isDarkModeEnabled;
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            background_sales.putClientProperty("FlatLaf.style", "background: #172030");
            btnSearch.putClientProperty("FlatLaf.style", "background: #0A677A");
            btnAdd.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnExport.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            background_sales.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            btnSearch.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnAdd.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
            btnExport.putClientProperty("FlatLaf.style", "background: #159734");
        }
    }

    private void loadSales() {
        DAOSalesImpl dao = new DAOSalesImpl();
        DefaultTableModel model = (DefaultTableModel) JTableSales.getModel();
        try (dao) {
            dao.consult().forEach((s) -> model.addRow(new Object[]{s.getId(), s.getClientId(), s.getClientName(), s.getDate(), s.getQuantitySold(), s.getTotalMoneySold()}));
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

        background_sales = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        saleSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableSales = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(764, 436));

        background_sales.setBackground(new java.awt.Color(255, 255, 255));
        background_sales.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_sales.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Ventas");

        saleSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

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

        JTableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "ID Cliente", "Nombre Cliente", "Fecha", "Cantidad Vendida", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableSales.getTableHeader().setReorderingAllowed(false);
        JTableSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableSalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableSales);

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

        btnExport.setBackground(new java.awt.Color(21, 151, 52));
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setText("Exportar");
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_salesLayout = new javax.swing.GroupLayout(background_sales);
        background_sales.setLayout(background_salesLayout);
        background_salesLayout.setHorizontalGroup(
            background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_salesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(background_salesLayout.createSequentialGroup()
                        .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_salesLayout.createSequentialGroup()
                                .addComponent(saleSearch)
                                .addGap(56, 56, 56)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_salesLayout.createSequentialGroup()
                                .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(355, 355, 355)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addGap(30, 30, 30))))
        );
        background_salesLayout.setVerticalGroup(
            background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_salesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Dashboard.ShowPanel(new UpSales(lightOrDarkMode));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableSales.getModel();

        int rows = model.getRowCount();
        if (rows == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay venta para eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            btnAdd.requestFocus();
            return;
        } else if (JTableSales.getSelectedRows().length < 1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar una o más ventas para borrar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirmed = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar estos datos? \n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirmed == javax.swing.JOptionPane.YES_OPTION) {

            int[] selectedRows = JTableSales.getSelectedRows();
            int continueDeleting;
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                if (i == selectedRows.length - 4) {
                    continueDeleting = javax.swing.JOptionPane.showConfirmDialog(this, "¿Has eliminado 3 productos, deseas continuar eliminando el resto?\n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                    if (continueDeleting == javax.swing.JOptionPane.NO_OPTION) {
                        return;
                    }
                }
                // TODO
                try {
                    DAOSales daoSale = new DAOSalesImpl();
                    DAOSalesProducts daoSalesDetails = new DAOSalesProductsImpl();

                    int selectedRow = selectedRows[i];

                    daoSale.delete((int) JTableSales.getValueAt(selectedRow, 0));
                    daoSalesDetails.deleteAll((int) JTableSales.getValueAt(selectedRow, 0));

                    model.removeRow(selectedRow);
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Los datos se han eliminado correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void JTableSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableSalesMouseClicked
        if (evt.getClickCount() == 2) {
            loadSalesProducts(JTableSales);
            btnDelete.setEnabled(false);
            btnEdit.setEnabled(false);
        }
    }//GEN-LAST:event_JTableSalesMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (JTableSales.getSelectedRow() > -1) {
            try {
                int saleId = (int) JTableSales.getValueAt(JTableSales.getSelectedRow(), 0);
                
                DAOSales daoSizes = new DAOSalesImpl();
                DAOSalesProducts daoSizesProducts = new DAOSalesProductsImpl();
                Dashboard.ShowPanel(new UpSales(daoSizes.getSaleById(saleId), daoSizesProducts.consult(saleId),lightOrDarkMode));
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar una venta a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        ExcelExporter exporter = new JTableToExcelExporter();
        try {
            exporter.exportToExcel(JTableSales);
        } catch (Exception ex) {
            Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed
    private void loadSalesProducts(JTable table) {
        List<ModelSalesProducts> salesProductsList = null;
        try {

            DAOSalesProducts dao = new DAOSalesProductsImpl();
            if (table.getSelectedRow() < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un producto para ver sus detalles. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int selectedRows = table.getSelectedRow();
            int productId = (int) table.getValueAt(selectedRows, 0);

            DefaultTableModel newModel = new DefaultTableModel();
            table.setDefaultEditor(Object.class, null);
            newModel.addColumn("ID de venta");
            newModel.addColumn("ID del producto");
            newModel.addColumn("Nombre del producto");
            newModel.addColumn("Talla");
            newModel.addColumn("Precio Unidad");
            newModel.addColumn("Cantidad");
            newModel.addColumn("Subtotal");

            salesProductsList = dao.consult(productId);
            salesProductsList.forEach((p) -> newModel.addRow(new Object[]{p.getSaleId(), p.getProductId(), p.getProductName(), p.getSizeName(), p.getPriceUnity(), p.getAmount(), p.getSubtotal()}));
            table.setModel(newModel);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableSales;
    private javax.swing.JPanel background_sales;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField saleSearch;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
