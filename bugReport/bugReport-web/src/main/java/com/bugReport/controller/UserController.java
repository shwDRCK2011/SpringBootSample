package com.bugReport.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugReport.dto.ResponseDto;
import com.bugReport.dto.UserDto;
import com.bugReport.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getUsersByDesignationId", method = RequestMethod.GET)
	public ResponseDto getUsersByDesignationId(@RequestParam("designationId") Long designationId) {
		LOGGER.info("UserController.getUsersByDesignationId()");
		return userService.getUsersByDesignationId(designationId);
	}
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public List<ResponseDto> addNewUsers(@RequestBody List<UserDto> userDtos) {
		LOGGER.info("UserController.addNewUser()");
		return userService.addNewUsers(userDtos);
	}
}
