
import menu.Menu;
import menu.impl.MainMenu;

public class Main {
	
	public static final String EXIT_COMMAND = "exit";
	public static void main(String[]args) {
		Menu Mainmenu = new MainMenu();
		Mainmenu.start();
	}

}
