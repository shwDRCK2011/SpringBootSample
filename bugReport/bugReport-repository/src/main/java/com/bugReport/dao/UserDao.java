package com.bugReport.dao;

import java.util.List;

import com.bugReport.domain.User;
import com.bugReport.dto.UserDto;

public interface UserDao extends BaseDao<User> {

	List<UserDto> getUsersByDesignationId(Long bugStatusId);

	List<UserDto> addNewUsers(List<UserDto> userDto);
	
	

}
