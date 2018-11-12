package com.fastspring.pizza;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OrderTest {
	Order ord = new Order();
	
	@Test
	void testGetOrderId() {
		ord.orderId = 1;
		assertEquals(1, ord.getOrderId());
	}

	@Test
	void testSetOrderId() {
		ord.setOrderId(3);
		assertEquals(3, ord.getOrderId());
	}
	
	@Test
	void testGetState() {
		ord.state = 3;
		assertEquals(3, ord.getState());
	}

	@Test
	void testSetState() {
		ord.setState(4);
		assertEquals(4, ord.getState());
	}

	@Test
	void testGetTotalPrice() {
		ord.totalPrice = 23.50;
		assertEquals(23.50, ord.getTotalPrice());
	}

	@Test
	void testSetTotalPrice() {
		ord.setTotalPrice(26.00);
		assertEquals(26.00, ord.getTotalPrice());
	}

	@Test
	void testGetPizzas() {
		ord.pizzas = new ArrayList<String>();
		ord.pizzas.add("Cheese");
		ord.pizzas.add("Pepperoni");
		ord.pizzas.add("Meat");
		assertArrayEquals(ord.pizzas.toArray(), ord.getPizzas().toArray());
	}

	@Test
	void testSetPizzas() {
		ord.pizzas = new ArrayList<String>();
		ord.pizzas.add("Cheese");
		ord.pizzas.add("Pepperoni");
		ord.pizzas.add("Meat");
		ord.setPizzas(ord.pizzas);
		assertArrayEquals(ord.pizzas.toArray(), ord.getPizzas().toArray());
	}

	@Test
	void testGetSizes() {
		ord.sizes = new ArrayList<String>();
		ord.sizes.add("Small");
		ord.sizes.add("Medium + $2");
		ord.sizes.add("Large + $3");
		assertArrayEquals(ord.sizes.toArray(), ord.getSizes().toArray());
	}

	@Test
	void testSetSizes() {
		ord.sizes = new ArrayList<String>();
		ord.sizes.add("Small");
		ord.sizes.add("Medium + $2");
		ord.sizes.add("Large + $3");
		ord.setSizes(ord.sizes);
		assertArrayEquals(ord.sizes.toArray(), ord.getSizes().toArray());
	}

	@Test
	void testGetQuantities() {
		ord.quantities = new ArrayList<Integer>();
		ord.quantities.add(1);
		ord.quantities.add(2);
		ord.quantities.add(3);
		assertArrayEquals(ord.quantities.toArray(), ord.getQuantities().toArray());
	}

	@Test
	void testSetQuantities() {
		ord.quantities = new ArrayList<Integer>();
		ord.quantities.add(1);
		ord.quantities.add(2);
		ord.quantities.add(3);
		ord.setQuantities(ord.quantities);
		assertArrayEquals(ord.quantities.toArray(), ord.getQuantities().toArray());
	}

	@Test
	void testGetToppings() {
		ord.toppings = new ArrayList<String>();
		ord.toppings.add("Tomatoes");
		ord.toppings.add("Olives");
		ord.toppings.add("Red Peppers");
		ord.toppings.add("Mushrooms");
		ord.toppings.add("Ham");
		ord.toppings.add("Chicken" );
		ord.toppings.add("Pepperoni");
		assertArrayEquals(ord.toppings.toArray(), ord.getToppings().toArray());
	}

	@Test
	void testSetToppings() {
		ord.toppings = new ArrayList<String>();
		ord.toppings.add("Tomatoes");
		ord.toppings.add("Olives");
		ord.toppings.add("Red Peppers");
		ord.toppings.add("Mushrooms");
		ord.toppings.add("Ham");
		ord.toppings.add("Chicken" );
		ord.toppings.add("Pepperoni");
		ord.setToppings(ord.toppings);
		assertArrayEquals(ord.toppings.toArray(), ord.getToppings().toArray());
	}
}
