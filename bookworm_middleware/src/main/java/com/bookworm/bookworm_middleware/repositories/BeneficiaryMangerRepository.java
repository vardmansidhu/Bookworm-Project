package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.Beneficiary;

import jakarta.transaction.Transactional;
@Repository
public interface BeneficiaryMangerRepository extends JpaRepository<Beneficiary,Integer> {

}
