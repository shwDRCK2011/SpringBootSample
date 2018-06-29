package com.bugReport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugReport.dto.ResponseDto;
import com.bugReport.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/getProjectsByStausId", method = RequestMethod.GET)
	public ResponseDto getProjectByStatusId(@RequestParam("bugStatusId") Long bugStatusId) {
		LOGGER.info("ProjectController.getProjectByStatusId()");
		return projectService.getProjectByStatusId(bugStatusId);
	}
	
}
