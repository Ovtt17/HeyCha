package com.mycompany.views;

import com.mycompany.interfaces.dao.implementation.ProductsDaoImpl;
import com.mycompany.interfaces.dao.implementation.ProductSizeDaoImpl;
import com.mycompany.models.Product;
import com.mycompany.models.Size;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.table.DefaultTableModel;
import com.mycompany.interfaces.dao.ProductsDao;
import com.mycompany.interfaces.style.IStyleable;
import com.mycompany.models.Type;
import javax.swing.JComboBox;
import com.mycompany.interfaces.dao.ProductSizeDao;
import com.mycompany.models.Brand;
import com.mycompany.models.Category;
import com.mycompany.models.ProductSize;

public class UpProducts extends javax.swing.JPanel implements IStyleable {

    ProductsDao productDao = new ProductsDaoImpl();
    ProductSizeDao sizeDao = new ProductSizeDaoImpl();

    boolean isEditable = false;
    Product productEditable;
    List<ProductSize> originalSizes;
    List<ProductSize> newSizes = new ArrayList<>();

    List<ProductSize> sizesToDelete = new ArrayList<>();

//    HashMap<String, Integer> sizeSelected = new HashMap<>();
    public UpProducts(boolean isDarkModeEnabled) {
        initComponents();
        updateStyles(isDarkModeEnabled);
        initStyles();
    }

    public UpProducts(Product product, List<ProductSize> list, boolean isDarkModeEnabled) {
        initComponents();
        isEditable = true;
        productEditable = product;
        originalSizes = list;
        updateStyles(isDarkModeEnabled);
        initStyles();
    }

    @Override
    public void updateStyles(boolean isDarkModeEnabled) {
        if (isDarkModeEnabled) {
            title.setForeground(Color.white);
            SizeTable.setForeground(Color.white);
            bg.putClientProperty("FlatLaf.style", "background: #172030");
            panelLeft.putClientProperty("FlatLaf.style", "background: #172030");
            panelRight.putClientProperty("FlatLaf.style", "background: #172030");
            DataUpdateBtn.putClientProperty("FlatLaf.style", "background: #0c9294");
        } else {
            title.setForeground(Color.black);
            SizeTable.setForeground(Color.black);
            bg.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            panelLeft.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            panelRight.putClientProperty("FlatLaf.style", "background: #FFFFFF");
            DataUpdateBtn.putClientProperty("FlatLaf.style", "background: #125AAD");
        }
    }

    @Override
    public void initStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        nameLbl.putClientProperty("FlatLaf.styleClass", "h2");
        priceLbl.putClientProperty("FlatLaf.styleClass", "h2");
        descriptionLbl.putClientProperty("FlatLaf.styleClass", "h2");
        discountLbl.putClientProperty("FlatLaf.styleClass", "h2");
        BrandLbl.putClientProperty("FlatLaf.styleClass", "h2");
        categoryLbl.putClientProperty("FlatLaf.styleClass", "h2");
        typeLbl.putClientProperty("FlatLaf.styleClass", "h2");
        sizeLbl.putClientProperty("FlatLaf.styleClass", "h2");

        nameTxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del producto.");
        priceTxt.putClientProperty("JTextField.placeholderText", "Ingrese el precio del producto.");
        descriptionTxt.putClientProperty("JTextField.placeholderText", "Ingrese una descripcion para el producto. (Opcional)");
        discountTxt.putClientProperty("JTextField.placeholderText", "Ingrese el descuento que tendrá el producto. (opcional)");

        SizeTable.getTableHeader().setBackground(new Color(0, 0, 0));
        SizeTable.getTableHeader().setForeground(new Color(255, 255, 255));

        try {
            ItemListener[] itemListeners = categoryCmb.getListeners(ItemListener.class);

            for (ItemListener itemListener : itemListeners) {
                categoryCmb.removeItemListener(itemListener);
            }

            productDao.loadComboboxByCategory(categoryCmb);
            productDao.loadComboboxByBrand(brandCmb);

            for (ItemListener itemListener : itemListeners) {
                categoryCmb.addItemListener(itemListener);
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        if (isEditable) {
            title.setText("Editar producto.");
            DataUpdateBtn.setText("Guardar");
            
            nameTxt.setText(productEditable.getName());
            priceTxt.setText(String.valueOf(productEditable.getPrice()));
            descriptionTxt.setText(productEditable.getDescription());
            Integer discount = productEditable.getDiscount() == null ? 0 : productEditable.getDiscount();
            discountTxt.setText(String.valueOf(discount));
            brandCmb.setSelectedItem(productEditable.getBrand());
            categoryCmb.setSelectedItem(productEditable.getCategory());
            typeCmb.setSelectedItem(productEditable.getType());

            DefaultTableModel model = (DefaultTableModel) SizeTable.getModel();
            originalSizes.forEach(s -> {
                Size size = new Size(s.getSizeId(), s.getSizeName());
                model.addRow(new Object[]{size, s.getAmount()});
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panelRight = new javax.swing.JPanel();
        categoryLbl = new javax.swing.JLabel();
        categoryCmb = new javax.swing.JComboBox<>();
        sizeLbl = new javax.swing.JLabel();
        sizeCmb = new javax.swing.JComboBox<>();
        amountSpinner = new javax.swing.JSpinner();
        addSizeBtn = new javax.swing.JButton();
        deleteSizeBtn = new javax.swing.JButton();
        typeLbl = new javax.swing.JLabel();
        typeCmb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        SizeTable = new javax.swing.JTable();
        DataUpdateBtn = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        priceLbl = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        descriptionLbl = new javax.swing.JLabel();
        descriptionTxt = new javax.swing.JTextField();
        discountLbl = new javax.swing.JLabel();
        discountTxt = new javax.swing.JTextField();
        BrandLbl = new javax.swing.JLabel();
        brandCmb = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(764, 436));

        bg.setBackground(new java.awt.Color(0, 0, 0));
        bg.setPreferredSize(new java.awt.Dimension(764, 436));

        title.setText("Subir nuevo producto.");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));

        categoryLbl.setText("Categoria:");

        categoryCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryCmb.setMinimumSize(new java.awt.Dimension(0, 0));
        categoryCmb.setPreferredSize(new java.awt.Dimension(64, 22));
        categoryCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryCmbItemStateChanged(evt);
            }
        });

        sizeLbl.setText("Talla:");

        sizeCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sizeCmb.setMinimumSize(new java.awt.Dimension(0, 0));
        sizeCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        amountSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        addSizeBtn.setBackground(new java.awt.Color(0, 181, 64));
        addSizeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addSizeBtn.setForeground(new java.awt.Color(255, 255, 255));
        addSizeBtn.setText("+");
        addSizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSizeBtnActionPerformed(evt);
            }
        });

        deleteSizeBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteSizeBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteSizeBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteSizeBtn.setText("-");
        deleteSizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSizeBtnActionPerformed(evt);
            }
        });

        typeLbl.setText("Tipo:");

        typeCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        typeCmb.setMinimumSize(new java.awt.Dimension(0, 0));
        typeCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        SizeTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SizeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Talla", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SizeTable.setColumnSelectionAllowed(true);
        SizeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(SizeTable);
        SizeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        DataUpdateBtn.setBackground(new java.awt.Color(18, 90, 173));
        DataUpdateBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DataUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        DataUpdateBtn.setText("Subir");
        DataUpdateBtn.setBorderPainted(false);
        DataUpdateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataUpdateBtn.setMinimumSize(new java.awt.Dimension(0, 0));
        DataUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataUpdateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRightLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addComponent(DataUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRightLayout.createSequentialGroup()
                                .addComponent(sizeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(196, 196, 196))
                            .addGroup(panelRightLayout.createSequentialGroup()
                                .addComponent(typeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(198, 198, 198))
                            .addGroup(panelRightLayout.createSequentialGroup()
                                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sizeCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(24, 24, 24)))
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addSizeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteSizeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRightLayout.createSequentialGroup()
                                .addComponent(categoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(136, 136, 136))
                            .addComponent(typeCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(112, 112, 112))))
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRightLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(addSizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteSizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DataUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));

        nameLbl.setText("Nombre:");

        nameTxt.setMinimumSize(new java.awt.Dimension(0, 0));

        priceLbl.setText("Precio:");

        priceTxt.setMinimumSize(new java.awt.Dimension(0, 0));

        descriptionLbl.setText("Descripción (Opcional):");

        descriptionTxt.setMinimumSize(new java.awt.Dimension(0, 0));

        discountLbl.setText("Descuento (Opcional):");

        discountTxt.setMinimumSize(new java.awt.Dimension(0, 0));

        BrandLbl.setText("Marca:");

        brandCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brandCmb.setMinimumSize(new java.awt.Dimension(0, 0));
        brandCmb.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(256, 256, 256))
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLeftLayout.createSequentialGroup()
                                .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45))
                            .addComponent(discountTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLeftLayout.createSequentialGroup()
                                .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39))
                            .addComponent(brandCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descriptionTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLeftLayout.createSequentialGroup()
                                .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(158, 158, 158)))
                        .addGap(91, 91, 91))
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(245, 245, 245))))
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(priceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrandLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addComponent(panelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(69, 69, 69))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51))
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
        String name = nameTxt.getText().trim();
        Float price = null;
        Integer discount;
        try {
            if (!priceTxt.getText().trim().isEmpty()) {
                price = Float.valueOf(priceTxt.getText().trim());
                if (price < 1) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El precio no puede ser menor que $1. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    priceTxt.requestFocus();
                    return;
                }
            }

            String discountText = discountTxt.getText().trim();
            discount = (discountText.isEmpty() || Integer.parseInt(discountText) < 1)
                    ? null : Integer.valueOf(discountText);

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese solo números en los campos de precio y descuento. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String description = descriptionTxt.getText().trim().isEmpty() ? null : descriptionTxt.getText().trim();

        Brand brand = (Brand) brandCmb.getSelectedItem();
        Category category = (Category) categoryCmb.getSelectedItem();
        Type type = (Type) typeCmb.getSelectedItem();

        Integer brandId = brand.getId();
        Integer categoryId = category.getId();
        Integer typeId = type.getId();

        boolean incorrectData = name.isEmpty() || price == null || brandId == null || categoryId == null || typeId == null || SizeTable.getRowCount() == 0;

        if (incorrectData) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos correctamente. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            nameTxt.requestFocus();
            return;
        }

        Product product = isEditable ? productEditable : new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setBrand(brand);
        product.setCategory(category);
        product.setType(type);

        try {
            DefaultTableModel model = (DefaultTableModel) SizeTable.getModel();

            Integer productId = isEditable ? productDao.modify(product) : productDao.record(product);

            if (isEditable) {
                List<ProductSize> sizesToModify = new ArrayList<>(originalSizes);

                if (!sizesToDelete.isEmpty()) {
                    sizesToModify.removeAll(sizesToDelete);
                    sizesToDelete.forEach(s -> {
                        try {
                            sizeDao.delete(s);
                        } catch (Exception ex) {
                            Logger.getLogger(UpProducts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
                if (!newSizes.isEmpty()) {
                    sizesToModify.addAll(newSizes);
                }
                sizesToModify.forEach(s -> {
                    try {
                        boolean isModified = sizeDao.modify(s);
                        if (!isModified) {
                            sizeDao.record(s);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(UpProducts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

            } else {
                for (int i = 0; i < model.getRowCount(); i++) {
                    Size size = (Size) model.getValueAt(i, 0);
                    Integer amount = (Integer) model.getValueAt(i, 1);
                    newSizes.add(new ProductSize(productId, size.getId(), amount));
                }
                newSizes.forEach(s -> {
                    try {
                        sizeDao.record(s);
                    } catch (Exception ex) {
                        Logger.getLogger(UpProducts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            newSizes.clear();
            sizesToDelete.clear();
            String succecssMsg = isEditable ? "modificado" : "registrado";
            javax.swing.JOptionPane.showMessageDialog(this, "Datos " + succecssMsg + " correctamente. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (!isEditable) {
                emptyFields();
            }
        } catch (Exception e) {
            String errorMsg = isEditable ? "modificar" : "registrar";
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al " + errorMsg + " los datos. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_DataUpdateBtnActionPerformed

    private void categoryCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryCmbItemStateChanged
        DefaultTableModel model = (DefaultTableModel) SizeTable.getModel();
        if (SizeTable.getRowCount() > 0) {
            model.setRowCount(0);
        }
        Category categorySelected = (Category) categoryCmb.getSelectedItem();

        try {
            Category category = productDao.loadSizes(categorySelected);
            loadListInComboBox(category.getSizeList(), sizeCmb);
            loadListInComboBox(category.getTypeList(), typeCmb);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error. \n" + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_categoryCmbItemStateChanged
    private <T> void loadListInComboBox(List<T> list, JComboBox combobox) {
        combobox.removeAllItems();
        list.forEach(s -> combobox.addItem(s));
    }

    private void addSizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSizeBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) SizeTable.getModel();

        Integer amount = ((Number) amountSpinner.getValue()).intValue();
        Integer sizeSelectedIndex = sizeCmb.getSelectedIndex();
        Size size = (Size) sizeCmb.getSelectedItem();
        String sizeName = size.getName();
        Integer sizeId = size.getId();
        
        if (sizeSelectedIndex == -1 || amount == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe marcar la talla que desea agregar y dar una cantidad mayor que 0.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean sizeExistsInTable = IntStream.range(0, model.getRowCount())
                .mapToObj(i -> (Size) model.getValueAt(i, 0))
                .anyMatch(tableItem -> tableItem.equals(size));

        if (sizeExistsInTable) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ya agregó la talla " + sizeName + ".\n\nIngrese una nueva talla", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isEditable) {
            final Integer productId = productEditable.getId();
            newSizes.add(new ProductSize(productId, sizeId, amount));
        }
        model.addRow(new Object[]{size, amount});
        amountSpinner.setValue(0);
    }//GEN-LAST:event_addSizeBtnActionPerformed

    private void deleteSizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSizeBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) SizeTable.getModel();

        Integer selectedRow = SizeTable.getSelectedRow();
        int rows = model.getRowCount();
        if (rows == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay tallas para eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (selectedRow < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar una talla para borrar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Size size = (Size) model.getValueAt(selectedRow, 0);
        Integer amount = (Integer) model.getValueAt(selectedRow, 1);

        model.removeRow(selectedRow);

        if (isEditable) {
            final Integer productId = productEditable.getId();
            ProductSize productSize = new ProductSize(productId, size.getId(), amount);
            sizesToDelete.add(productSize);
        }
    }//GEN-LAST:event_deleteSizeBtnActionPerformed

    private void emptyFields() {
        DefaultTableModel model = (DefaultTableModel) SizeTable.getModel();
        model.setRowCount(0);

        nameTxt.setText("");
        priceTxt.setText("");
        descriptionTxt.setText("");
        discountTxt.setText("");
        brandCmb.setSelectedIndex(-1);
        ItemListener[] itemListeners = categoryCmb.getListeners(ItemListener.class);

        for (ItemListener itemListener : itemListeners) {
            categoryCmb.removeItemListener(itemListener);
        }
        categoryCmb.setSelectedIndex(-1);
        for (ItemListener itemListener : itemListeners) {
            categoryCmb.addItemListener(itemListener);
        }
        typeCmb.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandLbl;
    private javax.swing.JButton DataUpdateBtn;
    private javax.swing.JTable SizeTable;
    private javax.swing.JButton addSizeBtn;
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<Brand> brandCmb;
    private javax.swing.JComboBox<Category> categoryCmb;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JButton deleteSizeBtn;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JLabel discountLbl;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JComboBox<Size> sizeCmb;
    private javax.swing.JLabel sizeLbl;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<Type> typeCmb;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables

}
