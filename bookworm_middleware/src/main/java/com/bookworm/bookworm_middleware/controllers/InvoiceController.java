package com.bookworm.bookworm_middleware.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.entities.Invoice;
import com.bookworm.bookworm_middleware.services.IInvoiceManager;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	IInvoiceManager iservice;

	@GetMapping("/get/{id}")
	public Optional<Invoice> getById(@PathVariable int id) {
		Optional<Invoice> a = iservice.getInvoiceById(id);
		return a;
	}

	@PostMapping("/add")
	public int addInvoice(@RequestBody Invoice inv) {
		LocalDate ldate = LocalDate.now();
		System.out.println(inv);
		Date date = Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		inv.setInvoicedate(date);
		iservice.addInvoice(inv);
		return inv.getInvoiceid();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		iservice.deleteByInvoiceId(id);
	}

}
