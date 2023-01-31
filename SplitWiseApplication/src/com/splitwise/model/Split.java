package com.splitwise.model;

public abstract class Split {

	private User user;
	private double amount;

	public User getUser() {
		return user;
	}

	public double getAmount() {
		return amount;
	}

	

	public Split(User u) {
		this.user = u;

	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
