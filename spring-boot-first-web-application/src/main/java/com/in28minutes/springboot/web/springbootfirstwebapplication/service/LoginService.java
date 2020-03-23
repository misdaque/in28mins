package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean isValidUser(String userId, String password) {

		return userId.equals("Aman") && password.equals("password");
	}

}
