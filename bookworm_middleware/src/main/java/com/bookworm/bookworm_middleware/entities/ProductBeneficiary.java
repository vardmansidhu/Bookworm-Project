package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_beneficiary")
public class ProductBeneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_ben_id")
	private int prodBenId;

	@ManyToOne
	@JoinColumn(name = "ben_id")
	private Beneficiary benId;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productId;

	@Column(name = "percentage")
	private Double percentage;

	public int getProdBenId() {
		return prodBenId;
	}

	public void setProdBenId(int prodBenId) {
		this.prodBenId = prodBenId;
	}

	public Beneficiary getBenId() {
		return benId;
	}

	public void setBenId(Beneficiary benId) {
		this.benId = benId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "ProductBeneficiary [prodBenId=" + prodBenId + ", benId=" + benId + ", productId=" + productId
				+ ", percentage=" + percentage + "]";
	}

}
