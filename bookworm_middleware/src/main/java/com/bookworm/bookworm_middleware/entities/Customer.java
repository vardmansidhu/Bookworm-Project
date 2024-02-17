package com.bookworm.bookworm_middleware.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

//	add server side validation
//	@Column(nullable = false, unique = true)
	private String customerEmail;

//	@Column(nullable = false)
	private String password;
	
//	@Column(nullable = false)
	private String customerName;
	
	private String contactNo;
	private Date dob;
	private int totalPoints;
	private int pointsUsed;
	private int pointsRemaining;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	public int getPointsUsed() {
		return pointsUsed;
	}
	public void setPointsUsed(int pointsUsed) {
		this.pointsUsed = pointsUsed;
	}
	public int getPointsRemaining() {
		return pointsRemaining;
	}
	public void setPointsRemaining(int pointsRemaining) {
		this.pointsRemaining = pointsRemaining;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", password=" + password + ", customerName=" + customerName
				+ ", customerEmail=" + customerEmail + ", contactNo=" + contactNo + ", dob=" + dob + ", totalPoints="
				+ totalPoints + ", pointsUsed=" + pointsUsed + ", pointsRemaining=" + pointsRemaining + "]";
	}
}