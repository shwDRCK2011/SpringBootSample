package com.bugReport.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugReport.domain.Bug;
import com.bugReport.dto.BugDto;

@Service
public class BugsTransformer implements BaseTransformer<Bug, BugDto> {

	@Autowired
	BugStatusTransformer bugStatusTransformer;
	
	@Autowired
	UserTransformer userTransformer;

	@Override
	public BugDto transform(Bug bugs) {
		BugDto bugDto = new BugDto();
		bugDto.setBugId(bugs.getBugId());
		bugDto.setBugName(bugs.getBugName());
		bugDto.setBugStartDate(bugs.getBugStartDate());
		bugDto.setBugExpectedEndDate(bugs.getBugExpectedToEndDate());
		bugDto.setBugStatusDto(bugStatusTransformer.transform(bugs.getBugStatus()));
//		for (Long userId : ) {
//		bugDto.set
//		}
		return bugDto;
	}

	@Override
	public Bug reverseTransform(BugDto bugsDto) {
		Bug bug = new Bug();
		bug.setBugId(bugsDto.getBugId());
		bug.setBugName(bugsDto.getBugName());
		bug.setBugStartDate(bugsDto.getBugStartDate());
		bug.setBugExpectedToEndDate(bugsDto.getBugExpectedEndDate());
		bug.setBugStatus(bugStatusTransformer.reverseTransform(bugsDto.getBugStatusDto()));
		return bug;
	}

}
