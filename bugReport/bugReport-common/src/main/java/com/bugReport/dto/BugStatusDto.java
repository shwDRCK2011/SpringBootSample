package com.bugReport.dto;

import java.io.Serializable;

public class BugStatusDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long bugStatusId;
	private String bugStatus;
	
	public Long getBugStatusId() {
		return bugStatusId;
	}
	public void setBugStatusId(Long bugStatusId) {
		this.bugStatusId = bugStatusId;
	}
	public String getBugStatus() {
		return bugStatus;
	}
	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}
	

}
