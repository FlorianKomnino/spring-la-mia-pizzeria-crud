package org.java.demo;

import java.util.List;

import org.java.demo.pojo.Pizza;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaPlaceApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaPlaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Universe!");
		Pizza p = new Pizza("Margherita", "La tipica pizza della regina" , "immagine", 750);
		System.out.println(p);
		
		pizzaService.save(p);
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		System.out.println(pizzas);
	}

}
