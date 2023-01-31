package com.food.ordering.model;

public class MenuItem  extends Item{
	
	private double price;
	
	public MenuItem(String name,double price)
	{
		super(name);
		this.setPrice(price);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
