package com.bugReport.dao;

import java.util.List;

import com.bugReport.domain.Bug;
import com.bugReport.dto.BugDto;


public interface BugDao extends BaseDao<Bug> {

	List<BugDto> getAllBugs();
	
	BugDto getAllBugDetails(Long bugId);

	BugDto getBugsByStatusId(Long statusId);

	BugDto addBugDetails(BugDto bugDto);
	
	BugDto getAllProjectBugs(Long projectId);
	
	List<BugDto> getDeviationOfBugs(String bugStatus);
	
}
