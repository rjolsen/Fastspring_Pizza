package com.fastspring.pizza;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class PizzaTest {

	Pizza p = new Pizza();
		
	@Test
	void testPizza() {
		assertEquals(new Pizza(), p);
	}

	@Test
	void testGetPizzas() {
		p.pizzas = new HashMap<String, Double>();
		p.pizzas.put("Cheese", 9.00);
		p.pizzas.put("Pepperoni", 11.50);
		p.pizzas.put("Meat Lovers", 13.25);
		assertEquals(p.pizzas, p.getPizzas());
	}

	@Test
	void testSetPizzas() {
		p.pizzas = new HashMap<String, Double>();
		p.pizzas.put("Cheese", 9.00);
		p.pizzas.put("Pepperoni", 11.50);
		p.pizzas.put("Meat Lovers", 13.25);
		p.setPizzas(p.pizzas);
		assertEquals(p.pizzas, p.getPizzas());
	}

	@Test
	void testGetPizzaList() {
		ArrayList<String> pizzaList = new ArrayList<String>();
		pizzaList.add("Cheese");
		pizzaList.add("Pepperoni");
		pizzaList.add("Meat Lovers");
		assertArrayEquals(pizzaList.toArray(), p.getPizzaList().toArray());
	}

	@Test
	void testGetPizzaSizes() {
		ArrayList<String> pizzaSizes = new ArrayList<String>();
		pizzaSizes.add("Small");
		pizzaSizes.add("Medium + $2");
		pizzaSizes.add("Large + $3");
		assertArrayEquals(pizzaSizes.toArray(), p.getPizzaSizes().toArray());
	}

	@Test
	void testSetPizzaSizes() {
		ArrayList<String> sizes = new ArrayList<String>();
		sizes.add("Small");
		sizes.add("Medium + $2");
		sizes.add("Large + $3");
		p.setPizzaSizes(sizes);
		assertArrayEquals(sizes.toArray(), p.getPizzaSizes().toArray());
	}

	@Test
	void testGetPizzaToppings() {
		ArrayList<String> toppings = new ArrayList<String>();
		toppings.add("Tomatoes");
		toppings.add("Olives");
		toppings.add("Red Peppers");
		toppings.add("Mushrooms");
		toppings.add("Ham");
		toppings.add("Chicken" );
		toppings.add("Pepperoni");
		assertArrayEquals(toppings.toArray(), p.getPizzaToppings().toArray());
	}

//	@Test
//	void testSetPizzaToppings() {
//		ArrayList<String> toppings = new ArrayList<String>();
//		toppings.add("Tomatoes");
//		toppings.add("Olives");
//		toppings.add("Red Peppers");
//		toppings.add("Mushrooms");
//		toppings.add("Ham");
//		toppings.add("Chicken" );
//		toppings.add("Pepperoni");
//		p.setPizzaToppings(toppings);
//		assertArrayEquals(toppings.toArray(), p.getPizzaToppings().toArray());
//	}
}
