package com.bugReport.dto;

import java.io.Serializable;
import java.util.List;

public class ProjectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long projectId;
	private String projectName;
	private List<BugDto> bugDto;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<BugDto> getBugDto() {
		return bugDto;
	}

	public void setBugDto(List<BugDto> bugDto) {
		this.bugDto = bugDto;
	}

}
