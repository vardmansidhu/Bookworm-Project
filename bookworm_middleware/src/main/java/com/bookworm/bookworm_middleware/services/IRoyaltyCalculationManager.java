package com.bookworm.bookworm_middleware.services;

import java.util.List;

import com.bookworm.bookworm_middleware.entities.RoyaltyCalculation;

public interface IRoyaltyCalculationManager {
	List<RoyaltyCalculation> getAll();

	RoyaltyCalculation getById(int id);

	RoyaltyCalculation create(RoyaltyCalculation royaltyCalculation);

	RoyaltyCalculation update(RoyaltyCalculation royaltyCalculation);

	void delete(int id);
}
