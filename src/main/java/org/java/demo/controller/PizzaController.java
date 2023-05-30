package org.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/pizzas/search")
	public String getBookByTitle(Model model, @RequestParam(required = false) String name) {
		
		List<Pizza> foundPizzas = pizzaService.findByName(name);
		model.addAttribute("pizzasRes", foundPizzas);
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/pizzas/create")
	public String createPizza() {
		
		return "pizza-create";
	}
	
	@PostMapping("/pizzas/create")
	public String storeBook(@ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizzas/delete/{id}")
	public String deletePizza(
			@PathVariable int id
		) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		Pizza selectedPizza = pizzaOpt.get();
		pizzaService.deletePizza(selectedPizza);
		
		return "redirect:/";
	}
}
