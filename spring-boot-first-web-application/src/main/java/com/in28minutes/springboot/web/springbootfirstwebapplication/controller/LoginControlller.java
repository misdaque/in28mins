package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginControlller {
	
	@RequestMapping("/login")
	@ResponseBody
	public String login() {
		return "Hello World!";
	}

}
