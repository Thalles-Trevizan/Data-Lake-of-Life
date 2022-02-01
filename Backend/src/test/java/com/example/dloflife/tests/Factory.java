package com.example.dloflife.tests;

import com.example.dloflife.entities.Role;
import com.example.dloflife.entities.User;

public class Factory {

	public static User createUser() {
		User user = new User(1L, "User X", "userx@gmail.com", "123456");
		return user;
	}

	public static Role createRole() {
		Role role = new Role(1L, "Tester");
		return role;
	}
}
