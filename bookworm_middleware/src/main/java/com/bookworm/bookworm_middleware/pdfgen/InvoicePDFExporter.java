package com.bookworm.bookworm_middleware.pdfgen;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import com.bookworm.bookworm_middleware.entities.InvoiceDetails;
import com.bookworm.bookworm_middleware.services.ICustomerManager;
import com.bookworm.bookworm_middleware.services.IInvoiceManager;
// import com.bookworm.bookworm_middleware.entities.Product;
// import com.bookworm.bookworm_middleware.entities.ProductDetails;
import com.bookworm.bookworm_middleware.services.IProductManager;
import com.itextpdf.text.BaseColor;
// import com.bookworm.bookworm_middleware.entities.Invoice;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class InvoicePDFExporter {

    // @Autowired
    private IProductManager productManager;

    // private IInvoiceManager invoiceManager;
    // private int customerId;

    private ICustomerManager customerManager;

    public InvoicePDFExporter(IProductManager productManager, ICustomerManager customerManager) {
        this.productManager = productManager;
        this.customerManager = customerManager;
    }

    public ByteArrayResource generateInvoice(List<InvoiceDetails> invoiceDetails, int customerId) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, out);

            LocalDate currenDate = LocalDate.now();
            // String dest = "invoice_" + currenDate.toEpochSecond(LocalTime.now(),
            // ZoneOffset.of("Z")) + ".pdf";

            // String dest = "invoice_" + invoiceDetails.get(0).getInvoice() + ".pdf";

            // System.out.println("Invoice PDF Path: " + dest);

            // PdfWriter.getInstance(document, new FileOutputStream(dest));
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
            Font footerFont = new Font(Font.FontFamily.TIMES_ROMAN, 20.0f, Font.NORMAL, BaseColor.BLACK);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14.0f, Font.BOLD, BaseColor.BLACK);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Bookworm", headingFont));
            cell1.setBorder(PdfPCell.NO_BORDER);
            cell1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            cell1.setFixedHeight(100f);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Payment Invoice"));
            cell2.setBorder(PdfPCell.NO_BORDER);
            cell2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            cell2.setFixedHeight(100f);

            table.addCell(cell1);
            table.addCell(cell2);

            document.add(table);

            PdfPTable customerTable = new PdfPTable(2); // 2 columns.
            customerTable.setWidthPercentage(100); // Width 100%
            customerTable.setSpacingBefore(10f); // Space before table
            customerTable.setSpacingAfter(10f); // Space after table

            PdfPCell name = new PdfPCell(
                    new Paragraph("Customer Name: " + customerManager.getCustomerNameById(customerId), boldFont));
            name.setBorder(PdfPCell.NO_BORDER);
            name.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            name.setFixedHeight(10f);

            PdfPCell date = new PdfPCell(new Paragraph("Date: " + currenDate.toString(), boldFont));
            date.setBorder(PdfPCell.NO_BORDER);
            date.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            name.setFixedHeight(10f);

            customerTable.addCell(name);

            customerTable.addCell(date);

            document.add(customerTable);

            PdfPTable productTable = new PdfPTable(5); // 5 columns.
            productTable.setWidthPercentage(100); // Width 100%
            productTable.setSpacingBefore(10f); // Space before table
            productTable.setSpacingAfter(10f); // Space after table

            // Set Padding
            PdfPCell column1 = new PdfPCell(new Paragraph("Product No.", boldFont));
            column1.setPadding(10);
            productTable.addCell(column1);

            PdfPCell column2 = new PdfPCell(new Paragraph("Product Name", boldFont));
            column2.setPadding(10);
            productTable.addCell(column2);

            PdfPCell column3 = new PdfPCell(new Paragraph("Transaction Type", boldFont));
            column3.setPadding(10);
            productTable.addCell(column3);

            PdfPCell column4 = new PdfPCell(new Paragraph("Renting Days", boldFont));
            column4.setPadding(10);
            productTable.addCell(column4);

            PdfPCell column5 = new PdfPCell(new Paragraph("Price", boldFont));
            column5.setPadding(10);
            productTable.addCell(column5);

            // productTable.addCell("Product ID");
            // productTable.addCell("Product Name");
            // productTable.addCell("Transaction Type");
            // productTable.addCell("Renting Days");
            // productTable.addCell("Price");

            // Add rows to the table
            // productTable.addCell("1");
            // productTable.addCell("Product 1");
            // productTable.addCell("Rent");
            // productTable.addCell("30");
            // productTable.addCell("$100");

            int count = 1;
            double total = 0;

            for (InvoiceDetails invoiceDetail : invoiceDetails) {

                total += Math.round(invoiceDetail.getSellingPrice() * 100.0 / 100.0);

                if (invoiceDetail.getRentingDays() == null) {
                    invoiceDetail.setRentingDays(0);
                }

                PdfPCell countCell = new PdfPCell(new Paragraph(String.valueOf(count++)));
                countCell.setPadding(10f);
                productTable.addCell(countCell);

                PdfPCell nameCell = new PdfPCell(
                        new Paragraph(String.valueOf(productManager.getProductNamebyId(invoiceDetail.getProduct()))));
                nameCell.setPadding(10f);
                productTable.addCell(nameCell);

                String purchaseType;

                if (invoiceDetail.getTransactionType() == 1)
                    purchaseType = "Purchase";
                else
                    purchaseType = "Rent";

                PdfPCell typeCell = new PdfPCell(new Paragraph(purchaseType));
                typeCell.setPadding(10f);
                productTable.addCell(typeCell);

                PdfPCell rentCell = new PdfPCell(new Paragraph(invoiceDetail.getRentingDays().toString()));
                rentCell.setPadding(10f);
                productTable.addCell(rentCell);

                PdfPCell priceCell = new PdfPCell(
                        new Paragraph(String.valueOf(Math.round(invoiceDetail.getSellingPrice() * 100.0) / 100.0)));
                priceCell.setPadding(10f);
                productTable.addCell(priceCell);
            }

            document.add(productTable);

            PdfPTable totalTable = new PdfPTable(2); // 2 columns.
            totalTable.setWidthPercentage(100); // Width 100%
            totalTable.setSpacingBefore(10f); // Space before table

            PdfPCell totalStringCell = new PdfPCell(new Paragraph("Total", boldFont));
            totalStringCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            totalStringCell.setPadding(10f);

            totalTable.addCell(totalStringCell);

            PdfPCell totalCell = new PdfPCell(new Paragraph("₹" + String.valueOf(total), boldFont));
            totalCell.setPadding(10f);
            totalCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            totalTable.addCell(totalCell);

            document.add(totalTable);

            PdfPTable footerTable = new PdfPTable(1); // 1 columns.
            footerTable.setWidthPercentage(100); // Width 100%
            footerTable.setSpacingBefore(10f); // Space before table

            PdfPCell footer = new PdfPCell(new Paragraph("Thank you for shopping with us!", footerFont));
            footer.setBorder(PdfPCell.NO_BORDER);
            footer.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            footer.setPadding(30f);

            footerTable.addCell(footer);

            document.add(footerTable);

            document.close();

            // ByteArrayResource resource = new ByteArrayResource(out.toByteArray());

            return new ByteArrayResource(out.toByteArray());

            // document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
