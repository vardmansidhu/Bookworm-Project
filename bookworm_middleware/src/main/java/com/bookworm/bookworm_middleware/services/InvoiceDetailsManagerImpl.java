// InvoiceDetailsManagerImpl.java
package com.bookworm.bookworm_middleware.services;

import com.bookworm.bookworm_middleware.entities.InvoiceDetails;
import com.bookworm.bookworm_middleware.repositories.IInvoiceDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailsManagerImpl implements IInvoiceDetailsManager {

    @Autowired
    private IInvoiceDetailsRepository repository;

    @Override
    public List<InvoiceDetails> getAllInvoiceDetails() {
        return repository.findAll();
    }

    @Override
    public List<InvoiceDetails> getInvoiceDetailsByInvoiceId(int invoiceId) {
        return repository.findByInvoiceId(invoiceId);
    }

    @Override
    public InvoiceDetails getInvoiceDetailsById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void addInvoiceDetails(InvoiceDetails invoiceDetails) {
        repository.save(invoiceDetails);
    }

    @Override
    public void updateInvoiceDetails(InvoiceDetails invoiceDetails) {
        repository.save(invoiceDetails);
    }

    @Override
    public void deleteInvoiceDetails(int id) {
        repository.deleteById(id);
    }

}