package com.uga.bookStore.Exceptions;

public class PaymentCardLimitException extends Exception {
	private static final long serialVersionUID = 1L;

	public PaymentCardLimitException(String message) {
		super(message);
	}
	

}
