package config;

import enteti.Cart;
import enteti.User;
import enteti.impl.DefaultCart;
import menu.Menu;

public class ApplicationContext {
	private static ApplicationContext instance;
	private User loggedinUser;
	private Menu mainMenu;
	private Cart sessioncart;
	
	
	private ApplicationContext() {
		
	}
	
	public void setloggedinUser(User user) {
		if (this.sessioncart != null) {
			this.sessioncart.clear();		}
		this.loggedinUser = user;
	}
	
	public User getloggedinUser() {
		return this.loggedinUser;
	}
	public void setMainMenu(Menu menu) {
		this.mainMenu=menu;
	}
	public Menu getMainMenu() {
		return this.mainMenu;
	}
	public static ApplicationContext getInstance() {
		if(instance==null) {
			instance = new ApplicationContext();
			
		}
		return instance;
		
	}
	public Cart getSessioncart() {
		if(this.sessioncart==null) {
			this.sessioncart= new DefaultCart();
		}
		return this.sessioncart;
	}
	
	
}
