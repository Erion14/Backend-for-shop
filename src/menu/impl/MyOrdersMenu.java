package menu.impl;

import java.util.List;

import config.ApplicationContext;
import enteti.Purchase;
import menu.Menu;
import services.PurchaseManagementService;
import services.impl.MySqlPurchaseManagementService;

public class MyOrdersMenu implements Menu{
	private ApplicationContext context;
	private PurchaseManagementService purchaseManagementService;
	
	
	{
		context = ApplicationContext.getInstance();
		purchaseManagementService = new MySqlPurchaseManagementService();
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
		List<Purchase> loggedInUserOrders = purchaseManagementService
				.getPurchaseByUserId(context.getloggedinUser().getId());
		if (loggedInUserOrders == null || loggedInUserOrders.size() ==0) {
			System.out.println("Unfortunately , you don't have any orders yet. " + 
		"Navigate back to main menu to place new order");
		}else {
			for (Purchase order : loggedInUserOrders) {
				System.out.println(order);
			}
		}
	}

	@Override
	public void printmenuheader() {
		System.out.println("MY ORDERS");
	}

}
