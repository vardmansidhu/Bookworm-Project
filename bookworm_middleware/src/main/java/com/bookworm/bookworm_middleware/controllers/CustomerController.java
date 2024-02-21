package com.bookworm.bookworm_middleware.controllers;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.dtos.CustomerRegistrationDto;
import com.bookworm.bookworm_middleware.dtos.UserDto;
import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.entities.CustomerPreferences;
import com.bookworm.bookworm_middleware.services.ICustomerManager;
import com.bookworm.bookworm_middleware.services.ICustomerPreferencesManager;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	ICustomerManager customerManager;

	@Autowired
	ICustomerPreferencesManager preferencesManager;

	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody UserDto user, HttpSession session) {
		Customer customer = customerManager.authenticate(user.getCustomerEmail(), user.getPassword());
		if (customer != null) {
			session.setAttribute("user", customer.getCustomerId());
			return ResponseEntity.ok(String.valueOf(customer.getCustomerId()));
		} else
			return ResponseEntity.badRequest().body("Invalid Login Credentials");
	}

	@GetMapping("logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("Logout successful");
	}

	@PostMapping("add")
	public void addCustomer(@RequestBody Customer customer) {
		// Customer customer = new Customer();
		// customer.setCustomerEmail(registeredCustomer.getEmail());
		// customer.setPassword(registeredCustomer.getPassword());
		// customer.setCustomerName(registeredCustomer.getName());
		// customer.setContactNo(registeredCustomer.getContactNumber());
		// customer.setDob(registeredCustomer.getDateOfBirth());
		// customer.setTotalPoints(0);
		// customer.setPointsUsed(0);
		// customer.setPointsRemaining(0);
		customerManager.add(customer);

		// List<CustomerPreferences> list = registeredCustomer.getPreferences();
		// Iterator<CustomerPreferences> itr = list.iterator();
		// while(itr.hasNext()) {
		// preferencesManager.saveCustomerPreferences(itr.next());
		// }
	}

	@PutMapping("update/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		customerManager.update(customer, id);
	}

	@DeleteMapping("delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerManager.delete(id);
	}

	@GetMapping("get/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id) {
		return customerManager.getById(id);
	}

	@GetMapping("get")
	public List<Customer> getAllCustomers() {
		return customerManager.getAllCustomers();
	}

	@GetMapping("/exists")
	public boolean getCustomerByEmail(@RequestParam String email) {
		return customerManager.isEmailExists(email);
	}
}
