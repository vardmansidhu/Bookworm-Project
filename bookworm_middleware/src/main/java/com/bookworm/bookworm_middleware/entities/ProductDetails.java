package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_att_id")
	private int prodAttId;

	@OneToOne
	@JoinColumn(name = "attribute_id")
	private ProductAttribute attributeId;
    //
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product productId;

	@Column(name = "attribute_value")
	private String attributeValue;

	public int getProdAttId() {
		return prodAttId;
	}

	public void setProdAttId(int prodAttId) {
		this.prodAttId = prodAttId;
	}

	public ProductAttribute getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(ProductAttribute attributeId) {
		this.attributeId = attributeId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public String toString() {
		return "ProductDetails [prodAttId=" + prodAttId + ", attributeId=" + attributeId + ", productId=" + productId
				+ ", attributeValue=" + attributeValue + "]";
	}

	
}
