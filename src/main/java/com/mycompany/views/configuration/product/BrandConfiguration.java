package com.mycompany.views.configuration.product;

import com.mycompany.interfaces.dao.BrandDao;
import com.mycompany.interfaces.dao.implementation.BrandDaoImpl;
import com.mycompany.interfaces.style.IStyleable;
import com.mycompany.models.Brand;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class BrandConfiguration extends javax.swing.JPanel implements IStyleable {

    BrandDao brandDao = new BrandDaoImpl();
    boolean isEditable = false;
    Brand brandEditable;

    BrandConfiguration(boolean lightOrDarkMode) {
        initComponents();
        updateStyles(lightOrDarkMode);
        initStyles();
        loadBrand();
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        if (isDarkModeEnabled) {
            bg.putClientProperty("FlatLaf.style", "background: #172030");
            content.putClientProperty("FlatLaf.style", "background: #172030");
            newBrandLbl.setForeground(Color.white);

            DataUpdateBtn.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnClean.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            bg.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            content.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            newBrandLbl.setForeground(Color.black);

            DataUpdateBtn.putClientProperty("FlatLaf.style", "background: #125AAD");
            btnClean.putClientProperty("FlatLaf.style", "background: #125AAD");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
        }
    }

    @Override
    public void initStyles() {
        newBrandLbl.putClientProperty("FlatLaf.styleClass", "h2");
        newbrandTxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre de la nueva marca.");

        btnClean.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        TableBrand.getTableHeader().setBackground(new Color(0, 0, 0));
        TableBrand.getTableHeader().setForeground(new Color(255, 255, 255));
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
        content = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBrand = new javax.swing.JTable();
        newBrandLbl = new javax.swing.JLabel();
        newbrandTxt = new javax.swing.JTextField();
        DataUpdateBtn = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(755, 441));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        content.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TableBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TableBrand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableBrand.setToolTipText("");
        TableBrand.setColumnSelectionAllowed(true);
        TableBrand.setGridColor(new java.awt.Color(153, 153, 153));
        TableBrand.setRowHeight(30);
        TableBrand.setShowGrid(true);
        TableBrand.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableBrand);
        TableBrand.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TableBrand.getColumnModel().getColumnCount() > 0) {
            TableBrand.getColumnModel().getColumn(0).setMinWidth(50);
            TableBrand.getColumnModel().getColumn(0).setPreferredWidth(60);
            TableBrand.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        newBrandLbl.setText("Nueva Marca:");

        newbrandTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        DataUpdateBtn.setBackground(new java.awt.Color(18, 90, 173));
        DataUpdateBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DataUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        DataUpdateBtn.setText("Subir");
        DataUpdateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataUpdateBtnActionPerformed(evt);
            }
        });

        btnClean.setBackground(new java.awt.Color(18, 90, 173));
        btnClean.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClean.setForeground(new java.awt.Color(255, 255, 255));
        btnClean.setText("Limpiar");
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 183, 44));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Borrar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(newBrandLbl)
                        .addGap(18, 18, 18)
                        .addComponent(newbrandTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClean)
                        .addGap(85, 85, 85)))
                .addContainerGap())
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(DataUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(121, 121, 121))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newbrandTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newBrandLbl)))
                .addGap(54, 54, 54)
                .addComponent(DataUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(111, 111, 111))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
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

    private void loadBrand() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) TableBrand.getModel();
            tableModel.setRowCount(0);
            List<Brand> brandList = brandDao.consult();
            brandList.stream().forEach(b -> tableModel.addRow(new Object[]{b.getId(), b.getName()}));
        } catch (Exception ex) {
            Logger.getLogger(BrandConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void DataUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataUpdateBtnActionPerformed
        upData();
    }//GEN-LAST:event_DataUpdateBtnActionPerformed
    private void upData() {
        try {
            String name = newbrandTxt.getText().trim();
            if (name.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Introduzca el nombre de la nueva marca. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                newbrandTxt.requestFocus();
                return;
            }

            Brand brand = isEditable ? brandEditable : new Brand();
            brand.setName(name);
            if (isEditable) {
                brandDao.modify(brand);
            } else {
                brandDao.record(brand);
            }

            String succecssMsg = isEditable ? "modificado" : "registrado";
            javax.swing.JOptionPane.showMessageDialog(this, "Datos " + succecssMsg + " correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (!isEditable) {
                cleanFields();
            }
            loadBrand();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cleanFields() {
        isEditable = false;
        newbrandTxt.setText("");
        newBrandLbl.setText("Nueva Marca:");
    }


    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanFields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        setEditableFields();
    }//GEN-LAST:event_btnEditActionPerformed
    private void setEditableFields() {
        DefaultTableModel tableModel = (DefaultTableModel) TableBrand.getModel();

        if (TableBrand.getSelectedRow() == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar una marca a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            isEditable = true;
            newBrandLbl.setText("Editar Marca:");
            Integer id = (Integer) tableModel.getValueAt(TableBrand.getSelectedRow(), 0);
            String name = (String) tableModel.getValueAt(TableBrand.getSelectedRow(), 1);
            brandEditable = new Brand(id, name);
            newbrandTxt.setText(name);
        }

    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteBrand();
        loadBrand();
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void deleteBrand() {
        DefaultTableModel tableModel = (DefaultTableModel) TableBrand.getModel();
        if (TableBrand.getSelectedRow() == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar una marca a eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirmed = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar estos datos? \n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirmed == javax.swing.JOptionPane.YES_OPTION) {
            Integer id = (Integer) tableModel.getValueAt(TableBrand.getSelectedRow(), 0);
            String name = (String) tableModel.getValueAt(TableBrand.getSelectedRow(), 1);
            try {
                brandDao.delete(new Brand(id, name));
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DataUpdateBtn;
    private javax.swing.JTable TableBrand;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JPanel content;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel newBrandLbl;
    private javax.swing.JTextField newbrandTxt;
    // End of variables declaration//GEN-END:variables

}
