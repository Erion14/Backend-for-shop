package enteti;

public interface User {
	String getFirstname();
	String getLastname();
	String getPassword();
	String getEmail();
	int getId();
	
	void setPassword(String newPassword);
	void setEmail(String newEmail);
}
