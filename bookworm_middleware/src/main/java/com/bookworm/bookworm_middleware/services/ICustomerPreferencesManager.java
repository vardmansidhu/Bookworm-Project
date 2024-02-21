package com.bookworm.bookworm_middleware.services;

import com.bookworm.bookworm_middleware.entities.CustomerPreferences;

public interface ICustomerPreferencesManager {

	void saveCustomerPreferences(CustomerPreferences customerPreferences);

	CustomerPreferences getCustomerPreferencesById(int custDetailsId);

	void updateCustomerPreferences(CustomerPreferences customerPreferences);

}
