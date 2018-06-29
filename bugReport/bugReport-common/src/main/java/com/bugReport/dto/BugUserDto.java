package com.bugReport.dto;

import java.io.Serializable;

public class BugUserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bugUserId;
	private Long bugId;
	private Long userId;

	public Long getBugUserId() {
		return bugUserId;
	}

	public void setBugUserId(Long bugUserId) {
		this.bugUserId = bugUserId;
	}

	public Long getBugId() {
		return bugId;
	}

	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
