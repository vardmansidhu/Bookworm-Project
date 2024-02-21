package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.sql.Date;

@Entity
public class RoyaltyCalculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roycal_id")
	private int roycalId;

	@Column(name = "Invoice_Id")
	private int invoiceId;

	// @OneToOne
	@Column(name = "Ben_Id")
	// @PrimaryKeyJoinColumn
	private int benId;

	@Column(name = "roycal_trandate")
	private Date roycalTrandate;

	// @ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "product_id")
	private int prodId;

	// @Column(name = "Qty")
	// private int qty;

	@Column(name = "trantype")
	private int trantype;

	@Column(name = "saleprice")
	private double saleprice;

	@Column(name = "baseprice")
	private double baseprice;

	@Column(name = "RoyaltyOnBasePrice")
	private double royaltyOnBasePrice;

	public int getRoycalId() {
		return roycalId;
	}

	public void setRoycalId(int roycalId) {
		this.roycalId = roycalId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int savedInvoice) {
		this.invoiceId = savedInvoice;
	}

	public int getBenId() {
		return benId;
	}

	public void setBenId(int benId) {
		this.benId = benId;
	}

	public Date getRoycalTrandate() {
		return roycalTrandate;
	}

	public void setRoycalTrandate(Date roycalTrandate) {
		this.roycalTrandate = roycalTrandate;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	// public int getQty() {
	// return qty;
	// }
	//
	//
	// public void setQty(int qty) {
	// this.qty = qty;
	// }

	public int getTrantype() {
		return trantype;
	}

	public void setTrantype(int trantype) {
		this.trantype = trantype;
	}

	public double getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}

	public double getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}

	public double getRoyaltyOnBasePrice() {
		return royaltyOnBasePrice;
	}

	public void setRoyaltyOnBasePrice(double royaltyOnBasePrice) {
		this.royaltyOnBasePrice = royaltyOnBasePrice;
	}

	@Override
	public String toString() {
		return "RoyaltyCalculation [roycalId=" + roycalId + ", invoice=" + invoiceId + ", beneficiary=" + benId
				+ ", roycalTrandate=" + roycalTrandate + ", product=" + prodId + ", tranType="
				+ trantype + ", salePrice=" + saleprice + ", basePrice=" + baseprice + ", royaltyOnBasePrice="
				+ royaltyOnBasePrice + "]";
	}

}