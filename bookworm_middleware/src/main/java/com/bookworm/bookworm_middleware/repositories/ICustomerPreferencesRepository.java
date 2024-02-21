package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.Customer;
import com.bookworm.bookworm_middleware.entities.CustomerPreferences;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ICustomerPreferencesRepository extends JpaRepository<CustomerPreferences, Integer> {

	Customer getCustomerPreferencesByCustDetailsId(int custDetails);

	@Modifying
	@Query("UPDATE CustomerPreferences c SET c.attributeValue = :attributeValue WHERE c.custDetailsId = :custDetailsId AND c.customer = :customer")
	void updateCustomerPreferences(@Param("attributeValue") String attributeValue,
			@Param("custDetailsId") int custDetails, @Param("customer") int customer);

}
