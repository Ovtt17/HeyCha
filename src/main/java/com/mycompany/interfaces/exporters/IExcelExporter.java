package com.mycompany.interfaces.exporters;

import javax.swing.JTable;

public interface IExcelExporter {
    void export(JTable table) throws Exception;
}
