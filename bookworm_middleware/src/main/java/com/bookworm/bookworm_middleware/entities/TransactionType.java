package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction_type")
public class TransactionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_type_id;
	
	public long getTransaction_type_id() {
		return transaction_type_id;
	}

	public void setTransaction_type_id(long transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}

	public char getTransaction_desc() {
		return transaction_desc;
	}
	

	public void setTransaction_desc(char transaction_desc) {
		this.transaction_desc = transaction_desc;
	}

	@Column(name="transaction_desc")
	private char transaction_desc;
	

}
