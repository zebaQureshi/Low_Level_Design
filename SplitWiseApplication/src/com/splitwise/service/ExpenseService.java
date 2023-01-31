package com.splitwise.service;

import java.util.List;

import com.splitwise.model.EqualExpense;
import com.splitwise.model.EqualSplit;
import com.splitwise.model.ExactExpense;
import com.splitwise.model.Expense;
import com.splitwise.model.ExpenseType;
import com.splitwise.model.PercentExpense;
import com.splitwise.model.PercentSplit;
import com.splitwise.model.Split;
import com.splitwise.model.User;

public class ExpenseService {

	public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits) {
		switch (expenseType) {
		case EXACT:
			return new ExactExpense(paidBy, amount, splits);

		case PERCENT: {
			for (Split s : splits) {
				PercentSplit p = (PercentSplit) s;
				s.setAmount((amount * p.getPercent()) / 100.0);
			}
		}
			return new PercentExpense(paidBy, amount, splits);

		case EQUAL:
			int totalSplits = splits.size();
			double splitAmount = (double) (amount / totalSplits);

			for (Split s : splits) {
				EqualSplit e = (EqualSplit) s;
				s.setAmount(splitAmount);

			}
			splits.get(0).setAmount(splitAmount + (amount - (splitAmount * totalSplits)));

			return new EqualExpense(paidBy, amount, splits);
		default:
			return null;
		}

	}

}
