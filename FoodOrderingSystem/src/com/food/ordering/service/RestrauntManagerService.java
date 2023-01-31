package com.food.ordering.service;

import java.util.ArrayList;
import java.util.List;

import com.food.ordering.model.Menu;
import com.food.ordering.model.MenuItem;
import com.food.ordering.model.Order;
import com.food.ordering.model.Restraunt;

public class RestrauntManagerService {
	private List<Restraunt> restraunts;

	private static RestrauntManagerService restrauntManagerService;

	private RestrauntManagerService() {
		this.restraunts = new ArrayList<Restraunt>();
	}

	public static RestrauntManagerService getInstance() {
		try {
			if (restrauntManagerService == null)
				restrauntManagerService = new RestrauntManagerService();
		} catch (Exception e) {
			System.out.println("Error occurred while creating a restraunt : " + e);
		}

		return restrauntManagerService;
	}

	public List<Restraunt> getRestraunts() {
		return restraunts;
	}

	public void addRestranuts(Restraunt restraunt) {
		if (restraunts == null)
			this.restraunts = new ArrayList<Restraunt>();

		restraunts.add(restraunt);

	}

	public void addRestranuts(List<Restraunt> restraunt) {
		if (restraunts == null)
			this.restraunts = new ArrayList<Restraunt>();

		this.restraunts.addAll(restraunt);

	}

	public void updateRestraunt(Restraunt restraunt, MenuItem menuItem, double price) {

		if (restraunts == null)
			System.out.println("No restraunts available to update.");
		else {
			for (Restraunt r : restraunts) {
				if (r == restraunt) {
					Menu m = r.getMenu();
					List<MenuItem> mItems = m.getMenuitems();

					for (MenuItem mItem : mItems) {
						if (mItem == menuItem) {
							mItem.setPrice(price);
							break;
						}
					}
					break;
				}

			}
		}

	}

	public boolean findAndPlaceOrder(Order order) {

		if (restraunts != null) {
			for (Restraunt res : restraunts) {
				if (res.canAcceptOrder(order)) {
					res.addOrder(order);
					System.out.println("Order placed at: "+res.getName());
					return true;
				}
			}
		}

		return false;
	}
	
	public void printRestrauntsAndMenu()
	{
		if (restraunts != null) {
			for(Restraunt res: restraunts)
			{
				System.out.println("------------");
				res.printRestrauntMenu();
				System.out.println("------------");
			}
		}
	}

}
