package com.uga.bookStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.uga.bookStore.utils.Encrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@Entity
@Table(name="payment_cards")
public class PaymentCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Payment_Id")
	private Integer paymentId;
	private String cardType;
	private String cardHolder;
	@Convert(converter = Encrypt.class)
	private String cardNumber;
	private String expDate;
	

	public PaymentCard() {

	}

	public PaymentCard(String cardType, String cardNumber, String expDate, String cardHolder) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cardHolder = cardHolder;
	}


	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "User_Id")
	private User user;


	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}