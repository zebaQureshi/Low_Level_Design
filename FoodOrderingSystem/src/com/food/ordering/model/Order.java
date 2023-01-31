package com.food.ordering.model;

import java.util.List;

import com.food.ordering.enums.OrderStatus;

public class Order {

	private User user;
	private List<OrderItem> orderItems;
	private OrderStatus orderStatus;
	private double orderCost;

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Order(User user, List<OrderItem> orderItems) {
		this.user = user;
		this.orderItems = orderItems;
		this.orderStatus=OrderStatus.ACCEPTED;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

}
