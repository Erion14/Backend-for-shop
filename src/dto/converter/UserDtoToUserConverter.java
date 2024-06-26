package dto.converter;

import java.math.BigDecimal;
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
	
	public UserDto convertUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getfirstName());
		userDto.setLastName(user.getlastName());
		userDto.setPassword(user.getPassword());
		userDto.setRoleDto(roleConverter.convertRoleNameToRoleDtoWithOnlyRoleName(user.getRoleName()));
		userDto.setMoney(BigDecimal.valueOf(user.getMoney()));
		userDto.setCreditCard(user.getCreditCard());
		return userDto;
	}
	
	public List<User> convertUserDtosToUsers(List<UserDto> userDtos){
		List<User> users = new ArrayList<>();
		
		for (UserDto userDto : userDtos) {
			users.add(convertUserDtoToUser(userDto));
			
		}
		return users;
	}

}
