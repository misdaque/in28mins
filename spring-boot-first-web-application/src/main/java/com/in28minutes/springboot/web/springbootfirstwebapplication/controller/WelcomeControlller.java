package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeControlller {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUser());		
		return "welcome";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcomePage() {
		return "welcome";
	}
	
	
	private String getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
//
//		if (!service.isValidUser(name, password)) {
//			model.put("errorMessage", "Invalid Credentials");
//			return "login";
//		}
//
//		model.put("name", name);
//		model.put("password", password);
//		return "welcome";
//	}

}
