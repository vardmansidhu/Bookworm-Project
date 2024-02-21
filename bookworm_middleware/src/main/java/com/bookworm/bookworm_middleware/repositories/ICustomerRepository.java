package com.bookworm.bookworm_middleware.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.Customer;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCustomerEmail(String customerEmail);

	@Query(value = "SELECT c.customer_name FROM Customer c WHERE c.customer_id = :id", nativeQuery = true)
	String findCustomerNameById(@Param("id") int id);

	@Modifying
	@Query("UPDATE Customer c SET c.customerName=:name, c.customerEmail=:email, c.contactNo=:contactNo, c.dob=:dob where c.customerId=:id")
	void update(@Param("name") String name, @Param("email") String email, @Param("contactNo") String contactNo,
			@Param("dob") Date dob, @Param("id") int id);

	@Query(value = "SELECT c.customer_id FROM Customer c WHERE c.customer_email = :email", nativeQuery = true)
	int findCustomerIdByEmail(@Param("email") String email);
}