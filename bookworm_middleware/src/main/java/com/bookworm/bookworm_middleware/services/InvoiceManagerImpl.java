package com.bookworm.bookworm_middleware.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.entities.Invoice;
import com.bookworm.bookworm_middleware.repositories.IInvoiceRepository;

@Service
public class InvoiceManagerImpl implements IInvoiceManager {
	@Autowired
	IInvoiceRepository repo;

	@Override
	public Optional<Invoice> getInvoiceById(int invoiceid) {
		return repo.getByInvoiceId(invoiceid);
	}

	@Override
	public void deleteByInvoiceId(int id) {
		repo.deleteByInvoiceId(id);
	}

	@Override
	public void addInvoice(Invoice invoice) {
		repo.save(invoice);
		// return invoice.getInvoiceid();
	}

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
}
