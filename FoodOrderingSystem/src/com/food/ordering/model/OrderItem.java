package com.food.ordering.model;

public class OrderItem extends Item{

	private int quantity;
	private double price;
	
	public OrderItem(String name, int quantity)
	{
		super(name);
		this.quantity=quantity;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
