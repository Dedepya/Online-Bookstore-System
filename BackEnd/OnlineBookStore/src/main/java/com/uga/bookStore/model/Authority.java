package com.uga.bookStore.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4009496760316773783L;
	
	private String userType;
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Authority(String userType) {
		super();
		this.userType = userType;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return userType;
	}

}
