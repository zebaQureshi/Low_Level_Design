package com.food.ordering.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.food.ordering.enums.OrderStatus;

public class Restraunt {

	private String name;
	private double rating;
	private int maxOrder;
	private int currOrders;
	private Menu menu;
	private List<Order> orders;

	public Restraunt(String name, Menu menu, int maxOrders, int currOrders, double rating) {
		this.name = name;
		this.menu = menu;
		this.maxOrder = maxOrders;
		this.currOrders = currOrders;
		this.rating = rating;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getMaxOrder() {
		return maxOrder;
	}

	public void setMaxOrder(int maxOrder) {
		this.maxOrder = maxOrder;
	}

	public int getCurrOrders() {
		return currOrders;
	}

	public void setCurrOrders(int currOrders) {
		this.currOrders = currOrders;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void completeOrder(Order order) {
		for (Order order1 : orders) {
			if (order1 == order) {
				{
					order.setOrderStatus(OrderStatus.COMPLETED);
					System.out.println("Order for user :" + order.getUser() + "  is completed.");
					this.currOrders--;
				}
				break;
			}
		}

	}

	public void addOrder(Order order) {
		if (orders == null)
			orders = new ArrayList<Order>();

		orders.add(order);
		setOrderPrice(order);
	}

	public boolean canAcceptOrder(Order order) {

		if (this.currOrders >= this.maxOrder)
			return false;

		if (isOrderAvailable(order)) {
			this.currOrders++;
			//setOrderPrice(order);
			return true;
		} else
			return false;
	}

	public boolean isOrderAvailable(Order order) {
		List<MenuItem> menuItems = menu.getMenuitems();
		List<OrderItem> orderItems = order.getOrderItems();

		Set<String> menuSet = new HashSet<String>();
		for (MenuItem item : menuItems) {
			menuSet.add(item.getName());
		}
		for (OrderItem item : orderItems) {
			if (!menuSet.contains(item.getName()))
				return false;

		}

		return true;

	}

	public void printRestrauntMenu() {
		System.out.println("Menu of Restraunt " + this.getName());
		System.out.println("Item     Price ");
		if (this.menu != null) {
			for (MenuItem item : menu.getMenuitems()) {
				System.out.println(item.getName() + "  " + item.getPrice());
			}
		}

	}

	public void setOrderPrice(Order order) {
		Map<String, Double> menuPriceMap = new HashMap<String, Double>();

		for (MenuItem item : menu.getMenuitems()) {
			menuPriceMap.put(item.getName(), item.getPrice());
		}

		double price = 0.0;
		double sum = 0.0;
		for (OrderItem item : order.getOrderItems()) {
			price = menuPriceMap.get(item.getName());
			item.setPrice(price);
			sum += (double) (price * item.getQuantity());

		}
		order.setOrderCost(sum);
	}

}
