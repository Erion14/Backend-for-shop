package com.itbulls.ademi.sect5to10.OOP.EXAM.menu.impl;

import java.util.Scanner;

import com.itbulls.ademi.sect5to10.OOP.EXAM.config.ApplicationContext;
import com.itbulls.ademi.sect5to10.OOP.EXAM.menu.Menu;

public class SettingsMenu implements Menu {
	private static final String SETTINGS = "1. Change Password" + System.lineSeparator() + "2. Change Email";
	
	private ApplicationContext context;
	
	
	{
		context = ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		Menu menuToNavigate = null;
		mainLoop : while (true) {
			printmenuheader();
			if(context.getloggedinUser()==null) {
				System.out.println("Please, log in or create new account to change your account settings");
				new MainMenu().start();
				return;
				
			}else {
				System.out.println(SETTINGS);
				System.out.print("Please, enter option or type 'menu' to navigate back to main menu");
				Scanner sc = new Scanner(System.in);
				String userInput = sc.next();
				if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
					menuToNavigate = new MainMenu();
					break mainLoop;
				}
				
				int userOption = Integer.parseInt(userInput);
				switch (userOption) {
				case 1:
					menuToNavigate = new changePasswordMenu();
					break mainLoop;
				case 2:
					menuToNavigate = new changeEmailMenu();
					break mainLoop;
				default:
					System.out.println("Only 1,2 is allowed. Try one more time");
					continue;
				}
				
			}
		}
		menuToNavigate.start();
		// TODO Auto-generated method stub

	}

	@Override
	public void printmenuheader() {
		System.out.println("SETTINGS");
	}

}
