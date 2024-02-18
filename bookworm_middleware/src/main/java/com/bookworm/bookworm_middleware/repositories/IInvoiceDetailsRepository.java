package com.bookworm.bookworm_middleware.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworm.bookworm_middleware.entities.InvoiceDetails;

public interface IInvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {

    List<InvoiceDetails> findByInvoiceId(int invoiceId);

}
