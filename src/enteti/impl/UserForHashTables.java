package enteti.impl;

import java.util.Objects;

import enteti.User;

public class UserForHashTables implements User{

	
	private static int userCounter = 0;
	
	private int id;
	private String Firstname;
	private String Lastname;
	private String password;
	private String email;
	private String roleName;
	private double money;
	private String creditCard;
	
	{
			id = ++userCounter;
	}
	
	
	public UserForHashTables(String firstname, String lastname, String password, String email) {
		Firstname = firstname;
		Lastname = lastname;
		this.password = password;
		this.email = email;
	}
	
	public UserForHashTables(int id, String firstname, String lastname, String password, String email) {
		super();
		userCounter--;
		this.id = id;
		Firstname = firstname;
		Lastname = lastname;
		this.password = password;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserForHashTables [id=" + id + ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", password="
				+ password + ", email=" + email + ", roleName=" + roleName + ", money=" + money + ", creditCard="
				+ creditCard + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getfirstName() {
		return Firstname;
	}
	public void setfirstName(String firstname) {
		Firstname = firstname;
	}
	public String getlastName() {
		return Lastname;
	}
	public void setlastName(String lastname) {
		Lastname = lastname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Firstname, Lastname, creditCard, email, id, money, password, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserForHashTables other = (UserForHashTables) obj;
		return Objects.equals(Firstname, other.Firstname) && Objects.equals(Lastname, other.Lastname)
				&& Objects.equals(creditCard, other.creditCard) && Objects.equals(email, other.email) && id == other.id
				&& Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money)
				&& Objects.equals(password, other.password) && Objects.equals(roleName, other.roleName);
	}

	

	
	
	
}
