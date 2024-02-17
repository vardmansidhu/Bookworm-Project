package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworm.bookworm_middleware.entities.InvoiceDetails;

public interface IInvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {

}
