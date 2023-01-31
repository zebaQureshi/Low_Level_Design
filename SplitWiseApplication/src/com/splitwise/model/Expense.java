package com.splitwise.model;

import java.util.List;

public abstract class Expense {
	
	
	private String id;
	private double amount;
	private User paidBy;
	List<Split> splits;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}
	public List<Split> getSplits() {
		return splits;
	}
	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}
	
	public Expense(User paidBy, double amount, List<Split> splits)
	{
		this.paidBy=paidBy;
		this.amount=amount;
		this.splits=splits;
		
	}
	
	public abstract boolean validate();
	
	

}
