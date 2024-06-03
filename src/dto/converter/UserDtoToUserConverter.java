package dto.converter;

import java.util.ArrayList;
import java.util.List;

import dto.UserDto;
import enteti.User;
import enteti.impl.DefaultUser;

public class UserDtoToUserConverter {
	
	private RoleDtoToRoleConverter roleConverter;
	
	{
		roleConverter = new RoleDtoToRoleConverter();
	}
	
	public UserDto convertUserIdToUserDtoWithOnlyId(int customerId) {
		UserDto userDto = new UserDto();
		userDto.setId(customerId);
		return userDto;
	}
	
	public User convertUserDtoToUser(UserDto userDto) {
		if (userDto == null ) {
			return null;
		}
		User user = new DefaultUser();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setId(userDto.getId());
		user.setfirstName(userDto.getFirstName());
		user.setlastName(userDto.getLastName());
		if (userDto.getRoleDto() != null) {
			user.setRoleName(userDto.getRoleDto().getRoleName());
		}
		user.setMoney(userDto.getMoney().doubleValue());
		user.setCreditCard(userDto.getCreditCard());
		
		return user;
	}
	
	public List<User> convertUserDtosToUsers(List<UserDto> userDtos){
		List<User> users = new ArrayList<>();
		
		for (UserDto userDto : userDtos) {
			users.add(convertUserDtoToUser(userDto));
			
		}
		return users;
	}

}
