package com.splitwise.model;

import java.util.List;

public class EqualExpense extends Expense{
	
	public EqualExpense(User paidBy, double amount, List<Split> splits) {
		super(paidBy, amount, splits);
		
	}

	public boolean validate()
	{
		for(Split s:getSplits())
		{
			if(!(s instanceof EqualSplit))
				return false;
		}
		return true;
		
	}

}
