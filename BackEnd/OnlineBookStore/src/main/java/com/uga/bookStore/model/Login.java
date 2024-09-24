package com.uga.bookStore.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Login {
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
}
