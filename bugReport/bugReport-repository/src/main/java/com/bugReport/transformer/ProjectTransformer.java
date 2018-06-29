package com.bugReport.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugReport.domain.Bug;
import com.bugReport.domain.Project;
import com.bugReport.dto.BugDto;
import com.bugReport.dto.ProjectDto;

@Service
public class ProjectTransformer implements BaseTransformer<Project, ProjectDto> {

	@Autowired
	BugsTransformer bugsTransformer;

	@Autowired
	BugStatusTransformer bugStatusTransformer;

	public ProjectDto transform(Project project) {
		ProjectDto projectDto = new ProjectDto();
		projectDto.setProjectId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		List<Bug> bugs = project.getBugs();
		List<BugDto> bugDtos = null;
		if (bugs != null && bugs.size() > 0) {
			bugDtos = new ArrayList<BugDto>();
			for (Bug bug : bugs) {
				bugDtos.add(bugsTransformer.transform(bug));
			}
		}
		projectDto.setBugDto(bugDtos);

		return projectDto;

	}

	@Override
	public Project reverseTransform(ProjectDto projectsDto) {
		Project project = new Project();
		project.setProjectId(projectsDto.getProjectId());
		project.setProjectName(projectsDto.getProjectName());
		// project.setBugs(bugsTransformer.reverseTransform(projectsDto.getBugDto()));
		return project;

	}

}
