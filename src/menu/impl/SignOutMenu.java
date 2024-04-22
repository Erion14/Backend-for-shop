package menu.impl;

import config.ApplicationContext;
import menu.Menu;

public class SignOutMenu implements Menu {
	private ApplicationContext context; 
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printmenuheader();
		context.setloggedinUser(null);
		context.getMainMenu().start();

	}

	@Override
	public void printmenuheader() {
		System.out.println("SIGN OUT");
		System.out.println("Have a nice day! Looking forward to see you back!");
	}

}
