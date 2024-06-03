package services.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.MySqlJdbcUserDao;
import dto.UserDto;
import dto.converter.UserDtoToUserConverter;
import enteti.User;
import services.UserManagementService;
import utils.mail.MailSender;

public class MySqlUserManagementService implements UserManagementService {
	
	public static final String SUCCESSFULL_REGISTRATION_MESSAGE = "User is registred!";
	public static final String REGISTRATION_ERROR_MESSAGE = "The email is already in use by other user";
	
	
	private UserDao userDao;
	private UserDtoToUserConverter userConverter;
	
	{
		userDao = new MySqlJdbcUserDao();
		userConverter = new UserDtoToUserConverter();
	}

	@Override
	public String registerUser(User user) {
		boolean isCreated = userDao.saveUser(userConverter.convertUserToUserDto(user));
		
		if (isCreated) {
			return SUCCESSFULL_REGISTRATION_MESSAGE;
		}
		else {
			return REGISTRATION_ERROR_MESSAGE;
		}
		
	}

	@Override
	public List<User> getUsers() {
		List<UserDto> userDto = userDao.getUsers();
		return userConverter.convertUserDtosToUsers(userDto);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		UserDto userDto = userDao.getUserByEmail(userEmail);
		return userConverter.convertUserDtoToUser(userDto);
	}

	@Override
	public void resetPasswordForUser(User user) {
		MailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());

	}
}
