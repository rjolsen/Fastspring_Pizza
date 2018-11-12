package com.fastspring.pizza;

public class User {
	
	String name, address;
	long phoneNumber;
	Order currentOrder;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getPhoneNumberFormatted() {
		String num = String.valueOf(this.getPhoneNumber());
		return num.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
}