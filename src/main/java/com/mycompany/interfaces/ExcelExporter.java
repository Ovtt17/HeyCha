package com.mycompany.interfaces;

import javax.swing.JTable;

public interface ExcelExporter {
    void export(JTable table) throws Exception;
}
