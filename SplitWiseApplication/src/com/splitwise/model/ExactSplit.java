package com.splitwise.model;

public class ExactSplit extends Split{
	private double amount;
	
	ExactSplit(User user, double amount)
	{
		super(user);
		this.amount=amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
