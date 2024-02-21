package com.bookworm.bookworm_middleware.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.CustomerAttribute;
import com.bookworm.bookworm_middleware.repositories.ICustomerAttributeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAttributeManagerImpl implements ICustomerAttributesManager {

	private ICustomerAttributeRepository repository;

	@Override
	public void saveCustomerAttribute(CustomerAttribute customerAttribute) {

		repository.save(customerAttribute);
	}

	@Override
	public Optional<CustomerAttribute> getCustomerAttributeById(int custAttId) {

		return repository.findById(custAttId);
	}

	@Override
	public List<CustomerAttribute> getAllCustomerAttributes() {

		return repository.findAll();
	}

	// @Override
	// public void updateCustomerAttribute(CustomerAttribute customerAttribute) {
	//
	// Optional<CustomerAttribute> existingAttribute =
	// repository.findById(customerAttribute.getCustAttId());
	// if (existingAttribute.isPresent()) {
	//
	// repository.save(customerAttribute);
	// } else {
	// return;
	// }
	// }

	@Override
	public void deleteCustomerAttribute(int custAttId) {
		repository.deleteById(custAttId);

	}
}
