package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.TodoService;

@Controller
public class TodoControlller {

	@Autowired
	TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLooginPage(ModelMap model) {
		model.put("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}

}
