package com.splitwise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.splitwise.model.Expense;
import com.splitwise.model.ExpenseType;
import com.splitwise.model.Split;
import com.splitwise.model.User;

public class ExpenseManager {

	List<Expense> expenses;
	Map<String, User> userMap;
	Map<String, Map<String, Double>> balanceSheet;

	public ExpenseManager() {
		this.expenses = new ArrayList<Expense>();
		this.userMap = new HashMap<String, User>();
		this.balanceSheet = new HashMap<String, Map<String, Double>>();

	}

	public void addUser(User user) {
		userMap.put(user.getId(), user);
	}

	public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits) {
		Expense expense= ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splits);
		expenses.add(expense);
		
		for(Split s: expense.getSplits())
		{
			String paidTo= s.getUser().getId();
		   Map<String,Double> balances= balanceSheet.get(paidBy);
			balances.put(paidTo,balances.getOrDefault(paidTo, 0.0)+s.getAmount());
			
		
		balances=balanceSheet.get(paidTo);
		
		balances.put(paidBy, balances.getOrDefault(paidBy, 0.0)-s.getAmount());
		}
		
		

	}

}
