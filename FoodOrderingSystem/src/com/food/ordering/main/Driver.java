package com.food.ordering.main;

import java.util.ArrayList;
import java.util.List;

import com.food.ordering.model.Menu;
import com.food.ordering.model.MenuItem;
import com.food.ordering.model.Order;
import com.food.ordering.model.OrderItem;
import com.food.ordering.model.Restraunt;
import com.food.ordering.model.User;
import com.food.ordering.service.OrderManagerService;
import com.food.ordering.service.RestrauntManagerService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Restraunts: 
		 * R1 : Dosa-50 , Idli:70 Daal:100 Rice:60 (Rating :4.5/5 maxOrders:1) 
		 * R2: Chicken curry: 200 Veg Biryani: 150 Chicken Biryani: 300  Rice:60 Naan:15 (Rating :4.7/5 maxOrders:2)
		 * 
		 * Orders:
		 *  U1: Dosa:2 Daal:1 Rice:2 
		 *  U2: Chicken Biryani: 2 Veg Biryani:1 
		 *  U3: Dosa:3 Veg Biryani:2
		 * 
		 */
		try {
			RestrauntManagerService restrauntManagerService = RestrauntManagerService.getInstance();
			OrderManagerService orderManagerService = OrderManagerService.getInstance();

			MenuItem mi1 = new MenuItem("Dosa", 50);
			MenuItem mi2 = new MenuItem("Idli", 70);
			MenuItem mi3 = new MenuItem("Daal", 100);
			MenuItem mi4 = new MenuItem("Rice", 60);

			MenuItem mi5 = new MenuItem("Chicken curry", 200);
			MenuItem mi6 = new MenuItem("Veg Biryani", 150);
			MenuItem mi7 = new MenuItem("Chicken Biryani", 300);

			List<MenuItem> menuItems1 = new ArrayList<MenuItem>();
			menuItems1.add(mi1);
			menuItems1.add(mi2);
			menuItems1.add(mi3);
			menuItems1.add(mi4);

			List<MenuItem> menuItems2 = new ArrayList<MenuItem>();
			menuItems2.add(mi5);
			menuItems2.add(mi6);
			menuItems2.add(mi7);
			menuItems2.add(mi4);

			Menu m1 = new Menu(menuItems1);

			Menu m2 = new Menu(menuItems2);

			Restraunt r1 = new Restraunt("R1", m1, 1, 0, 4.5);
			Restraunt r2 = new Restraunt("R2", m2, 2, 0, 4.7);
			restrauntManagerService.addRestranuts(r1);
			restrauntManagerService.addRestranuts(r2);

			OrderItem oi1 = new OrderItem("Dosa", 2);
			OrderItem oi2 = new OrderItem("Daal", 1);
			OrderItem oi3 = new OrderItem("Rice", 2);
			OrderItem oi4 = new OrderItem("Chicken Biryani", 2);
			OrderItem oi5 = new OrderItem("Veg Biryani", 1);
			OrderItem oi6 = new OrderItem("Dosa", 3);
			OrderItem oi7 = new OrderItem("Veg Biryani", 2);

			User u1 = new User("U1");
			User u2 = new User("U2");
			User u3 = new User("U3");

			List<OrderItem> ol1 = new ArrayList<OrderItem>();
			List<OrderItem> ol2 = new ArrayList<OrderItem>();
			List<OrderItem> ol3 = new ArrayList<OrderItem>();

			ol1.add(oi1);
			ol1.add(oi2);
			ol1.add(oi3);

			ol2.add(oi4);
			ol2.add(oi5);

			ol3.add(oi6);
			ol3.add(oi7);

			Order o1 = new Order(u1, ol1);
			Order o2 = new Order(u2, ol2);
			Order o3 = new Order(u3, ol3);

			
			restrauntManagerService.printRestrauntsAndMenu();
			orderManagerService.placeOrder(restrauntManagerService, o1);
			orderManagerService.placeOrder(restrauntManagerService, o2);
			orderManagerService.placeOrder(restrauntManagerService, o3);

		} catch (Exception e) {

			System.out.println("Exception occured: "+e.getMessage());
		}
	}

}
