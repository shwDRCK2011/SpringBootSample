package com.bugReport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugReport.dto.BugDto;
import com.bugReport.dto.ResponseDto;
import com.bugReport.service.BugService;

@RestController
@RequestMapping("/bugs")
public class BugController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BugController.class);

	@Autowired
	BugService bugService;

	/*
	 * Retrieve all the bugs
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseDto getAllBugs() {
		LOGGER.info("BugController.getAllBugs()");
		return bugService.getAllBugs();
	}

	/*
	 * Retrieve bug detail by bug ID
	 */
	@RequestMapping(value = "/{bugId}", method = RequestMethod.GET)
	public ResponseDto getAllBugDetails(@PathVariable(value = "bugId") Long bugId) {
		LOGGER.info("BugController.getAllBugDetails()");
		return bugService.getAllBugDetails(bugId);
	}

	@RequestMapping(value = "/getByStausId", method = RequestMethod.GET)
	public ResponseDto getBugsByStatusId(@RequestParam("bugId") Long statusId) {
		LOGGER.info("BugController.getBugsByStatusId()");
		return bugService.getBugsByStatusId(statusId);
	}

	/*
	 * Assign bugs to the users
	 * 
	 */
	@RequestMapping(value = "/addBugDetails", method = RequestMethod.POST)
	public ResponseDto addBugDetails(@RequestBody BugDto bugDto) {
		LOGGER.info("BugController.addBugDetails()");
		return bugService.addBugDetails(bugDto);
	}

	@RequestMapping(value = "/getAllProjectBugs", method = RequestMethod.GET)
	public ResponseDto getAllProjectBugs(@RequestParam("projectId") Long projectId) {
		LOGGER.info("BugController.getProjectBugs()");
		return bugService.getAllProjectBugs(projectId);
	}

}
