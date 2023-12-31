package com.itbulls.ademi.sect5to10.OOP.EXAM.menu.impl;

import java.util.Scanner;

import com.itbulls.ademi.sect5to10.OOP.EXAM.config.ApplicationContext;
import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.User;
import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.impl.DefaultUser;
import com.itbulls.ademi.sect5to10.OOP.EXAM.menu.Menu;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.UserManagementService;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {
	private UserManagementService userManagementService;
	private ApplicationContext context;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
			printmenuheader();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Please, enter your first name: ");
			String firstName = sc.next();
			System.out.print("Please, enter your last name: ");
			String lastName = sc.next();
			System.out.print("Please, enter your password: ");
			String password = sc.next();
			System.out.print("Please, enter your email: ");
			
			sc = new Scanner(System.in);
			String email = sc.nextLine();
			
			User user = new DefaultUser(firstName,lastName,password,email);
			
			String errorMessage = userManagementService.registerUser(user);
			if (errorMessage == null || errorMessage.isEmpty()) {
				context.setloggedinUser(user);
				System.out.println("New user is created");
				
			}else {
				System.out.println(errorMessage);
			}
			context.getMainMenu().start();
	}

	@Override
	public void printmenuheader() {
		System.out.println("SIGN UP");

	}

}
