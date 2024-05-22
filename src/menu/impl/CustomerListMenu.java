package menu.impl;

import java.util.List;

import config.ApplicationContext;
import enteti.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = MySqlUserManagementService();
		context = ApplicationContext.getInstance();
		
	}
	
	
	
	@Override
	public void start() {
		printmenuheader();
		List<User> users = userManagementService.getUsers();
		
		
		if(users == null || users.size() == 0) {
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
