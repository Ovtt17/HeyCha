package com.mycompany.views.configuration.product;

import com.mycompany.interfaces.style.IStyleable;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class ProductConfiguration extends javax.swing.JPanel implements IStyleable{

    boolean lightOrDarkMode;
    public ProductConfiguration() {
        initComponents();
    }

    public ProductConfiguration(boolean darkModeEnabled) {
        initComponents();
        updateStyles(darkModeEnabled);
        initStyles();
    }
    
    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        lightOrDarkMode = isDarkModeEnabled;
        if (isDarkModeEnabled) {
            headerPanel.putClientProperty("FlatLaf.style", "background: #26354f");
            contentPanel.putClientProperty("FlatLaf.style", "background: #172030");
            bg.putClientProperty("FlatLaf.style", "background: #172030");
            title.setForeground(Color.white);
            rbBrand.setForeground(Color.white);
            rbCategory.setForeground(Color.white);
            rbType.setForeground(Color.white);
            rbSizes.setForeground(Color.white);
        } else {
            headerPanel.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            contentPanel.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            bg.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            title.setForeground(Color.black);
            rbBrand.setForeground(Color.black);
            rbCategory.setForeground(Color.black);
            rbType.setForeground(Color.black);
            rbSizes.setForeground(Color.black);
        }
    }

    @Override
    public void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        rbBrand.putClientProperty("FlatLaf.styleClass", "h2");
        rbCategory.putClientProperty("FlatLaf.styleClass", "h2");
        rbType.putClientProperty("FlatLaf.styleClass", "h2");
        rbSizes.putClientProperty("FlatLaf.styleClass", "h2");
        
    }

    private void ShowPanel(JPanel p) {
        p.setSize(756, 461);
        p.setLocation(0, 0);

        contentPanel.removeAll();
        contentPanel.add(p, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        rbBrand = new javax.swing.JRadioButton();
        rbType = new javax.swing.JRadioButton();
        rbCategory = new javax.swing.JRadioButton();
        rbSizes = new javax.swing.JRadioButton();

        bg.setBackground(new java.awt.Color(255, 255, 255));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setPreferredSize(new java.awt.Dimension(756, 461));
        contentPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("Configuración de Productos");

        buttonGroup.add(rbBrand);
        rbBrand.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbBrand.setForeground(new java.awt.Color(0, 0, 0));
        rbBrand.setText("Marcas");
        rbBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBrandActionPerformed(evt);
            }
        });

        buttonGroup.add(rbType);
        rbType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbType.setForeground(new java.awt.Color(0, 0, 0));
        rbType.setText("Tipos");
        rbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTypeActionPerformed(evt);
            }
        });

        buttonGroup.add(rbCategory);
        rbCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbCategory.setForeground(new java.awt.Color(0, 0, 0));
        rbCategory.setText("Categoria");
        rbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCategoryActionPerformed(evt);
            }
        });

        buttonGroup.add(rbSizes);
        rbSizes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbSizes.setForeground(new java.awt.Color(0, 0, 0));
        rbSizes.setText("Tallas");
        rbSizes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSizesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(title))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(rbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbType, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbSizes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbType, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbSizes)))
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
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

    private void rbBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBrandActionPerformed
        ShowPanel(new BrandConfiguration(this.lightOrDarkMode));
    }//GEN-LAST:event_rbBrandActionPerformed

    private void rbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTypeActionPerformed
        ShowPanel(new TypeConfiguration(this.lightOrDarkMode));
    }//GEN-LAST:event_rbTypeActionPerformed

    private void rbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCategoryActionPerformed
        ShowPanel(new CategoryConfiguration(this.lightOrDarkMode));
    }//GEN-LAST:event_rbCategoryActionPerformed

    private void rbSizesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSizesActionPerformed
        ShowPanel(new SizeConfiguration(this.lightOrDarkMode));
    }//GEN-LAST:event_rbSizesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JRadioButton rbBrand;
    private javax.swing.JRadioButton rbCategory;
    private javax.swing.JRadioButton rbSizes;
    private javax.swing.JRadioButton rbType;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    
}
