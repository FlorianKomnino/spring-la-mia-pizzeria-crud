package org.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PizzaController {

	@Autowired
	PizzaService pizzaService;
		
	@GetMapping("/") 
	public String pizzaPlace(Model model) {
		
		List<Pizza> foundPizzas = pizzaService.findAll();
		model.addAttribute("pizzasRes", foundPizzas);
		return "index";
	}
	
	@GetMapping("/pizzas/{id}")
	public String findPizzaById(
			Model model,
			@PathVariable("id") int id
			) {
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		model.addAttribute("singlePizza", pizza);
		
		return "singlePizza";
	}
}
