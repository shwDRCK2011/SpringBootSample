package com.bugReport.service;

import com.bugReport.dto.BugDto;
import com.bugReport.dto.ResponseDto;

public interface BugService {
	
	ResponseDto getAllBugs();
	
	ResponseDto getAllBugDetails(Long bugId);

	ResponseDto getBugsByStatusId(Long statusId);

	ResponseDto addBugDetails(BugDto bugDto);

	ResponseDto getAllProjectBugs(Long projectId);
	
//	ResponseDto getDeviationOfBugStatus(String bugStatus);
	
}
