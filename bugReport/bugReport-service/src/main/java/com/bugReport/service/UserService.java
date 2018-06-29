package com.bugReport.service;

import java.util.List;

import com.bugReport.dto.ResponseDto;
import com.bugReport.dto.UserDto;

public interface UserService {

	ResponseDto getUsersByDesignationId(Long designationId);

	List<ResponseDto> addNewUsers(List<UserDto> userDto);

}
