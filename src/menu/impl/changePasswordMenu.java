package menu.impl;

import java.util.Scanner;

import config.ApplicationContext;
import menu.Menu;

public class changePasswordMenu implements Menu{
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printmenuheader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		context.getloggedinUser().setPassword(userInput);
		System.out.println("Your password has been succesfully changed");
		new MainMenu().start();
		
	}

	@Override
	public void printmenuheader() {
		System.out.println("Change your password");
		System.out.println("Enter new password: ");
	}

}
