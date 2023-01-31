package com.food.ordering.service;

import java.util.ArrayList;
import java.util.List;

import com.food.ordering.enums.OrderStatus;
import com.food.ordering.model.Order;
import com.food.ordering.model.OrderItem;

public class OrderManagerService {

	private static OrderManagerService orderManagerService;
	private List<Order> orders;

	private OrderManagerService() {
		orders = new ArrayList<Order>();
	}

	public static OrderManagerService getInstance() {
		if (orderManagerService == null)
			orderManagerService = new OrderManagerService();

		return orderManagerService;

	}

	public void placeOrder(RestrauntManagerService restrauntManagerService, Order order) {

		if (orders == null)
			orders = new ArrayList<Order>();

		if (restrauntManagerService.findAndPlaceOrder(order)) {
			System.out.println("Order placed.");
			order.setOrderStatus(OrderStatus.ACCEPTED);
			this.orders.add(order);

		} else {
			order.setOrderStatus(OrderStatus.CANCELLED);
			this.orders.add(order);
			System.out.println("Sorry, No restraunts available / complete order doesn't exist in a restraunt. ");
		}

	}

	public void printAllOrder() {
		if (orders != null) {

			for (Order order : orders) {
				System.out.println("----------------------------");
				System.out.println("Order for User: " + order.getUser().getName());
				System.out.println("Order status: " + order.getOrderStatus());
				List<OrderItem> orderItems = order.getOrderItems();

				if (orderItems != null) {
					for (OrderItem i : orderItems) {
						System.out.println("Item name: " + i.getName());
						System.out.println("Item quantity: " + i.getQuantity());
					}

				}
				System.out.println("----------------------------");
			}
		}

	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
