package com.bugReport.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BugDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 190182207802656406L;

	private Long bugId;

	private String bugName;

	private Date bugStartDate;

	private Date bugExpectedEndDate;

	private BugStatusDto bugStatusDto;

	private List<Long> userIds;

//	private BugUserDto bugUserDto;

	/*public BugUserDto getBugUserDto() {
		return bugUserDto;
	}

	public void setBugUserDto(BugUserDto bugUserDto) {
		this.bugUserDto = bugUserDto;
	}*/

	public Long getBugId() {
		return bugId;
	}

	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}

	public String getBugName() {
		return bugName;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public Date getBugStartDate() {
		return bugStartDate;
	}

	public void setBugStartDate(Date bugStartDate) {
		this.bugStartDate = bugStartDate;
	}

	public Date getBugExpectedEndDate() {
		return bugExpectedEndDate;
	}

	public void setBugExpectedEndDate(Date bugExpectedEndDate) {
		this.bugExpectedEndDate = bugExpectedEndDate;
	}

	public BugStatusDto getBugStatusDto() {
		return bugStatusDto;
	}

	public void setBugStatusDto(BugStatusDto bugStatusDto) {
		this.bugStatusDto = bugStatusDto;
	}

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

}
