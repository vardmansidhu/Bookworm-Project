package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.Customer;

public interface ICustomerManager {

	void add(Customer customer);

	void update(Customer customer, int id);

	void delete(int id);

	Optional<Customer> getById(int id);

	List<Customer> getAllCustomers();

	String getCustomerNameById(int id);

	Customer authenticate(String email, String password);

	boolean isEmailExists(String email);
}
