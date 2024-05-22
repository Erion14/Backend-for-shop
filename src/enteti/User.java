package enteti;

public interface User {
	String getfirstName();
	void setfirstName(String firstName);
	
	String getlastName();
	void setlastName(String lastName);

	String getPassword();
	String getEmail();
	
	int getId();
	void setId(int id);
	
	void setPassword(String newPassword);
	void setEmail(String newEmail);
	
	String getRoleName();
	void setRoleName(String roleName);
	
	double getMoney();
	void setMoney(double money);
	
	String getCreditCard();
	void setCreditCard(String creditCard);
}
