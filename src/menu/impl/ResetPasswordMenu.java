package menu.impl;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import enteti.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class ResetPasswordMenu implements Menu{
	
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
	}
	
	
	public void start() {
		printmenuheader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		System.out.println("Your password has been sent to your email. Please check your inbox.");
		CompletableFuture.runAsync(() -> {
			User user = userManagementService.getUserByEmail(userInput);
			userManagementService.resetPasswordForUser(user);
		});
		new MainMenu().start();
	}




	@Override
	public void printmenuheader() {
		System.out.println("---- Reset Password ----");
		System.out.println("Enter your email: ");
		
	}

}
