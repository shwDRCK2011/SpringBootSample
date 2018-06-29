package com.bugReport.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String userName;
	private Date userCreatedDate;
	private DesignationDto designationDto;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public DesignationDto getDesignationDto() {
		return designationDto;
	}

	public void setDesignationDto(DesignationDto designationDto) {
		this.designationDto = designationDto;
	}

}
