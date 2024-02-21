package com.bookworm.bookworm_middleware.dtos;

import java.sql.Date;
import java.util.List;

import com.bookworm.bookworm_middleware.entities.CustomerPreferences;

public class CustomerRegistrationDto {
	private String email;
	private String password;
	private String name;
	private String contactNumber;
	private Date dateOfBirth;
	private List<CustomerPreferences> preferences;
	// private List<String> preferredLanguage;
	// private List<String> preferredGenre;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// public List<String> getPreferredLanguage1() {
	// return preferredLanguage;
	// }
	// public void setPreferredLanguage1(List<String> preferredLanguage) {
	// this.preferredLanguage = preferredLanguage;
	// }
	// public List<String> getPreferredGenre() {
	// return preferredGenre;
	// }
	// public void setPreferredGenre1(List<String> preferredGenre) {
	// this.preferredGenre = preferredGenre;
	// }
	public List<CustomerPreferences> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<CustomerPreferences> preferences) {
		this.preferences = preferences;
	}
}
