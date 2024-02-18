package com.bookworm.bookworm_middleware.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.dtos.UserDto;
import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.services.ICustomerManager;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	ICustomerManager manager;

	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody UserDto user, HttpSession session) {
		Customer customer = manager.authenticate(user.getCustomerEmail(), user.getPassword());
		if (customer != null) {
			session.setAttribute("user", customer);
			return ResponseEntity.ok(String.valueOf(customer.getCustomerId()));
		} else
			return ResponseEntity.badRequest().body("Invalid Login Credentials");
	}

	@PostMapping("logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("Logout successful");
	}

	@PostMapping("add")
	public void addCustomer(@RequestBody Customer customer) {
		manager.add(customer);
	}

	@PutMapping("update/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		manager.update(customer, id);
	}

	@DeleteMapping("delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		manager.delete(id);
	}

	@GetMapping("get/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id) {
		return manager.getById(id);
	}

	@GetMapping("get")
	public List<Customer> getAllCustomers() {
		return manager.getAllCustomers();
	}

}
