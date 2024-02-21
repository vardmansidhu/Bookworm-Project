package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.repositories.ICustomerRepository;

@Service
public class CustomerManagerImpl implements ICustomerManager {

	@Autowired
	ICustomerRepository repository;

	@Override
	public void add(Customer customer) {
		repository.save(customer);
	}

	@Override
	public void update(Customer customer, int id) {
		repository.update(customer.getCustomerName(), customer.getCustomerEmail(), customer.getContactNo(),
				customer.getDob(), id);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Customer> getById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@Override
	public String getCustomerNameById(int id) {
		return repository.findCustomerNameById(id);
	}

	@Override
	public Customer authenticate(String email, String password) {
		Customer customer = repository.findByCustomerEmail(email);
		if (customer != null && customer.getPassword().equals(password))
			return customer;
		else
			return null;
	}

	@Override
	public boolean isEmailExists(String email) {
		Customer customer = repository.findByCustomerEmail(email);
		if (customer != null)
			return true;
		else
			return false;
	}

}
