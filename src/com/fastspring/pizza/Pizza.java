package com.fastspring.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Pizza {

	Map<String, Double> pizzas;
	ArrayList<String> pizzaSizes;

	static ArrayList<String> pizzaToppings;
	static {
		pizzaToppings = new ArrayList<String>();
		pizzaToppings.add("Tomatoes");
		pizzaToppings.add("Olives");
		pizzaToppings.add("Red Peppers");
		pizzaToppings.add("Mushrooms");
		pizzaToppings.add("Ham");
		pizzaToppings.add("Chicken" );
		pizzaToppings.add("Pepperoni");
	}
	
	public Pizza()
	{
		pizzas = new HashMap<String, Double>();
		pizzas.put("Cheese", 9.00);
		pizzas.put("Pepperoni", 11.50);
		pizzas.put("Meat Lovers", 13.25);
		
		pizzaSizes = new ArrayList<String>();
		pizzaSizes.add("Small");
		pizzaSizes.add("Medium + $2");
		pizzaSizes.add("Large + $3");
	}
	
	public Map<String, Double> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Map<String, Double> pizzas) {
		this.pizzas = pizzas;
	}

	public ArrayList<String> getPizzaList() {
		ArrayList<String> pizzaList = new ArrayList<String>();
		Set<String> pizzaKeys = this.pizzas.keySet();
		for (String pizza : pizzaKeys)
			pizzaList.add(pizza);
		return pizzaList;
	}
	
	public ArrayList<String> getPizzaSizes() {
		return pizzaSizes;
	}
	
	public void setPizzaSizes(ArrayList<String> pizzaSizes) {
		this.pizzaSizes = pizzaSizes;
	}
	
	public static ArrayList<String> getPizzaToppings() {
		return pizzaToppings;
	}
	
	public static void removePizzaTopings(String topping) {
		if (topping != null && !topping.isEmpty()) {
			if (Pizza.pizzaToppings.contains(topping)) {
				int i = Pizza.pizzaToppings.indexOf(topping);
				Pizza.pizzaToppings.remove(i);
			}
		}
	}
	
	public static void addPizzaToppings(String topping) {
		if (topping != null && !topping.isEmpty()) {
			Pizza.pizzaToppings.add(topping);
		}
	}
}
