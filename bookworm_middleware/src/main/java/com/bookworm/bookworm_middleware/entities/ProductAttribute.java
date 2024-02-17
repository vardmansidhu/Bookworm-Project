package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductAttribute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attribute_id")
	private int attributeId;

	@Column(name = "attribute_desc")
	private String attributeDesc;

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttribute_desc() {
		return attributeDesc;
	}

	public void setAttribute_desc(String attributeDesc) {
		this.attributeDesc = attributeDesc;
	}

	@Override
	public String toString() {
		return "ProductAttribute [attributeId=" + attributeId + ", attributeDesc=" + attributeDesc + "]";
	}

}
