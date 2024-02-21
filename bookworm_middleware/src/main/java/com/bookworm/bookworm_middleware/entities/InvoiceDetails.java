package com.bookworm.bookworm_middleware.entities;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_dtl_id")
	private int invDtlId;

	// @ManyToOne
	// @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
	@Column(name = "invoice_id")
	private int invoiceId;

	// @ManyToOne
	// @JoinColumn(name = "product_id", referencedColumnName = "product_id")
	@Column(name = "product_id")
	private int productId;

	// @Column(name = "quantity")
	// private int quantity;

	@Column(name = "base_price")
	private double basePrice;

	@Column(name = "selling_price")
	private double sellingPrice;

	// @ManyToOne
	@JoinColumn(name = "transaction_type_id", referencedColumnName = "transaction_type_id")
	@Column(name = "transaction_Id")
	private Integer transactionTypeId;

	@Column(name = "renting_days")
	private Integer rentingDays;

	public int getInvDtlId() {
		return invDtlId;
	}

	public void setInvDtlId(int invDtlId) {
		this.invDtlId = invDtlId;
	}

	public int getInvoice() {
		return invoiceId;
	}

	public void setInvoice(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getProduct() {
		return productId;
	}

	public void setProduct(int productId) {
		this.productId = productId;
	}

	// public int getQuantity() {
	// return quantity;
	// }
	//
	// public void setQuantity(int quantity) {
	// this.quantity = quantity;
	// }

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getTransactionType() {
		return transactionTypeId;
	}

	public void setTransactionType(Integer transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public Integer getRentingDays() {
		return rentingDays;
	}

	public void setRentingDays(Integer rentingDays) {
		this.rentingDays = rentingDays;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [basePrice=" + basePrice + ", invDtlId=" + invDtlId + ", invoice=" + invoiceId
				+ ", product=" + productId + /* ", quantity=" + quantity + */ ", rentingDays=" + rentingDays
				+ ", sellingPrice="
				+ sellingPrice + ", transactionType=" + transactionTypeId + "]";
	}

}
