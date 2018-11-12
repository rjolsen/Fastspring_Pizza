package com.fastspring.pizza;

import java.util.HashMap;

public class PendingOrders {
	
	private static HashMap<Integer, User> orders = new HashMap<Integer, User>();
	private static int NumOrders = 0;
	
	public static int getNumOrders() {
		return NumOrders;
	}
	
	public static void incNumOrders() {
		NumOrders++;
	}
	
	public static void decNumOrders() {
		NumOrders--;
	}
	
	public static HashMap<Integer,User> getOrders() {
		return orders;
	}
	
	public static void insertOrder(int orderid, User user) {
		orders.put(orderid, user);
	}
	
	public static User getOrder(int orderid) {
		return orders.get(orderid);
	}
	
	public static boolean changeOrder(int orderid) {
		if (getOrder(orderid) != null) {
			int state = orders.get(orderid).currentOrder.getState();
			orders.get(orderid).currentOrder.setState(++state);
			
			// If order completed,remove it
			if (state > 5)
				orders.remove(orderid);
			return true;
		}
		return false;
	}
}