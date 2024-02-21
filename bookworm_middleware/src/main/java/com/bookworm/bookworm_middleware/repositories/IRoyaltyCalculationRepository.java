package com.bookworm.bookworm_middleware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.RoyaltyCalculation;

@Repository
public interface IRoyaltyCalculationRepository extends JpaRepository<RoyaltyCalculation, Integer> {
}
