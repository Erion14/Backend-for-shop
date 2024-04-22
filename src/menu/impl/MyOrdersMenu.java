package menu.impl;

import config.ApplicationContext;
import enteti.Order;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu{
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printmenuheader();
		if(context.getloggedinUser()==null) {
			System.out.println("Please login or create an account to see your orders");
			new MainMenu().start();
			return;
		}
		else {
			printUserOrdersToConsole();
		}
		new MainMenu().start();
		// TODO Auto-generated method stub
		
	}
	

	private void printUserOrdersToConsole() {
		Order[] loggedInUserOrders = orderManagementService.getOrdersByUserId(context.getloggedinUser().getId());
		
		
		if (loggedInUserOrders == null || loggedInUserOrders.length==0) {
			System.out.println("Unfortunately , you don't have any orders yet. " + 
		"Navigate back to main menu to place new order");
		}else {
			for (Order order : loggedInUserOrders) {
				System.out.println(order);
			}
		}
	}

	@Override
	public void printmenuheader() {
		System.out.println("MY ORDERS");
	}

}
