package com.uga.bookStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="account_status")
public class AccountStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountStatusId;



	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AccountStatusEnum accountStatus;

	public AccountStatus() {

	}

	public AccountStatus(AccountStatusEnum accountStatus) {
		super();
		this.accountStatus = accountStatus;

	}
}
