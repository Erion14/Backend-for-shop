package menu.impl;

import java.util.Scanner;

import config.ApplicationContext;
import menu.Menu;

public class changeEmailMenu implements Menu{

	private ApplicationContext context;
	{
		context = ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		printmenuheader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		context.getloggedinUser().setEmail(userInput);
		System.out.println("Your email has been changed");
		new MainMenu().start();
		
		
	}

	@Override
	public void printmenuheader() {
		System.out.println("Change your email");
		System.out.println("Enter your new email: ");
		
	}
	
}
