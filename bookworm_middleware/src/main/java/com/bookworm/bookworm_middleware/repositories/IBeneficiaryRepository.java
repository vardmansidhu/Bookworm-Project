package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.Beneficiary;

import jakarta.transaction.Transactional;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE Beneficiary b SET b.amount = :amount WHERE b.benId = :benId", nativeQuery = true)
	void updateAmount(@Param("benId") Integer benId, @Param("amount") Double amount);

}
