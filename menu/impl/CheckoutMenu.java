package com.itbulls.ademi.sect5to10.OOP.EXAM.menu.impl;

import java.util.Scanner;

import com.itbulls.ademi.sect5to10.OOP.EXAM.config.ApplicationContext;
import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Order;
import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.impl.DefaultOrder;
import com.itbulls.ademi.sect5to10.OOP.EXAM.menu.Menu;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.OrderManagementService;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {
	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		while (true) {
			printmenuheader();
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();

			if (!createOrder(userInput)) {
				continue;
			}
			context.getSessioncart().clear();
			break;
		}
		System.out.println("Thanks a lot for your purchase. Details about your orders are sent to your email");
		new MainMenu().start();

	}

	private boolean createOrder(String creditCardNumber) {
		Order order = new DefaultOrder();
		if (!order.isCreditCardNumbervalid(creditCardNumber)) {
			return false;
		}
		
		order.setcreditcardnumber(creditCardNumber);
		order.setproducts(context.getSessioncart().getproducts());
		order.setCustomerId(context.getloggedinUser().getId());
		orderManagementService.addOrder(order);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void printmenuheader() {
		System.out.println("Checkout menu");
		System.out.println("Enter your credit card number without spaces and press enter to confirm purchase");;

	}

}
