package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.TodoService;

@Controller
public class TodoControlller {

	@Autowired
	TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodoList(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "", new Date(), false));
		return "todo";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);

		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		service.addTodo(getLoggedInUserName(model), todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);

		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		service.updateTodo(todo);
		model.put("todo", todo);

		return "redirect:/list-todos";
	}
}
