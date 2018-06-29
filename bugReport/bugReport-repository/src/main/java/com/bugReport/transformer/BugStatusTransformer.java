package com.bugReport.transformer;

import org.springframework.stereotype.Service;

import com.bugReport.domain.BugStatus;
import com.bugReport.dto.BugStatusDto;

@Service
public class BugStatusTransformer implements BaseTransformer<BugStatus, BugStatusDto> {

	@Override
	public BugStatusDto transform(BugStatus bugStatus) {
		BugStatusDto bugStatusDto = new BugStatusDto();
		bugStatusDto.setBugStatusId(bugStatus.getBugStatusId());
		bugStatusDto.setBugStatus(bugStatus.getBugStatus());
		return bugStatusDto;
	}

	@Override
	public BugStatus reverseTransform(BugStatusDto bugStatusDto) {
		BugStatus bugStatus = new BugStatus();
		bugStatus.setBugStatus(bugStatusDto.getBugStatus());
		bugStatus.setBugStatusId(bugStatusDto.getBugStatusId());
		return bugStatus;
	}

}
