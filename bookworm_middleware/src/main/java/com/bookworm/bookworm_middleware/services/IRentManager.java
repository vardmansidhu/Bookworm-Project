package com.bookworm.bookworm_middleware.services;

import java.util.List;

import com.bookworm.bookworm_middleware.entities.Rent;

public interface IRentManager {
    List<Rent> getAllRents();
    Rent getRentById(int rentId);
    void addRent(Rent rent);
}
