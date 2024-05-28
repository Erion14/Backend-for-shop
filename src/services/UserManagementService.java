package services;

import java.util.List;

import enteti.User;

public interface UserManagementService {
	
	String registerUser(User user);
	
	List<User> getUsers();
	
	User getUserByEmail(String userEmail);

	void resetPasswordForUser(User user);

}
