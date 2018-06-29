package com.bugReport.service;

import com.bugReport.dto.ResponseDto;

public interface ProjectService {

	ResponseDto getProjectByStatusId(Long bugStatusId);
}
