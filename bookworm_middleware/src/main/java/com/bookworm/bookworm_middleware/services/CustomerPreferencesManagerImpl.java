package com.bookworm.bookworm_middleware.services;

import com.bookworm.bookworm_middleware.entities.CustomerPreferences;
import com.bookworm.bookworm_middleware.repositories.ICustomerPreferencesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPreferencesManagerImpl implements ICustomerPreferencesManager {

    @Autowired
    private ICustomerPreferencesRepository customerPreferencesRepository;

    @Override
    public void saveCustomerPreferences(CustomerPreferences customerPreferences) {
        customerPreferencesRepository.save(customerPreferences);
    }

    @Override
    public CustomerPreferences getCustomerPreferencesById(int custDetailsId) {
        return customerPreferencesRepository.findById(custDetailsId).orElse(null);
    }

    @Override
    public void updateCustomerPreferences(CustomerPreferences customerPreferences) {

        customerPreferencesRepository.save(customerPreferences);
    }
}
