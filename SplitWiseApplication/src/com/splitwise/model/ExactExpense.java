package com.splitwise.model;

import java.util.List;

public class ExactExpense extends Expense {

	public ExactExpense(User paidBy, double amount, List<Split> splits) {
		super(paidBy, amount, splits);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean validate()
	{
		for(Split s:getSplits())
		{
			if(!(s instanceof ExactSplit))
				return false;
		}
		
		double amt=getAmount();
		double totalAmount=0.0;
		for(Split s: getSplits())
		{
			totalAmount+=s.getAmount();
		}
		
		if(amt==totalAmount)
			return true;
		else
			return false;
		
		
	}

}
