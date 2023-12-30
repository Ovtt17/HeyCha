package com.mycompany.interfaces.exporters;

import javax.swing.JTable;

public interface IPdfExporter {
    void export(JTable jTable, Integer count, Float totalMoney);
}
