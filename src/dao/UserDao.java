package dao;

import java.util.List;

import dto.UserDto;

public interface UserDao {
	
	boolean saveUser(UserDto user);
	
	List<UserDto> getUsers();
	
	UserDto getUserByEmail(String userEmail);
	
	UserDto getUserById(int id);

}
