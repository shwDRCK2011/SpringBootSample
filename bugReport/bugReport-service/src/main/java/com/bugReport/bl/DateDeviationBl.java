/*package com.bugReport.bl;

import org.springframework.stereotype.Service;

@Service
public class DateDeviationBl {

	BugDto bugDto;

	DateDeviationDto dateDeviationDto;

	@Autowired
	BugDao bugDao;

	@Autowired
	BugsTransformer bugTransformer;

	public List<DateDeviationDto> getDateDeviation(String bugStatus) {

		List<BugDto> bugDtos = bugDao.getDeviationOfBugs(bugStatus);
		 List<BugDao> 
		List<DateDeviationDto> dateDeviationDtos = null;

		if (bugDtos != null) {
			dateDeviationDtos = new ArrayList<DateDeviationDto>();
			for (BugDto bugDto : bugDtos) {
				// DateDeviationDto dateDeviation = new DateDeviationDto();
				Date date = new Date();
				dateDeviationDto.getBugDto().getBugId();
				
				 * dateDeviation.getDateDeviation(); dateDeviationDtos.add(bugDto);
				 
				DateDeviationDto deviation = (date - bugDto.getBugExpectedEndDate())
						/ (bugDto.getBugExpectedEndDate() - bugDto.getBugStartDate()) * 100;
				dateDeviationDtos.add(deviation);
			}

		}

		return dateDeviationDtos;

	}

}
*/