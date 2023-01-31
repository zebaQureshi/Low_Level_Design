package com.splitwise.model;

import java.util.List;

public class PercentExpense extends Expense {

	public PercentExpense(User paidBy, double amount, List<Split> splits) {
		super(paidBy, amount, splits);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean validate()
	{
		for(Split s:getSplits())
		{
			if(!(s instanceof PercentSplit))
				return false;
		}
		
		double amt=100;
		double totalAmount=0.0;
		for(Split s: getSplits())
		{
			PercentSplit p=(PercentSplit)s;
			totalAmount+=p.getPercent();
		}
		
		if(amt==totalAmount)
			return true;
		else
			return false;
		
		
	}

}
