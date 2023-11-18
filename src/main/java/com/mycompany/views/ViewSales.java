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
import javax.swing.table.DefaultTableModel;

public class ViewSales extends javax.swing.JPanel implements Styleable {

    boolean lightOrDarkMode;
    Integer count;
    Float totalMoney;

    public ViewSales(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        initStyles();
        loadSales();
    }

    private void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        SaleDetailsTxt.putClientProperty("FlatLaf.styleClass", "h1");

        title.putClientProperty("FlatLaf.styleClass", "h1");

        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");

        btnExport.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.setEnabled(true);
        btnEdit.setEnabled(true);
        JTableSales.getTableHeader().setBackground(new Color(0, 0, 0));
        TableSaleDetails.getTableHeader().setBackground(new Color(0, 0, 0));
        JTableSales.getTableHeader().setForeground(new Color(255, 255, 255));
        TableSaleDetails.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        lightOrDarkMode = isDarkModeEnabled;
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            SaleDetailsTxt.setForeground(Color.white);
            background_sales.putClientProperty("FlatLaf.style", "background: #172030");
            btnAdd.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnExport.putClientProperty("FlatLaf.style", "background: #0c9294");

        } else {
            title.setForeground(Color.black);
            SaleDetailsTxt.setForeground(Color.black);
            background_sales.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            btnAdd.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
            btnExport.putClientProperty("FlatLaf.style", "background: #159734");
        }
    }

    private void loadSales() {
        try {
            DAOSales dao = new DAOSalesImpl();
            DefaultTableModel model = (DefaultTableModel) JTableSales.getModel();
            model.setRowCount(0);
            DefaultTableModel modelDetail = (DefaultTableModel) TableSaleDetails.getModel();
            modelDetail.setRowCount(0);
            java.util.Date utilDate = (java.util.Date) DateSpinner.getValue();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            count = 0; totalMoney = 0f;
            dao.consult(sqlDate).forEach(
                    (s) -> {
                        model.addRow(new Object[]{s.getId(), s.getClientId(), s.getClientName(), s.getDate(), s.getQuantitySold(), s.getTotalMoneySold()});
                        count++;
                        totalMoney += s.getTotalMoneySold();

                    });
            TotalSalesTxt.setText(count.toString());
            TotalSalesTxt.setEditable(false);
            TotalEarnedTxt.setText(totalMoney.toString());
            TotalEarnedTxt.setEditable(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableSales = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableSaleDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TotalSalesTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TotalEarnedTxt = new javax.swing.JTextField();
        DateSpinner = new javax.swing.JSpinner();
        SaleDetailsTxt = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(764, 540));

        background_sales.setBackground(new java.awt.Color(255, 255, 255));
        background_sales.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_sales.setPreferredSize(new java.awt.Dimension(764, 540));

        title.setText("Ventas");

        jScrollPane1.setBorder(null);

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
        JTableSales.setGridColor(new java.awt.Color(153, 153, 153));
        JTableSales.setRowHeight(30);
        JTableSales.setShowGrid(true);
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
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconExcel.png"))); // NOI18N
        btnExport.setContentAreaFilled(false);
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        TableSaleDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre del Producto", "Talla", "Precio Unidad", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableSaleDetails.setGridColor(new java.awt.Color(153, 153, 153));
        TableSaleDetails.setRowHeight(30);
        TableSaleDetails.setShowGrid(true);
        TableSaleDetails.getTableHeader().setReorderingAllowed(false);
        TableSaleDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSaleDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableSaleDetails);

        jLabel1.setText("Ventas Realizadas:");

        jLabel2.setText("Total Ganado:");

        DateSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        DateSpinner.setEditor(new javax.swing.JSpinner.DateEditor(DateSpinner, "MM/yyyy"));
        DateSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DateSpinnerStateChanged(evt);
            }
        });

        SaleDetailsTxt.setText("Detalles de Venta");

        javax.swing.GroupLayout background_salesLayout = new javax.swing.GroupLayout(background_sales);
        background_sales.setLayout(background_salesLayout);
        background_salesLayout.setHorizontalGroup(
            background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_salesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_salesLayout.createSequentialGroup()
                        .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SaleDetailsTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_salesLayout.createSequentialGroup()
                                .addComponent(DateSpinner)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalSalesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalEarnedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))
                            .addGroup(background_salesLayout.createSequentialGroup()
                                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(343, 343, 343)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addGap(33, 33, 33)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30))))
        );
        background_salesLayout.setVerticalGroup(
            background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_salesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TotalSalesTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalEarnedTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(DateSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaleDetailsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(background_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
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
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Dashboard.ShowPanel(new UpSales(lightOrDarkMode));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableSales.getModel();
        DefaultTableModel modelDetails = (DefaultTableModel) TableSaleDetails.getModel();

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
                    modelDetails.setRowCount(0);
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Los datos se han eliminado correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void JTableSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableSalesMouseClicked
        loadSalesProducts();
    }//GEN-LAST:event_JTableSalesMouseClicked
    private void loadSalesProducts() {
        List<ModelSalesProducts> salesProductsList;
        try {
            DAOSalesProducts dao = new DAOSalesProductsImpl();
            int selectedRows = JTableSales.getSelectedRow();
            int productId = (int) JTableSales.getValueAt(selectedRows, 0);

            DefaultTableModel newModel = (DefaultTableModel) TableSaleDetails.getModel();
            newModel.setRowCount(0);
            salesProductsList = dao.consult(productId);
            salesProductsList.forEach((p) -> newModel.addRow(new Object[]{p.getProductId(), p.getProductName(), p.getSizeName(), p.getPriceUnity(), p.getAmount(), p.getSubtotal()}));
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (JTableSales.getSelectedRow() > -1) {
            try {
                int saleId = (int) JTableSales.getValueAt(JTableSales.getSelectedRow(), 0);

                DAOSales daoSizes = new DAOSalesImpl();
                DAOSalesProducts daoSizesProducts = new DAOSalesProductsImpl();
                Dashboard.ShowPanel(new UpSales(daoSizes.getSaleById(saleId), daoSizesProducts.consult(saleId), lightOrDarkMode));
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

    private void TableSaleDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSaleDetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableSaleDetailsMouseClicked

    private void DateSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DateSpinnerStateChanged
        loadSales();
    }//GEN-LAST:event_DateSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner DateSpinner;
    private javax.swing.JTable JTableSales;
    private javax.swing.JLabel SaleDetailsTxt;
    private javax.swing.JTable TableSaleDetails;
    private javax.swing.JTextField TotalEarnedTxt;
    private javax.swing.JTextField TotalSalesTxt;
    private javax.swing.JPanel background_sales;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
