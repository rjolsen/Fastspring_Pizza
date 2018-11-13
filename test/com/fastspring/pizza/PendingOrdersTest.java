package com.fastspring.pizza;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class PendingOrdersTest {

	User user = new User();
	
	@Test
	void testGetNumOrders() {
		assertEquals(0, PendingOrders.getNumOrders());
	}

	@Test
	void testIncNumOrders() {
		PendingOrders.incNumOrders();
		assertEquals(1, PendingOrders.getNumOrders());
	}

	@Test
	void testDecNumOrders() {
		PendingOrders.decNumOrders();
		assertEquals(0, PendingOrders.getNumOrders());
	}

	@Test
	void testGetOrders() {
		HashMap<Integer, User> orders = PendingOrders.getOrders();
		assertEquals(orders, PendingOrders.getOrders());
	}

	@Test
	void testInsertOrder() {
		user.name = "Tom";
		user.phoneNumber = 1231234;
		user.address = "123 W 7th";
		Order order = new Order();
		order.orderId = 0;
		order.state = 1;
		user.setCurrentOrder(order);
		PendingOrders.insertOrder(0, user);
		assertEquals(PendingOrders.getOrder(0), user);
	}

	@Test
	void testGetOrder() {
		user.name = "Joe";
		user.phoneNumber = 2225544;
		user.address = "334 57th Place N";
		PendingOrders.insertOrder(1, user);
		assertEquals(user, PendingOrders.getOrder(1));
	}

	@Test
	void testChangeOrder() {
		user.name = "Tom";
		user.phoneNumber = 1231234;
		user.address = "123 W 7th";
		Order order = new Order();
		order.orderId = 0;
		order.state = 1;
		user.setCurrentOrder(order);
		PendingOrders.insertOrder(0, user);
		assertTrue(PendingOrders.changeOrder(0));
	}

}
