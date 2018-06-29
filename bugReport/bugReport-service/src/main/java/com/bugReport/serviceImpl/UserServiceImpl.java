package com.bugReport.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugReport.constant.MessageConstants;
import com.bugReport.dao.UserDao;
import com.bugReport.dto.ResponseDto;
import com.bugReport.dto.UserDto;
import com.bugReport.service.UserService;
import com.bugReport.service.util.ServiceUtil;

@Repository
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	ServiceUtil serviceUtil;

	@Autowired
	UserDao userDao;

	@Override
	public ResponseDto getUsersByDesignationId(Long designationId) {
		LOGGER.info("UserServiceImpl.getUsersByDesignationId(Long designationId) execution started.");
		ResponseDto responseDto = null;
		try {
			List<UserDto> users = userDao.getUsersByDesignationId(designationId);
			if (users != null && users.size() > 0) {
				LOGGER.info("Users information received.");
				responseDto = serviceUtil.getServiceResponse(users);
			} else {
				LOGGER.info("Unable to receive the users information.");
				responseDto = serviceUtil
						.getErrorServiceResponse(MessageConstants.ServiceErrorMessages.ERR_USERS_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while reciving the userss details.");
			responseDto = serviceUtil
					.getExceptionServiceResponseByProperties(MessageConstants.ServiceErrorMessages.EX_USERS_RETRIEVE);
		}

		return responseDto;
	}

	@Override
	public List<ResponseDto> addNewUsers(List<UserDto> userDtos) {
		LOGGER.info("UserServiceImpl.addNewUsers(UserDto userDto) execution started.");
		List<ResponseDto> responseDto = null;
		try {
			responseDto = new ArrayList<ResponseDto>();
			List<UserDto> users = userDao.addNewUsers(userDtos);
			for (UserDto user : users) {
				// responseDto = serviceUtil.getServiceResponse(user);
				responseDto.add(serviceUtil.getServiceResponse(user));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while reciving the userss details.");
		}
		return responseDto;
	}
}
