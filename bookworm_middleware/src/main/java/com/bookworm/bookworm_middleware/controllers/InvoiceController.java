package com.bookworm.bookworm_middleware.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.dtos.InvoiceDto;
import com.bookworm.bookworm_middleware.entities.Invoice;
import com.bookworm.bookworm_middleware.pdfgen.InvoicePDFExporter;
import com.bookworm.bookworm_middleware.services.ICustomerManager;
import com.bookworm.bookworm_middleware.services.IInvoiceDetailsManager;
import com.bookworm.bookworm_middleware.services.IInvoiceManager;
import com.bookworm.bookworm_middleware.services.IProductManager;

// import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	IInvoiceManager iservice;

	@Autowired
	IInvoiceDetailsManager idservice;

	@Autowired
	IProductManager pservice;

	@Autowired
	ICustomerManager cservice;

	@GetMapping("/get/{id}")
	public Optional<Invoice> getById(@PathVariable int id) {
		Optional<Invoice> a = iservice.getInvoiceById(id);
		return a;
	}

	@PostMapping("/add")
	public int addInvoice(@RequestBody InvoiceDto invoiceDto) {
		// System.out.println(invoiceDto);
		LocalDate ldate = LocalDate.now();
		// System.out.println(inv);
		Date date = Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		invoiceDto.setInvoiceDate(date);
		return iservice.createInvoiceAndDetails(invoiceDto);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		iservice.deleteByInvoiceId(id);
	}

	@GetMapping("/pdf/{id}")
	public ResponseEntity<ByteArrayResource> getMethodName(@PathVariable int id) {
		InvoicePDFExporter exporter = new InvoicePDFExporter(pservice, cservice);
		ByteArrayResource resource = exporter.generateInvoice(idservice.getInvoiceDetailsByInvoiceId(id),
				iservice.getCustomerIdByInvoiceId(id));
		// return "Invoice PDF Generated";
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice.pdf")
				.body(resource);
	}

}
