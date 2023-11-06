package com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.impl;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.User;

public class DefaultUser implements User{
	
	private static int usercount=0;
	
	private int id;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	
	{
		id = ++usercount;
	}

	public DefaultUser(String firstname, String lastname, String password , String email) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.password=password;
		this.email=email;
	}
	@Override
	public String getFirstname() {
		// TODO Auto-generated method stub
		return this.firstname;
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return this.lastname;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return  this.email;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setPassword(String newPassword) {
		if(password==null) {
			return;
		}
		this.password=password;
		
	}

	@Override
	public void setEmail(String newEmail) {
		if(newEmail==null) {
			return;
		}
		this.email=newEmail;
		
		
	}
	void clear() {
		usercount=0;
	}

}
