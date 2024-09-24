package com.uga.bookStore.model;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotBlank
	private String password;
	
}
