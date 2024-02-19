package com.bookworm.bookworm_middleware.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.entities.Invoice;

@Repository
@Transactional
public interface IInvoiceRepository extends JpaRepository<Invoice, Integer>
{
	
	Optional<Invoice> getByInvoiceId(int invoiceid);
	
	void deleteByInvoiceId(int invoiceid);
	
	List<Invoice> getByCustomerId(int customerid);
	
	void deleteByCustomerId(int customerid);
	
	List<Invoice> getByInvoiceAmount(int invoiceamount);

	List<Invoice> getByInvoiceDate(Date invoicedate);

	void deleteByInvoiceDate(Date invoicedate);

	@Query(value = "SELECT i.customer_id FROM Invoice i WHERE i.invoice_id = :invoiceId", nativeQuery = true)
	Integer findCustomerIdByInvoiceId(int invoiceId);
}