package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayController {
		
		@RequestMapping("/play")
		public String play(@RequestParam String lol, ModelMap model) {
			model.put("lol", lol);
			return "Playo";
		}
}
