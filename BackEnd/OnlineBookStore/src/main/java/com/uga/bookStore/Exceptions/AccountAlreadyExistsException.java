package com.uga.bookStore.Exceptions;

public class AccountAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	@Override
    public String toString() {
        return "AccountAlreadyExistsException: " + getMessage();
    }
}
