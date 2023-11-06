package com.itbulls.ademi.sect5to10.OOP.EXAM.services.impl;

import java.util.Arrays;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.User;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {
	private static final String SAME_EMAIL_ERROR = "This email is in use by another user";
	private static final String EMPTY_EMAIL_ERROR = "You have to type an email";
	private static final String NO_ERROR = "";

	private static final int DEFAULT_USER_CAPACITY = 25;

	private static DefaultUserManagementService instance;

	private User[] users;
	private int lastuserindex;
	{
		users = new User[DEFAULT_USER_CAPACITY];
	}

	private DefaultUserManagementService() {

	}

	@Override
	public String registerUser(User user) {
		if (user == null) {
			return NO_ERROR;
		}
		String errorMessage = checkUniqueEmail(user.getEmail());
		if (errorMessage != null && !errorMessage.isEmpty()) {
			return errorMessage;
		}
		if (users.length <= lastuserindex) {
			users = Arrays.copyOf(users, users.length << 1);
		}
		users[lastuserindex++] = user;
		return NO_ERROR;
	}

	private String checkUniqueEmail(String email) {
		if (email == null || email.isEmpty()) {

			return EMPTY_EMAIL_ERROR;
		}
		for (User user : users) {
			if (user != null && user.getEmail() != null && user.getEmail().equalsIgnoreCase(email)) {
				return SAME_EMAIL_ERROR;

			}
			

		}
		return NO_ERROR;
	}

	@Override
	public User[] getUsers() {
		int nonnulluseramount = 0;
		for (User user : users) {
			if (user != null) {
				nonnulluseramount++;
			}
		}
		User[] nonnulluser = new User[nonnulluseramount];
		int index = 0;
		for (User user : users) {
			if (user != null) {
				nonnulluser[index++] = user;
			}
		}
		return nonnulluser;
		}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User user : users) {
			if (user != null && user.getEmail().equalsIgnoreCase(userEmail)) {
				return user;
			}
		}
		return null;
	}
	void clearServiceState() {
		lastuserindex=0;
		users = new User[DEFAULT_USER_CAPACITY];
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

}
