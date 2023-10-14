package com.mycompany.views;

import ImplementationDAO.DAOSalesImpl;
import ImplementationDAO.DAOSalesProductsImpl;
import com.mycompany.interfaces.DAOSales;
import com.mycompany.interfaces.DAOSalesProducts;
import com.mycompany.interfaces.Styleable;
import com.mycompany.models.ModelProductSizes;
import com.mycompany.models.ModelSales;
import com.mycompany.models.ModelSalesProducts;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class UpSales extends javax.swing.JPanel implements Styleable {

    private List<ModelProductSizes> products;
    private DefaultTableModel newModel = new DefaultTableModel();
    private Float totalPayment = 0f;
    private Integer totalQuantity = 0;

    public UpSales(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        initStyles();
        this.products = new ArrayList<>();
    }

    public UpSales() {
    }

    public void addProduct(ModelProductSizes product) {
        this.products.add(product);
        updateTable();
    }

//    public void updateProductQuantityInTable(Integer productId, JTable table) {
//        DefaultTableModel model = new DefaultTableModel();
//        table.setDefaultEditor(Object.class, null);
//        newModel.addColumn("ID del producto");
//        newModel.addColumn("Nombre del producto");
//        newModel.addColumn("Talla");
//        newModel.addColumn("Cantidad");
//        String size = productIndexes.get(productId);
//        System.out.println(size);
//        if (size != null) {
//            // Aquí buscas la fila del producto en la tabla
//            for (int i = 0; i < model.getRowCount(); i++) {
//                System.out.println("iterando");
//                if (model.getValueAt(i, 0).equals(productId) && model.getValueAt(i, 2).equals(size)) {
//                    // Aquí obtienes la cantidad actual del producto en la tabla
//                    int currentQuantity = Integer.parseInt(model.getValueAt(i, 3).toString());
//
//                    // Aquí obtienes el cambio de cantidad del producto en tu lista de productos seleccionados
//                    int quantityChange = products.stream()
//                            .filter(p -> Objects.equals(p.getIdProduct(), productId) && p.getNameSize().equals(size))
//                            .mapToInt(ModelProductSizes::getAmount)
//                            .sum();
//
//                    System.out.println(quantityChange);
//                    // Aquí calculas la nueva cantidad
//                    int newQuantity = currentQuantity - (int) quantityChange;
//                    System.out.println(newQuantity);
//                    // Y aquí actualizas la cantidad en la tabla
//                    model.setValueAt(newQuantity, i, 3);
//                    table.setModel(model);
//                    break;
//                }
//            }
//        }
//        
//    }
    private void updateTable() {
        try {
            newModel.setRowCount(0);
            totalPayment = 0f;
            products.stream()
                    .filter(Objects::nonNull)
                    .forEach(p -> {
                        newModel.addRow(new Object[]{p.getIdProduct(), p.getNameProduct(), p.getNameSize(), p.getAmount(), p.getPrice(), p.getTotalPrice()});
                        totalPayment += p.getTotalPrice();
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
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            bg.putClientProperty("FlatLaf.style", "background: #172030");
            btnDataUpdate.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            bg.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            btnDataUpdate.putClientProperty("FlatLaf.style", "background: #125AAD");
        }
    }

    private void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        jTable1.setDefaultEditor(Object.class, null);
        newModel.addColumn("ID del producto");
        newModel.addColumn("Nombre del producto");
        newModel.addColumn("Talla");
        newModel.addColumn("Cantidad");
        newModel.addColumn("Precio Unitario");
        newModel.addColumn("Precio Total");
        
        AutoCompleteDecorator.decorate(clientsCmb);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar-producto.png"))); // NOI18N
        BtnAddProduct.setText("Agregar");
        BtnAddProduct.setContentAreaFilled(false);
        BtnAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddProductActionPerformed(evt);
            }
        });

        BtnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        BtnDeleteProduct.setText("Eliminar");
        BtnDeleteProduct.setContentAreaFilled(false);
        BtnDeleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TotalLbl.setText("Total:");

        totalValueTxt.setEditable(false);

        clientLbl.setText("Cliente:");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(646, 646, 646))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(btnDataUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(185, 185, 185))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TotalLbl)
                        .addGap(37, 37, 37)
                        .addComponent(totalValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(clientLbl)
                                .addGap(18, 18, 18)
                                .addComponent(clientsCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(130, 130, 130)
                                .addComponent(BtnAddProduct)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(1, 1, 1)))))
                .addGap(46, 46, 46))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnDataUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataUpdateActionPerformed
        Integer clientId = null;
        LocalDate date = LocalDate.now();
        Integer totalQuantitySold = totalQuantity;
        Float total = totalPayment;

        boolean incorrectData = total <= 0 || total == null;
        if (incorrectData) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese los datos correctamente\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            ModelSales sale = new ModelSales(clientId, totalQuantitySold, total, date);
            DAOSales dao = new DAOSalesImpl();

            Integer idSale = dao.record(sale);
            products.stream()
                    .filter(Objects::nonNull)
                    .forEach((p) -> {
                        ModelSalesProducts salesProducts = new ModelSalesProducts(idSale, p.getIdProduct(), p.getPrice(), p.getAmount(), p.getTotalPrice());
                        try {
                            DAOSalesProducts daoSalesProducts = new DAOSalesProductsImpl();
                            daoSalesProducts.record(salesProducts);
                        } catch (Exception e) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                    });
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDataUpdateActionPerformed


    private void BtnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddProductActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        TableSale t = new TableSale(parentFrame, true, this);
        t.setVisible(true);
    }//GEN-LAST:event_BtnAddProductActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange


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
