package com.bookworm.bookworm_middleware.dtos;

public class UserDto {
	private String customerEmail;
	private String password;

	public UserDto(String customerEmail, String password) {
		super();
		this.customerEmail = customerEmail;
		this.password = password;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
