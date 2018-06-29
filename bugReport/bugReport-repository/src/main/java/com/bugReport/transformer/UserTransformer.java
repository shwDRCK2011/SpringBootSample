package com.bugReport.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugReport.domain.User;
import com.bugReport.dto.UserDto;

@Service
public class UserTransformer implements BaseTransformer<User, UserDto>{

	@Autowired
	DesignationTransformer designationTransformer;
	
	@Override
	public UserDto transform(User user) {

		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		userDto.setUserCreatedDate(user.getCreatedDate());
		userDto.setDesignationDto(designationTransformer.transform(user.getDesignation()));
		return userDto;
	}

	@Override
	public User reverseTransform(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setCreatedDate(userDto.getUserCreatedDate());
		user.setDesignation(designationTransformer.reverseTransform(userDto.getDesignationDto()));
		return user;
	}

}
