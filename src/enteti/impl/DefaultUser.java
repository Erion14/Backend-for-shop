package enteti.impl;

import annotations.Validate;
import enteti.User;

public class DefaultUser implements User{
	
	private static int usercount=0;
	
	private int id;
	
	@Validate(pattern = "[a-zA-z]+")
	private String firstName;
	
	@Validate(pattern = "[a-zA-z]+")
	private String lastName;
	
	private String Password;
	
	@Validate(pattern = ".+@.+")
	private String Email;
	
	private String roleName;
	private double money;
	private String creditCard;
	
	
	{
		id = ++usercount;
	}

	
	
	public DefaultUser() {
		
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email, String creditCard) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		Email = email;
		this.creditCard = creditCard;
	}


	public DefaultUser(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		Email = email;
	}


	public DefaultUser(int id, String firstName, String lastName, String password, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		Email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getfirstName() {
		return firstName;
	}


	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getlastName() {
		return lastName;
	}


	public void setlastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return Password;
	}
	
	void clearState() {
		usercount = 0;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public String getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public static void setCounter(int asInt) {
		usercount = asInt;
		
	}


	

}