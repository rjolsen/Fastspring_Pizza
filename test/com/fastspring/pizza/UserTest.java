package com.fastspring.pizza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	String name = "Rick";	
	User usr = new User();
	  
	@Test
	void testGetName() {
		usr.getName();
	}

	@Test
	void testSetName() {
		usr.setName(name);
	}

	@Test
	void testGetAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPhoneNumberFormatted() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCurrentOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCurrentOrder() {
		fail("Not yet implemented");
	}

}
