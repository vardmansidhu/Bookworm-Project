package com.bookworm.bookworm_middleware.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerPreferences {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custDetailsId;

	@ManyToOne
	private CustomerAttribute custAtt;

	@ManyToOne
	private Customer customer;

	private String attributeValue;

	public int getCustDetailsId() {
		return custDetailsId;
	}

	public void setCustDetailsId(int custDetailsId) {
		this.custDetailsId = custDetailsId;
	}

	public CustomerAttribute getCustAtt() {
		return custAtt;
	}

	public void setCustAtt(CustomerAttribute custAtt) {
		this.custAtt = custAtt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public String toString() {
		return "CustomerPreferences{" +
				"custDetailsId=" + custDetailsId +
				", custAttId=" + custAtt +
				", customerId=" + customer +
				", attributeValue='" + attributeValue + '\'' +
				'}';
	}
}