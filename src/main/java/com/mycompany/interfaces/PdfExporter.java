package com.mycompany.interfaces;

import javax.swing.JTable;

public interface PdfExporter {
    void export(JTable jTable, Integer count, Float totalMoney);
}
