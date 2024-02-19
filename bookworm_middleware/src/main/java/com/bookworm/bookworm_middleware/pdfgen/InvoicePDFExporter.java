package com.bookworm.bookworm_middleware.pdfgen;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void generateInvoice(List<InvoiceDetails> invoiceDetails, int customerId) {

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
            Font footerFont = new Font(Font.FontFamily.TIMES_ROMAN, 20.0f, Font.NORMAL, BaseColor.BLACK);

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

            LocalDate currenDate = LocalDate.now();

            PdfPCell name = new PdfPCell(new Paragraph(customerManager.getCustomerNameById(customerId)));
            name.setBorder(PdfPCell.NO_BORDER);
            name.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            name.setFixedHeight(10f);

            PdfPCell date = new PdfPCell(new Paragraph(currenDate.toString()));
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

            //Set Padding
            PdfPCell column1 = new PdfPCell(new Paragraph("Product No."));
            column1.setPadding(10);
            productTable.addCell(column1);

            PdfPCell column2 = new PdfPCell(new Paragraph("Product Name"));
            column2.setPadding(10);
            productTable.addCell(column2);

            PdfPCell column3 = new PdfPCell(new Paragraph("Transaction Type"));
            column3.setPadding(10);
            productTable.addCell(column3);

            PdfPCell column4 = new PdfPCell(new Paragraph("Renting Days"));
            column4.setPadding(10);
            productTable.addCell(column4);

            PdfPCell column5 = new PdfPCell(new Paragraph("Price"));
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
                
                if(invoiceDetail.getRentingDays() == null) {
                    invoiceDetail.setRentingDays(0);
                }
                
                productTable.addCell(String.valueOf(count++));
                productTable.addCell(String.valueOf(productManager.getProductNamebyId(invoiceDetail.getProduct())));
                // productTable.addCell(String.valueOf(invoiceDetail.getTransactionType()));
                if(invoiceDetail.getTransactionType() == 1)
                    productTable.addCell("Purchase");
                else
                    productTable.addCell("Rent");
                productTable.addCell(invoiceDetail.getRentingDays().toString());
                productTable.addCell(String.valueOf(Math.round(invoiceDetail.getSellingPrice() * 100.0) / 100.0));
            }

            document.add(productTable);

            PdfPTable totalTable = new PdfPTable(2); // 2 columns.
            totalTable.setWidthPercentage(100); // Width 100%
            totalTable.setSpacingBefore(10f); // Space before table

            totalTable.addCell("Total");
            totalTable.addCell(String.valueOf(total));

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

            // document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
