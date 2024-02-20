package com.bookworm.bookworm_middleware.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.dtos.InvoiceDetailDto;
import com.bookworm.bookworm_middleware.dtos.InvoiceDto;
import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.entities.Invoice;
import com.bookworm.bookworm_middleware.entities.InvoiceDetails;
import com.bookworm.bookworm_middleware.repositories.IInvoiceRepository;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

@Service
public class InvoiceManagerImpl implements IInvoiceManager {
	@Autowired
	IInvoiceRepository repo;

	@Autowired
	IInvoiceDetailsManager invoiceDetailsManager;

	@Override
	public Optional<Invoice> getInvoiceById(int invoiceid) {
		return repo.getByInvoiceId(invoiceid);
	}

	@Override
	public void deleteByInvoiceId(int id) {
		repo.deleteByInvoiceId(id);
	}

	// @Override
	// public void addInvoice(InvoiceDto invoiceDto) {
	// Invoice invoice = new Invoice();
	// invoice.setInvoicedate(invoiceDto.getInvoiceDate());
	// invoice.setCustomerid(invoiceDto.getCustomerId());
	// invoice.setInvoiceamount(invoiceDto.getInvoiceAmount());
	// invoice.setQuantity(invoiceDto.getQuantity());
	// repo.save(invoice);
	// // return invoice.getInvoiceid();
	// }

	@Override
	public List<Invoice> getByCustomerId(int customerid) {
		return repo.getByCustomerId(customerid);
	}

	@Override
	public void deleteByCustomerId(int customerid) {
		repo.deleteByCustomerId(customerid);

	}

	@Override
	public List<Invoice> getByInvoiceAmount(int customerid) {
		return repo.getByInvoiceAmount(customerid);
	}

	@Override
	public List<Invoice> getInvoiceByDate(Date date) {
		return repo.getByInvoiceDate(date);
	}

	@Override
	public void deleteByInvoiceDate(Date date) {
		repo.deleteByInvoiceDate(date);
	}

	@Override
	public Integer getCustomerIdByInvoiceId(int invoiceId) {
		return repo.findCustomerIdByInvoiceId(invoiceId);
	}

	@Override
	@Transactional
	public int createInvoiceAndDetails(InvoiceDto invoiceDto) {
		System.out.println(invoiceDto);
		// Create and save the Invoice
		Invoice invoice = new Invoice();
		invoice.setInvoicedate(invoiceDto.getInvoiceDate());
		invoice.setCustomerid(invoiceDto.getCustomerId());
		invoice.setInvoiceamount(invoiceDto.getInvoiceAmount());
		invoice.setQuantity(invoiceDto.getQuantity());

		// set properties from invoiceDto
		Invoice savedInvoice = repo.save(invoice);

		// Create and save the InvoiceDetails
		for (InvoiceDetailDto detailDto : invoiceDto.getInvoiceDetails()) {
			InvoiceDetails invoiceDetails = new InvoiceDetails();
			// set properties from detailDto
			invoiceDetails.setInvoice(savedInvoice.getInvoiceid());
			invoiceDetails.setProduct(detailDto.getProductId());
			// invoiceDetails.setQuantity(detailDto.getQuantity());
			invoiceDetails.setBasePrice(detailDto.getBasePrice());
			invoiceDetails.setSellingPrice(detailDto.getSellingPrice());
			invoiceDetails.setTransactionType(detailDto.getTransactionTypeId());
			invoiceDetails.setRentingDays(detailDto.getRentingDays());
			invoiceDetailsManager.addInvoiceDetails(invoiceDetails);
		}

		return savedInvoice.getInvoiceid();
	}

}
