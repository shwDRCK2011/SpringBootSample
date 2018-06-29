/*package com.bugReport.transformer;

import org.springframework.beans.factory.annotation.Autowired;

import com.bugReport.domain.Bug;
import com.bugReport.dto.BugDto;
import com.bugReport.dto.DateDeviationDto;

public class DateDeviationTransformer implements BaseTransformer<Bug, BugDto> {

	@Autowired
	BugsTransformer bugsTransformer;

	@Override
	public BugDto transform(Bug bugs) {
		BugDto bugDto = new BugDto();
		bugDto.setBugStartDate(bugs.getBugStartDate());
		return bugDto;
	}

	@Override
	public Bug reverseTransform(BugDto bugsDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/