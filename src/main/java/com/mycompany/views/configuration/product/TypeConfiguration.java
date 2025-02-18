package com.mycompany.views.configuration.product;

import com.mycompany.interfaces.dao.CategoryDao;
import com.mycompany.interfaces.dao.TypeDao;
import com.mycompany.interfaces.dao.implementation.CategoryDaoImpl;
import com.mycompany.interfaces.dao.implementation.TypeDaoImpl;
import com.mycompany.interfaces.style.IStyleable;
import com.mycompany.models.Category;
import com.mycompany.models.Type;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class TypeConfiguration extends javax.swing.JPanel implements IStyleable {

    TypeDao typeDao = new TypeDaoImpl();
    CategoryDao categoryDao = new CategoryDaoImpl();
    Type typeEditable;
    boolean isEditable = false;

    TypeConfiguration(boolean lightOrDarkMode) {
        initComponents();
        updateStyles(lightOrDarkMode);
        initStyles();
        loadCombobox();
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        if (isDarkModeEnabled) {
            bg.putClientProperty("FlatLaf.style", "background: #172030");
            content.putClientProperty("FlatLaf.style", "background: #172030");
            newTypeLbl.setForeground(Color.white);
            categoryLbl.setForeground(Color.white);

            DataUpdateBtn.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnClean.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            bg.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            content.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            newTypeLbl.setForeground(Color.black);
            categoryLbl.setForeground(Color.black);

            DataUpdateBtn.putClientProperty("FlatLaf.style", "background: #125AAD");
            btnClean.putClientProperty("FlatLaf.style", "background: #125AAD");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
        }
    }

    @Override
    public void initStyles() {
        newTypeLbl.putClientProperty("FlatLaf.styleClass", "h2");
        newTypeTxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del nuevo tipo.");

        btnClean.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        TableType.getTableHeader().setBackground(new Color(0, 0, 0));
        TableType.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    private void loadCombobox() {
        try {
            List<Category> categoryList = categoryDao.consult();
            ItemListener[] itemListeners = cmbCategory.getListeners(ItemListener.class);

            removeEventListener(cmbCategory, itemListeners);
            categoryList.forEach(c -> cmbCategory.addItem(c));
            addEventListener(cmbCategory, itemListeners);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeEventListener(JComboBox<Category> combobox, ItemListener[] itemListeners) {
        for (ItemListener itemListener : itemListeners) {
            combobox.removeItemListener(itemListener);
        }
    }

    private void addEventListener(JComboBox<Category> combobox, ItemListener[] itemListeners) {
        combobox.setSelectedIndex(-1);
        for (ItemListener itemListener : itemListeners) {
            combobox.addItemListener(itemListener);
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

        bg = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableType = new javax.swing.JTable();
        newTypeLbl = new javax.swing.JLabel();
        newTypeTxt = new javax.swing.JTextField();
        DataUpdateBtn = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        categoryLbl = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();

        bg.setBackground(new java.awt.Color(255, 255, 255));

        content.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TableType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TableType.setModel(new javax.swing.table.DefaultTableModel(
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
        TableType.setToolTipText("");
        TableType.setColumnSelectionAllowed(true);
        TableType.setGridColor(new java.awt.Color(153, 153, 153));
        TableType.setRowHeight(30);
        TableType.setShowGrid(true);
        TableType.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableType);
        TableType.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        newTypeLbl.setText("Nuevo Tipo:");

        newTypeTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

        categoryLbl.setText("Categoria Correspondiente:");

        cmbCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoryItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(DataUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(newTypeLbl)
                                .addGap(18, 18, 18)
                                .addComponent(newTypeTxt)
                                .addGap(18, 18, 18)
                                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(categoryLbl)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete))
                .addGap(26, 26, 26))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(categoryLbl))
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newTypeLbl))
                    .addComponent(btnClean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DataUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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

    private void DataUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataUpdateBtnActionPerformed
        upData();
    }//GEN-LAST:event_DataUpdateBtnActionPerformed
    private void upData() {
        try {
            String name = newTypeTxt.getText().trim();
            if (name.isEmpty() || name.isBlank()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Introduzca el nombre de la nueva marca. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                newTypeTxt.requestFocus();
                return;
            }

            Type type = isEditable ? typeEditable : new Type();
            Category category = (Category) cmbCategory.getSelectedItem();
            type.setName(name);
            type.setCategoryId(category.getId());

            if (isEditable) {
                typeDao.modify(type);
            } else {
                typeDao.record(type);
            }

            String succecssMsg = isEditable ? "modificado" : "registrado";
            javax.swing.JOptionPane.showMessageDialog(this, "Datos " + succecssMsg + " correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (!isEditable) {
                cleanFields();
            }
            loadTypeByCategorySelected();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        cleanFields();
    }//GEN-LAST:event_btnCleanActionPerformed
    private void cleanFields() {
        isEditable = false;
        newTypeTxt.setText("");
        DataUpdateBtn.setText("Subir");
        newTypeLbl.setText("Nuevo Tipo:");
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        setEditableType();
    }//GEN-LAST:event_btnEditActionPerformed

    private void setEditableType() {
        DefaultTableModel tableModel = (DefaultTableModel) TableType.getModel();
        if (TableType.getSelectedRow() == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            isEditable = true;
            newTypeLbl.setText("Editar Tipo:");
            DataUpdateBtn.setText("Editar");
            Integer id = (Integer) tableModel.getValueAt(TableType.getSelectedRow(), 0);
            String name = (String) tableModel.getValueAt(TableType.getSelectedRow(), 1);
            typeEditable = new Type(id, name);
            newTypeTxt.setText(name);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteType();
        cleanFields();
        loadTypeByCategorySelected();
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void deleteType() {
        DefaultTableModel tableModel = (DefaultTableModel) TableType.getModel();
        if (TableType.getSelectedRow() == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo a eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirmed = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar estos datos? \n", "CONFIMARCIÓN", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirmed == javax.swing.JOptionPane.YES_OPTION) {
            Integer id = (Integer) tableModel.getValueAt(TableType.getSelectedRow(), 0);
            String name = (String) tableModel.getValueAt(TableType.getSelectedRow(), 1);
            try {
                typeDao.delete(new Type(id, name));
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void cmbCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoryItemStateChanged
        loadTypeByCategorySelected();
    }//GEN-LAST:event_cmbCategoryItemStateChanged

    private void loadTypeByCategorySelected() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) TableType.getModel();
            tableModel.setRowCount(0);
            Category category = (Category) cmbCategory.getSelectedItem();
            List<Type> typeList = typeDao.consultByCategory(category);
            typeList.stream().forEach(t -> tableModel.addRow(new Object[]{t.getId(), t.getName()}));
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DataUpdateBtn;
    private javax.swing.JTable TableType;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JComboBox<Category> cmbCategory;
    private javax.swing.JPanel content;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel newTypeLbl;
    private javax.swing.JTextField newTypeTxt;
    // End of variables declaration//GEN-END:variables

}
