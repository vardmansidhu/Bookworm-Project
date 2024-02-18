// IInvoiceDetailsManager.java
package com.bookworm.bookworm_middleware.services;

import com.bookworm.bookworm_middleware.entities.InvoiceDetails;

import java.util.List;

public interface IInvoiceDetailsManager {
    List<InvoiceDetails> getAllInvoiceDetails();

    List<InvoiceDetails> getInvoiceDetailsByInvoiceId(int invoiceId);

    InvoiceDetails getInvoiceDetailsById(int id);

    void addInvoiceDetails(InvoiceDetails invoiceDetails);

    void updateInvoiceDetails(InvoiceDetails invoiceDetails);

    void deleteInvoiceDetails(int id);
}