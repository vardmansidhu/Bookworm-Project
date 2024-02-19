// InvoiceDetailsController.java
package com.bookworm.bookworm_middleware.controllers;

import com.bookworm.bookworm_middleware.entities.InvoiceDetails;
import com.bookworm.bookworm_middleware.services.IInvoiceDetailsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoicedetails")
public class InvoiceDetailsController {

    @Autowired
    private IInvoiceDetailsManager service;

    @GetMapping
    public List<InvoiceDetails> getAllInvoiceDetails() {
        return service.getAllInvoiceDetails();
    }

    @GetMapping("/invoice/{invoiceId}")
    public List<InvoiceDetails> getInvoiceDetailsByInvoiceId(@PathVariable int invoiceId) {
        return service.getInvoiceDetailsByInvoiceId(invoiceId);
    }

    @GetMapping("/{id}")
    public InvoiceDetails getInvoiceDetailsById(@PathVariable int id) {
        return service.getInvoiceDetailsById(id);
    }

    @PostMapping
    public void addInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
        service.addInvoiceDetails(invoiceDetails);
    }

    @PutMapping
    public void updateInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
        service.updateInvoiceDetails(invoiceDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoiceDetails(@PathVariable int id) {
        service.deleteInvoiceDetails(id);
    }
}