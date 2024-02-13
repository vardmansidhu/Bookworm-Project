package com.bookworm.bookworm_middleware.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.Rent;
import com.bookworm.bookworm_middleware.repositories.IRentRepository;

@Service
public class RentManagerImpl implements IRentManager{

    @Autowired
    private IRentRepository rentRepository;

    @Override
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getRentById(int rentId) {
        return rentRepository.findById(rentId).orElse(null);
    }

    @Override
    public void addRent(Rent rent) {
        rentRepository.save(rent);
    }
    
}
