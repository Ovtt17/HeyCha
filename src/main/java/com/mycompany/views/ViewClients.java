package com.mycompany.views;

import com.mycompany.heycha.DAOClientsImpl;
import com.mycompany.heycha.DAOProductsImpl;
import com.mycompany.heycha.Dashboard;
import com.mycompany.interfaces.DAOClients;
import com.mycompany.interfaces.DAOProducts;
import com.mycompany.interfaces.Styleable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class ViewClients extends javax.swing.JPanel implements Styleable {

    boolean lightOrDarkMode;
    public ViewClients(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        loadClients();
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        lightOrDarkMode = isDarkModeEnabled;
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        clientSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del cliente a buscar.");

        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnCleanField.putClientProperty("JButton.buttonType", "roundRect");
        
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            background_clients.putClientProperty("FlatLaf.style", "background: #172030");
            btnCleanField.putClientProperty("FlatLaf.style", "background: #0A677A");
            btnAdd.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnDelete.putClientProperty("FlatLaf.style", "background: #0c9294");
            btnEdit.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            background_clients.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            btnCleanField.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnAdd.putClientProperty("FlatLaf.style", "background: #1565C0");
            btnDelete.putClientProperty("FlatLaf.style", "background: #FF3333");
            btnEdit.putClientProperty("FlatLaf.style", "background: #FFB72C");
        }
    }

    private void loadClients() {
        DAOClients dao = new DAOClientsImpl();
        DefaultTableModel model = (DefaultTableModel) JTableClients.getModel();
        String nameToFind = "";
        consultClients(dao, model, nameToFind);
    }

    private void consultClients(DAOClients dao, DefaultTableModel model, String nameToFind) {
        try {
            dao.consult(nameToFind).forEach((c) -> model.addRow(new Object[]{c.getId(), c.getName(), c.getCellphone(), c.getCity(), c.getDirection()}));
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

        background_clients = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        clientSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableClients = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCleanField = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(764, 436));

        background_clients.setBackground(new java.awt.Color(255, 255, 255));
        background_clients.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        background_clients.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Clientes");

        clientSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        clientSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clientSearchKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        JTableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Celular", "Ciudad", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableClients.setRowHeight(30);
        JTableClients.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableClients);

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

        btnCleanField.setBackground(new java.awt.Color(21, 101, 192));
        btnCleanField.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanField.setText("Limpiar Búsqueda");
        btnCleanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_clientsLayout = new javax.swing.GroupLayout(background_clients);
        background_clients.setLayout(background_clientsLayout);
        background_clientsLayout.setHorizontalGroup(
            background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_clientsLayout.createSequentialGroup()
                .addGroup(background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_clientsLayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(background_clientsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_clientsLayout.createSequentialGroup()
                                .addComponent(clientSearch)
                                .addGap(41, 41, 41)
                                .addComponent(btnCleanField))
                            .addComponent(jScrollPane1))))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_clientsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        background_clientsLayout.setVerticalGroup(
            background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_clientsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCleanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background_clients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background_clients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Dashboard.ShowPanel(new UpClients(lightOrDarkMode));
    }//GEN-LAST:event_btnAddActionPerformed

    private void clientSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientSearchKeyReleased
//        if (!btnDelete.isEnabled() || !BrandFilterCmb.isEnabled() || !CategoryFilterCmb.isEnabled() && productSearch.getText().isEmpty()) {
//            javax.swing.JOptionPane.showMessageDialog(this, "No puede realizar búsqueda dentro de los detalles de un producto. \n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
//            productSearch.setText("");
//            return;
//        } else {
//            filterConsult();
//        }
    }//GEN-LAST:event_clientSearchKeyReleased

    private void btnCleanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldActionPerformed
        clientSearch.setText("");
    }//GEN-LAST:event_btnCleanFieldActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (JTableClients.getSelectedRow() > -1) {
            try {
                int productId = (int) JTableClients.getValueAt(JTableClients.getSelectedRow(), 0);
                DAOClients dao = new DAOClientsImpl();
                Dashboard.ShowPanel(new UpClients(dao.getClientById(productId), lightOrDarkMode));
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar un producto a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableClients;
    private javax.swing.JPanel background_clients;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCleanField;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JTextField clientSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
