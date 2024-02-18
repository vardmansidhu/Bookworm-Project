package com.bookworm.bookworm_middleware.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private int invoiceId;

	@Column(name = "invoice_date")
	private Date invoiceDate;

	// @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	// @JoinColumn(name="customer_id")
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "invoice_amount")
	private float invoiceAmount;
	private int quantity;

	// @Column(name="base_price")
	// private float basePrice;

	// @Column(name="selling_price")
	// private float sellingPrice;

	public int getInvoiceid() {
		return invoiceId;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceId = invoiceid;
	}

	public Date getInvoicedate() {
		return invoiceDate;
	}

	public void setInvoicedate(Date invoicedate) {
		this.invoiceDate = invoicedate;
	}

	public int getCustomerid() {
		return customerId;
	}

	public void setCustomerid(int customerid) {
		this.customerId = customerid;
	}

	public float getInvoiceamount() {
		return invoiceAmount;
	}

	public void setInvoiceamount(float invoiceamount) {
		this.invoiceAmount = invoiceamount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// public float getBaseprice() {
	// return basePrice;
	// }

	// public void setBaseprice(float baseprice) {
	// this.basePrice = baseprice;
	// }

	// public float getSellingprice() {
	// return sellingPrice;
	// }

	// public void setSellingprice(float sellingprice) {
	// this.sellingPrice = sellingprice;
	// }
}
