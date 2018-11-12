package com.fastspring.pizza;

import java.util.ArrayList;

public class Order {
	int orderId;
	int state;
	double totalPrice;
	
	ArrayList<String> pizzas; 
	ArrayList<String> sizes;
	ArrayList<Integer> quantities;
	ArrayList<String> toppings;
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public ArrayList<String> getPizzas() {
		return pizzas;
	}
	
	public void setPizzas(ArrayList<String> pizzas) {
		this.pizzas = pizzas;
	}
	
	public ArrayList<String> getSizes() {
		return sizes;
	}
	
	public void setSizes(ArrayList<String> sizes) {
		this.sizes = sizes;
	}
	
	public ArrayList<Integer> getQuantities() {
		return quantities;
	}
	
	public void setQuantities(ArrayList<Integer> quantities) {
		this.quantities = quantities;
	}
	
	public ArrayList<String> getToppings() {
		return toppings;
	}
	
	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}
}
