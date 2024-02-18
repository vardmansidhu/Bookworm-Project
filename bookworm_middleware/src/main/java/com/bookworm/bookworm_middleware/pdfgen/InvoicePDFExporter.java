package com.bookworm.bookworm_middleware.pdfgen;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
// import com.bookworm.bookworm_middleware.entities.Invoice;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoicePDFExporter {
    public void generateInvoice() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
            document.open();
            // document.add(new Paragraph("Hello World!"));

            PdfPTable table = new PdfPTable(2); // 2 columns.
            table.setWidthPercentage(100); // Width 100%
            table.setSpacingBefore(10f); // Space before table
            table.setSpacingAfter(10f); // Space after table

            // Set Column widths
            float[] columnWidths = { 1f, 1f };
            table.setWidths(columnWidths);

            Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 20.0f, Font.BOLD, BaseColor.BLACK);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Bookworm", headingFont));
            cell1.setBorder(PdfPCell.NO_BORDER);
            cell1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            cell1.setFixedHeight(200f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Payment Invoice"));
            cell2.setBorder(PdfPCell.NO_BORDER);
            cell2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            cell2.setFixedHeight(200f);

            table.addCell(cell1);
            table.addCell(cell2);

            document.add(table);

            PdfPTable productTable = new PdfPTable(5); // 5 columns.
            productTable.setWidthPercentage(100); // Width 100%
            productTable.setSpacingBefore(10f); // Space before table
            productTable.setSpacingAfter(10f); // Space after table

            productTable.addCell("Product ID");
            productTable.addCell("Product Name");
            productTable.addCell("Transaction Type");
            productTable.addCell("Renting Days");
            productTable.addCell("Price");

            // Add rows to the table
            productTable.addCell("1");
            productTable.addCell("Product 1");
            productTable.addCell("Rent");
            productTable.addCell("30");
            productTable.addCell("$100");

            document.add(productTable);

            document.close();

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
