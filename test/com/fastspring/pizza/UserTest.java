package com.fastspring.pizza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	User usr = new User();
	  
	@Test
	void testGetName() {
		usr.name = "Tom";
		assertEquals("Tom", usr.getName());
	}

	@Test
	void testSetName() {
		usr.setName("Joe");
		assertEquals("Joe", usr.getName());
	}

	@Test
	void testGetAddress() {
		usr.address = "111 Spring Dr.";
		assertEquals("111 Spring Dr.", usr.getAddress());
	}

	@Test
	void testSetAddress() {
		usr.setAddress("3423 Test Ave");
		assertEquals("3423 Test Ave", usr.getAddress());
	}

	@Test
	void testGetPhoneNumber() {
		usr.phoneNumber = 1112234;
		assertEquals(1112234, usr.getPhoneNumber());
	}

	@Test
	void testGetPhoneNumberFormatted() {
		usr.phoneNumber = 6023987;
		assertEquals("602-3987", usr.getPhoneNumberFormatted());
	}

	@Test
	void testSetPhoneNumber() {
		usr.setPhoneNumber(2023344);
		assertEquals(2023344, usr.getPhoneNumber());
	}

	@Test
	void testGetCurrentOrder() {
		usr.currentOrder = new Order();
		assertEquals(usr.currentOrder, usr.getCurrentOrder());
	}

	@Test
	void testSetCurrentOrder() {
		usr.setCurrentOrder(new Order());
		assertEquals(usr.currentOrder, usr.getCurrentOrder());
	}

}
