package com.bookworm.bookworm_middleware.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.entities.Invoice;
import com.bookworm.bookworm_middleware.dtos.InvoiceDto;

public interface IInvoiceManager {
	Optional<Invoice> getInvoiceById(int invoiceid);

	void deleteByInvoiceId(int id);

	// void addInvoice(InvoiceDto invoiceDto);

	List<Invoice> getByCustomerId(int customerid);

	void deleteByCustomerId(int customerid);

	List<Invoice> getByInvoiceAmount(int customerid);

	List<Invoice> getInvoiceByDate(Date date);

	void deleteByInvoiceDate(Date date);

	int createInvoiceAndDetails(InvoiceDto invoiceDto);

	Integer getCustomerIdByInvoiceId(int invoiceId);

}
