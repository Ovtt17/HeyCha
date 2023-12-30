package com.mycompany.interfaces.exporters.implementation;


import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.mycompany.interfaces.exporters.IPdfExporter;

public class PdfExporterImpl implements IPdfExporter {

    @Override
    public void export(JTable jTable, Integer count, Float totalMoney) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como...");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileToSave.getAbsolutePath() + ".pdf"));

                // Agregar encabezado
                writer.setPageEvent(new PdfPageEventHelper() {
                    public void onEndPage(PdfWriter writer, Document document) {
                        PdfContentByte cb = writer.getDirectContent();
                        Font font = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD); // Fuente en negrita y tamaño 18
                        Phrase header = new Phrase("Ventas del mes", font);
                        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                                header,
                                (document.right() - document.left()) / 2 + document.leftMargin(),
                                document.top() + 10, 0);

                        // Agregar total de ventas y total de dinero
                        Font font2 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL); // Fuente normal y tamaño 12
                        Phrase sales = new Phrase("Total de ventas: " + count, font2);
                        Phrase money = new Phrase("Total de dinero: " + totalMoney, font2);
                        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                                sales,
                                (document.right() - document.left()) / 2 + document.leftMargin(),
                                document.top() - 20, 0);
                        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                                money,
                                (document.right() - document.left()) / 2 + document.leftMargin(),
                                document.top() - 30, 0);
                    }
                });

                document.open();

                // Agregar espacio adicional
                document.add(new Paragraph("\n\n\n"));

                PdfPTable pdfTable = new PdfPTable(jTable.getColumnCount());
                pdfTable.setWidthPercentage(100); // Hacer que la tabla ocupe todo el ancho de la página
                pdfTable.setSpacingBefore(10f); // Espacio antes de la tabla
                pdfTable.setSpacingAfter(10f); // Espacio después de la tabla

                // Establecer un tamaño de celda más grande
                pdfTable.getDefaultCell().setPadding(5);

                // Agregar encabezado de tabla con fondo gris
                for (int i = 0; i < jTable.getColumnCount(); i++) {
                    PdfPCell cell = new PdfPCell(new Phrase(jTable.getColumnName(i)));
                    cell.setBackgroundColor(BaseColor.GRAY);
                    pdfTable.addCell(cell);
                }

                for (int rows = 0; rows < jTable.getRowCount(); rows++) {
                    for (int cols = 0; cols < jTable.getColumnCount(); cols++) {
                        pdfTable.addCell(jTable.getModel().getValueAt(rows, cols).toString());
                    }
                }

                document.add(pdfTable);
                document.close();
                javax.swing.JOptionPane.showMessageDialog(null, "PDF creado exitosamente!\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
