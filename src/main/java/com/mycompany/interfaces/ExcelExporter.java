package com.mycompany.interfaces;

import javax.swing.JTable;

public interface ExcelExporter {
    void exportToExcel(JTable table) throws Exception;
}
