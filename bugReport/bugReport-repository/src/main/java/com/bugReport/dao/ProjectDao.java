package com.bugReport.dao;

import java.util.List;

import com.bugReport.domain.Project;
import com.bugReport.dto.ProjectDto;

public interface ProjectDao extends BaseDao<Project>{

	List<ProjectDto> getProjectByStatusId(Long bugStatusId);

//	ProjectDto getProjectByStatusId(Long bugStatusId);
}
