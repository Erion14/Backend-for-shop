package com.itbulls.ademi.sect5to10.OOP.EXAM.menu.impl;

import java.util.Scanner;

import com.itbulls.ademi.sect5to10.OOP.EXAM.config.ApplicationContext;
import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.User;
import com.itbulls.ademi.sect5to10.OOP.EXAM.menu.Menu;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.UserManagementService;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
		
	}

	@Override
	public void start() {
		printmenuheader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your email: ");
		String userEmail = sc.next();
		
		System.out.print("Please, enter your password: ");
		String userPassword = sc.next();
		
		User user = userManagementService.getUserByEmail(userEmail);
		if(user != null && user.getPassword().equals(userPassword)) {
			System.out.printf("Glad to see you back %s %s",user.getFirstname(),user.getLastname()+System.lineSeparator());
			context.setloggedinUser(user);
			
		}else {
			System.out.println("Unfortunately, such login and password don't exist");
			
		}
		context.getMainMenu().start();
		// TODO Auto-generated method stub

	}

	@Override
	public void printmenuheader() {
		System.out.println("SIGN IN");
	}

}
