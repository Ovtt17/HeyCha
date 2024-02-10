package com.mycompany.views;

import com.mycompany.interfaces.dao.implementation.SalesDaoImpl;
import com.mycompany.interfaces.dao.implementation.SalesDetailsDaoImpl;
import com.mycompany.models.Size;
import com.mycompany.models.Sale;
import com.mycompany.models.SaleDetail;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.mycompany.interfaces.dao.SalesDao;
import com.mycompany.interfaces.dao.SalesDetailsDao;
import com.mycompany.interfaces.style.IStyleable;

public class UpSales extends javax.swing.JPanel implements IStyleable {

    SalesDao dao = new SalesDaoImpl();
    SalesDetailsDao saleDetailsDao = new SalesDetailsDaoImpl();

    boolean isEditable = false;
    boolean darkModeStatus = false;
    private Sale saleEditable;
    private List<SaleDetail> products;
    HashMap<String, Integer> clientHashMap;

    private DefaultTableModel newModel = new DefaultTableModel();
    private Float totalPayment = 0f;
    private Integer totalQuantity = 0;

    public UpSales(boolean isDarkModeEnabled) {
        initComponents();
        darkModeStatus = isDarkModeEnabled;
        updateStyles(isDarkModeEnabled);
        initStyles();
        this.products = new ArrayList<>();
    }

    public UpSales() {
    }

    public UpSales(Sale sale, List<SaleDetail> salesDetailsEditable, boolean isDarkModeEnabled) {
        initComponents();
        isEditable = true;
        updateStyles(isDarkModeEnabled);
        initStyles();
        this.saleEditable = sale;
        clientHashMap = new HashMap<>();
        clientHashMap.put(saleEditable.getClientName(), saleEditable.getClientId());
        clientsCmb.addItem(saleEditable.getClientName());
        this.products = salesDetailsEditable;
        updateTable();
    }

    public void addProduct(SaleDetail product) {
        this.products.add(product);
        updateTable();
    }

    private void updateTable() {
        try {
            newModel.setRowCount(0);
            totalPayment = 0f;
            totalQuantity = 0;
            products.stream()
                    .filter(Objects::nonNull)
                    .forEach(p -> {
                        if (isEditable) {
                            newModel.addRow(new Object[]{p.getSaleId(), p.getProductId(), p.getProductName(), p.getProductSizeId(), p.getSizeName(), p.getPriceUnity(), p.getAmount(), p.getSubtotal()});
                        } else {
                            newModel.addRow(new Object[]{p.getProductId(), p.getProductName(), p.getProductSizeId(), p.getSizeName(), p.getPriceUnity(), p.getAmount(), p.getSubtotal()});
                        }
                        totalPayment += p.getSubtotal();
                        totalQuantity += p.getAmount();
                    });
            totalValueTxt.setText("$" + totalPayment);
            jTable1.setModel(newModel);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        darkModeStatus = isDarkModeEnabled;
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            bg.putClientProperty("FlatLaf.style", "background: #172030");
            btnDataUpdate.putClientProperty("FlatLaf.style", "background: #0c9294");
            BtnAddProduct.putClientProperty("FlatLaf.style", "background: #0c9294");
            BtnDeleteProduct.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            bg.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            btnDataUpdate.putClientProperty("FlatLaf.style", "background: #125AAD");
            BtnAddProduct.putClientProperty("FlatLaf.style", "background: #125AAD");
            BtnDeleteProduct.putClientProperty("FlatLaf.style", "background: #125AAD");
        }
        BtnAddProduct.putClientProperty("JButton.buttonType", "roundRect");
        btnDataUpdate.putClientProperty("JButton.buttonType", "roundRect");
        BtnDeleteProduct.putClientProperty("JButton.buttonType", "roundRect");
    }

    @Override
    public void initStyles() {
        jTable1.getTableHeader().setBackground(new Color(0, 0, 0));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        title.putClientProperty("FlatLaf.styleClass", "h1");
        jTable1.setDefaultEditor(Object.class, null);
        if (isEditable) {
            title.setText("Editar venta");
            btnDataUpdate.setText("Editar");
            newModel.addColumn("Id de venta");
        } else {
            try {
                dao.loadClientsCmb(clientsCmb);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        newModel.addColumn("ID del producto");
        newModel.addColumn("Nombre del producto");
        newModel.addColumn("ID Unico");
        newModel.addColumn("Talla");
        newModel.addColumn("Precio Unitario");
        newModel.addColumn("Cantidad");
        newModel.addColumn("Precio Total");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnDataUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnAddProduct = new javax.swing.JButton();
        BtnDeleteProduct = new javax.swing.JButton();
        TotalLbl = new javax.swing.JLabel();
        totalValueTxt = new javax.swing.JTextField();
        clientLbl = new javax.swing.JLabel();
        clientsCmb = new javax.swing.JComboBox<>();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Subir Nueva Venta.");

        btnDataUpdate.setBackground(new java.awt.Color(18, 90, 173));
        btnDataUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDataUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnDataUpdate.setText("Subir");
        btnDataUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDataUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataUpdateActionPerformed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnAddProduct.setBackground(new java.awt.Color(18, 90, 173));
        BtnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddProduct.setText("Agregar");
        BtnAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddProductActionPerformed(evt);
            }
        });

        BtnDeleteProduct.setBackground(new java.awt.Color(18, 90, 173));
        BtnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        BtnDeleteProduct.setText("Eliminar");
        BtnDeleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteProductActionPerformed(evt);
            }
        });

        TotalLbl.setText("Total:");

        totalValueTxt.setEditable(false);
        totalValueTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        clientLbl.setText("Cliente:");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(title))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnDataUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(201, 201, 201))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(442, 533, Short.MAX_VALUE)
                        .addComponent(TotalLbl)
                        .addGap(37, 37, 37)
                        .addComponent(totalValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(clientLbl)
                                .addGap(18, 18, 18)
                                .addComponent(clientsCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69)
                                .addComponent(BtnAddProduct)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDeleteProduct))
                            .addComponent(jScrollPane1))))
                .addGap(100, 100, 100))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clientsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnDataUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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

    private void btnDataUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataUpdateActionPerformed
        Integer clientId;
        if (isEditable) {
            clientId = clientHashMap.get(clientsCmb.getSelectedItem().toString());
        } else {
            clientId = clientsCmb.getSelectedIndex();
        }

        LocalDate date = LocalDate.now();
        Integer totalQuantitySold = totalQuantity;
        Float total = totalPayment;

        boolean incorrectData = total <= 0 || total == null;
        if (incorrectData) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese los datos correctamente\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            Sale sale = isEditable ? saleEditable : new Sale();
            sale.setClientId(clientId);
            sale.setQuantitySold(totalQuantitySold);
            sale.setTotalMoneyEarned(total);
            sale.setDate(date);

            Integer idSale = isEditable ? dao.modify(sale) : dao.record(sale);

            products.stream()
                    .filter(Objects::nonNull)
                    .forEach((p) -> {
                        try {
                            p.setSaleId(idSale);

                            if (isEditable) {
                                saleDetailsDao.modify(p);
                            } else {
                                saleDetailsDao.record(p);
                            }

                        } catch (Exception e) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                    });
            javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            emptyFields();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDataUpdateActionPerformed
    private void emptyFields() {
        clientsCmb.setSelectedIndex(0);
        newModel.setRowCount(0);
        totalValueTxt.setText("");
        totalPayment = 0f;
        totalQuantity = 0;
        products.clear();
    }

    private void BtnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddProductActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        TableSale t = new TableSale(parentFrame, true, this, darkModeStatus);
        t.setVisible(true);
    }//GEN-LAST:event_BtnAddProductActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    private void BtnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteProductActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int rows = model.getRowCount();
        if (rows == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay venta para eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (jTable1.getSelectedRows().length < 1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar una o más ventas para borrar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirmed = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar estos datos? \n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirmed == javax.swing.JOptionPane.YES_OPTION) {

            int[] selectedRows = jTable1.getSelectedRows();
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
                    int selectedRow = selectedRows[i];
                    SalesDetailsDao daoSalesDetails = new SalesDetailsDaoImpl();
                    int idIndex = 0, nameIndex = 0, sizeIndex = 0, priceIndex = 0, amountIndex = 0;
                    if (isEditable) {
                        Integer saleId = (Integer) jTable1.getValueAt(selectedRow, 0);
                        Integer productSizeId = (int) jTable1.getValueAt(selectedRow, 3);
                        daoSalesDetails.delete(saleId, productSizeId);
                        idIndex = 1;
                        nameIndex = 2;
                        sizeIndex = 4;
                        priceIndex = 5;
                        amountIndex = 6;
                    } else {
                        idIndex = 0;
                        nameIndex = 1;
                        sizeIndex = 3;
                        priceIndex = 4;
                        amountIndex = 5;
                    }

                    Integer productId = (Integer) jTable1.getValueAt(selectedRow, idIndex);
                    String productName = (String) jTable1.getValueAt(selectedRow, nameIndex);
                    String sizeName = (String) jTable1.getValueAt(selectedRow, sizeIndex);
                    Float price = (Float) jTable1.getValueAt(selectedRow, priceIndex);
                    Integer amount = (Integer) jTable1.getValueAt(selectedRow, amountIndex);
                    products.removeIf(p
                            -> Objects.equals(p.getProductId(), productId) // posible fail
                            && p.getProductName().equals(productName)
                            && p.getSizeName().equals(sizeName)
                            && p.getPriceUnity().equals(price)
                            && p.getAmount() == amount
                    );

                    model.removeRow(selectedRow);
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Los datos se han eliminado correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnDeleteProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddProduct;
    private javax.swing.JButton BtnDeleteProduct;
    private javax.swing.JLabel TotalLbl;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnDataUpdate;
    private javax.swing.JLabel clientLbl;
    private javax.swing.JComboBox<String> clientsCmb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField totalValueTxt;
    // End of variables declaration//GEN-END:variables

}
