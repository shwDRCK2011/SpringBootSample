package com.bugReport.serviceImpl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugReport.constant.MessageConstants;
import com.bugReport.dao.ProjectDao;
import com.bugReport.dto.ProjectDto;
import com.bugReport.dto.ResponseDto;
import com.bugReport.service.ProjectService;
import com.bugReport.service.util.ServiceUtil;

import ch.qos.logback.classic.Logger;

@Repository
public class ProjectServiceImpl implements ProjectService {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	ProjectDao projectDao;

	@Autowired
	ServiceUtil serviceUtil;

	@Override
	public ResponseDto getProjectByStatusId(Long bugStatusId) {

		LOGGER.info("ProjectServiceImpl.getAllProjects execution started.");
		ResponseDto responseDto = null;
		try {
			List<ProjectDto> projectByStatusId = projectDao.getProjectByStatusId(bugStatusId);

			if (projectByStatusId == null) {
				LOGGER.info("Unable to receive the project information by bug status Id.");
				responseDto = serviceUtil.getErrorServiceResponse(
						MessageConstants.ServiceErrorMessages.ERR_PROJECT_DETAILS_BY_STATUS_ID_NOT_FOUND);
			} else {
				LOGGER.info("Project information received.");
				responseDto = serviceUtil.getServiceResponse(projectByStatusId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while recieving the project details");
			responseDto = serviceUtil
					.getExceptionServiceResponseByProperties(MessageConstants.ServiceErrorMessages.EX_PROJECT_DETAILS_BY_STATUS_ID_RETRIEVE);
		}
		return responseDto;
	}

}
