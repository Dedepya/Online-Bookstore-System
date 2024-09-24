package com.uga.bookStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account_type")
public class AccountType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Account_Type_Id")
	private Integer accountTypeId;

	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AccountTypeEnum accountType;

	public AccountType() {

	}

	public AccountType(AccountTypeEnum accountType) {
		super();
		this.accountType = accountType;

	}
}
