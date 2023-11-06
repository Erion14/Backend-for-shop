package com.itbulls.ademi.sect5to10.OOP.EXAM;

import com.itbulls.ademi.sect5to10.OOP.EXAM.menu.Menu;
import com.itbulls.ademi.sect5to10.OOP.EXAM.menu.impl.MainMenu;

public class Main {
	
	public static final String EXIT_COMMAND = "exit";
	public static void main(String[]args) {
		Menu Mainmenu = new MainMenu();
		Mainmenu.start();
	}

}
