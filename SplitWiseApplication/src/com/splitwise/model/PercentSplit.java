package com.splitwise.model;

public class PercentSplit extends Split{
	private double percent;
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	PercentSplit(User user, double percent)
	{
		super(user);
		this.percent=percent;
		
	}
	
	

}
