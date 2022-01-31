package com.example.dloflife.dto;

import java.io.Serializable;

import com.example.dloflife.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String password;

	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
