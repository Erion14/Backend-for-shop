package com.itbulls.ademi.sect5to10.OOP.EXAM.services;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.User;

public interface UserManagementService {
	
	String registerUser(User user);
	
	User[] getUsers();
	
	User getUserByEmail(String userEmail);

}
