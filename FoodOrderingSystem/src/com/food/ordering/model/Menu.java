package com.food.ordering.model;

import java.util.List;

public class Menu {

	private List<MenuItem> menuitems;

	public Menu(List<MenuItem> menuitems) {
		this.menuitems = menuitems;

	}

	public List<MenuItem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(List<MenuItem> menuitems) {
		this.menuitems = menuitems;
	}

}
