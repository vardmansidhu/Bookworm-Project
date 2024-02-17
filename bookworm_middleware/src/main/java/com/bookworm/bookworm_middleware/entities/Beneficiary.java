package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {

//	public Beneficiary(int benId, String benName, String email, String contact, String bankName, String bankBranch,
//			String iFSC, long accNo, String accType, String pAN) {
//		super();
//		this.benId = benId;
//		this.benName = benName;
//		this.email = email;
//		this.contact = contact;
//		this.bankName = bankName;
//		this.bankBranch = bankBranch;
//		IFSC = iFSC;
//		this.accNo = accNo;
//		this.accType = accType;
//		PAN = pAN;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ben_id")
	private int benId;

	@Column(name = "ben_name")
	private String benName;

	@Column(name = "email")
	private String email;

	@Column(name = "contact")
	private String contact;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_branch")
	private String bankBranch;

	@Column(name = "ifsc")
	private String IFSC;

	@Column(name = "acc_No")
	private String accNo;

	@Column(name = "acc_type")
	private String accType;

	@Column(name = "pan")
	private String PAN;

	public int getBenId() {
		return benId;
	}

	public void setBenId(int benId) {
		this.benId = benId;
	}

	public String getBenName() {
		return benName;
	}

	public void setBenName(String benName) {
		this.benName = benName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	@Override
	public String toString() {
		return "Beneficiary [benId=" + benId + ", benName=" + benName + ", email=" + email + ", contact=" + contact
				+ ", bankName=" + bankName + ", bankBranch=" + bankBranch + ", IFSC=" + IFSC + ", accNo=" + accNo
				+ ", accType=" + accType + ", PAN=" + PAN + "]";
	}

}
