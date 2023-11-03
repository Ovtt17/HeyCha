package com.mycompany.exporters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import com.mycompany.interfaces.ExcelExporter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JTableToExcelExporter implements ExcelExporter {

    @Override
    public void exportToExcel(JTable table) throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Especifique un archivo para guardar");

        // Aceptar solo archivos .xlsx
        FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(excelFilter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Asegurarse de que el archivo tiene la extensión .xlsx
            if (!filePath.endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            TableModel model = table.getModel();
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet();
                Row row;
                Cell cell;

                // Crear un estilo para los encabezados
                CellStyle headerStyle = workbook.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerStyle.setAlignment(HorizontalAlignment.CENTER);
                Font font = workbook.createFont();
                font.setFontName("Arial");
                font.setFontHeightInPoints((short) 10);
                font.setBold(true);
                headerStyle.setFont(font);

                // Escribe los encabezados de las columnas
                row = sheet.createRow(0);
                for (int c = 0; c < model.getColumnCount(); c++) {
                    cell = row.createCell(c);
                    cell.setCellValue(model.getColumnName(c));
                }

                // Escribe las filas de datos
                for (int r = 0; r < model.getRowCount(); r++) {
                    row = sheet.createRow(r + 1);
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        cell = row.createCell(c);
                        Object value = model.getValueAt(r, c);
                        if (value != null) {
                            if (value instanceof String string) {
                                cell.setCellValue(string);
                            } else if (value instanceof Integer integer) {
                                cell.setCellValue(integer);
                            } else if (value instanceof Double double1) {
                                cell.setCellValue(double1);
                            } else if (value instanceof Float float1) {
                                cell.setCellValue(float1);
                            } else if (value instanceof Boolean boolean1) {
                                cell.setCellValue(boolean1);
                            } else if (value instanceof java.util.Date date) {
                                cell.setCellValue(date);
                            } else {
                                // Para cualquier otro tipo de objeto, usa toString()
                                cell.setCellValue(value.toString());
                            }
                        }
                    }
                }

                // Autoajuste del tamaño de las columnas
                for (int c = 0; c < model.getColumnCount(); c++) {
                    sheet.autoSizeColumn(c);
                }

                try (FileOutputStream out = new FileOutputStream(filePath)) {
                    workbook.write(out);
                }
            }

            System.out.println("Datos exportados con éxito a " + filePath);
        }
    }
}
