package com.bugReport.dto;

import java.io.Serializable;

public class DateDeviationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BugDto bugDto;
	private BugStatusDto bugStatusDto;
	private Double dateDeviation;

	public BugDto getBugDto() {
		return bugDto;
	}

	public void setBugDto(BugDto bugDto) {
		this.bugDto = bugDto;
	}

	public BugStatusDto getBugStatusDto() {
		return bugStatusDto;
	}

	public void setBugStatusDto(BugStatusDto bugStatusDto) {
		this.bugStatusDto = bugStatusDto;
	}

	public Double getDateDeviation() {
		return dateDeviation;
	}

	public void setDateDeviation(Double dateDeviation) {
		this.dateDeviation = dateDeviation;
	}

}
