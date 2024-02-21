package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.CustomerAttribute;

public interface ICustomerAttributesManager {
	public void saveCustomerAttribute(CustomerAttribute customerAttribute);

	public Optional<CustomerAttribute> getCustomerAttributeById(int custAttId);

	public List<CustomerAttribute> getAllCustomerAttributes();

	// public void updateCustomerAttribute(CustomerAttribute customerAttribute);

	public void deleteCustomerAttribute(int custAttId);

}
