package com.bookworm.bookworm_middleware.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.RoyaltyCalculation;
import com.bookworm.bookworm_middleware.repositories.IRoyaltyCalculationRepository;

@Service
public class RoyaltyCalculationManagerImpl {

    @Autowired
    private IRoyaltyCalculationRepository repository;

    public List<RoyaltyCalculation> getAll() {
        return repository.findAll();
    }

    public RoyaltyCalculation getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public RoyaltyCalculation create(RoyaltyCalculation royaltyCalculation) {
        return repository.save(royaltyCalculation);
    }

    public RoyaltyCalculation update(RoyaltyCalculation royaltyCalculation) {
        return repository.save(royaltyCalculation);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}