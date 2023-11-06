package com.itbulls.ademi.sect5to10.OOP.EXAM.enteti;

public interface User {
	String getFirstname();
	String getLastname();
	String getPassword();
	String getEmail();
	int getId();
	
	void setPassword(String newPassword);
	void setEmail(String newEmail);
}
