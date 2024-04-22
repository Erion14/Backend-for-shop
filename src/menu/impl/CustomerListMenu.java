package menu.impl;

import config.ApplicationContext;
import enteti.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
		
	}
	
	
	
	@Override
	public void start() {
		printmenuheader();
		
		User[] users = userManagementService.getUsers();
		
		if(users.length==0) {
			System.out.println("Unfortunately, there are no customers");
		} else {
			for(User user : users) {
				System.out.println(user);
				
			}
		}
		context.getMainMenu().start();
		// TODO Auto-generated method stub

	}

	@Override
	public void printmenuheader() {
		System.out.println("USERS");
	}

}
