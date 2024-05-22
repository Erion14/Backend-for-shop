package menu.impl;

import java.util.Scanner;

import config.ApplicationContext;
import enteti.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		context = ApplicationContext.getInstance();
		userManagementService = new MySqlUserManagementService;
		
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
			System.out.printf("Glad to see you back %s %s",user.getfirstName(),user.getlastName()+System.lineSeparator());
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
