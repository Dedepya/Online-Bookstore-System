package com.uga.bookStore.model;

import lombok.Data;

@Data
public class Response {
	private String message;
	private Boolean status;
	private Integer otp;

}
