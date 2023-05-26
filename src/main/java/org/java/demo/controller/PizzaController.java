package org.java.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PizzaController {

	
	@GetMapping("/") 
	public String pizzaPlace(Model model) {
		
		return "index";
	}
}
