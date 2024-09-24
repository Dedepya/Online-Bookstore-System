package com.uga.bookStore.model;
import java.util.List;
import java.lang.String;
import java.lang.Integer;

public class JwtResponse {
	private String token;
	private String type = "Bearer";

	public JwtResponse(String token, Integer id, String firstName, String lastName, String username, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.roles = roles;
	}

	private Integer id;

	private String firstName;

	private String lastName;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	private String username;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	private List<String> roles;

}
