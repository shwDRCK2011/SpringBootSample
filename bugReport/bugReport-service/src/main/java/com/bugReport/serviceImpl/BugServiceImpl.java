package com.bugReport.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugReport.constant.MessageConstants;
import com.bugReport.dao.BugDao;
import com.bugReport.dto.BugDto;
import com.bugReport.dto.ResponseDto;
import com.bugReport.service.BugService;
import com.bugReport.service.util.ServiceUtil;

@Repository
public class BugServiceImpl implements BugService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BugServiceImpl.class);

	@Autowired
	BugDao bugDao;

	@Autowired
	ServiceUtil serviceUtil;

	@Override
	public ResponseDto getAllBugs() {
		LOGGER.info("BugServiceImpl.getAllBugs() execution started.");
		ResponseDto responseDto = null;
		try {
			List<BugDto> bugs = bugDao.getAllBugs();
			if (bugs != null && bugs.size() > 0) {
				LOGGER.info("Bugs information received.");
				responseDto = serviceUtil.getServiceResponse(bugs);
			} else {
				LOGGER.info("Unable to receive the bugs information.");
				responseDto = serviceUtil
						.getErrorServiceResponse(MessageConstants.ServiceErrorMessages.ERR_BUGS_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while reciving the bugs details.");
			responseDto = serviceUtil
					.getExceptionServiceResponseByProperties(MessageConstants.ServiceErrorMessages.EX_BUGS_RETRIEVE);
		}

		return responseDto;
	}

	@Override
	public ResponseDto getAllBugDetails(Long bugId) {
		LOGGER.info("BugServiceImpl.getBugDetails() execution started.");
		ResponseDto responseDto = null;
		try {
			BugDto bugsById = bugDao.getAllBugDetails(bugId);

			if (bugsById == null) {
				LOGGER.info("Unable to receive the bugs information by Id.");
				responseDto = serviceUtil
						.getErrorServiceResponse(MessageConstants.ServiceErrorMessages.ERR_BUG_DETAILS_BY_ID_NOT_FOUND);
			} else {
				LOGGER.info("Bugs information received.");
				responseDto = serviceUtil.getServiceResponse(bugsById);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while recieving the bugs");
			responseDto = serviceUtil
					.getExceptionServiceResponseByProperties(MessageConstants.ServiceErrorMessages.EX_BUGS_RETRIEVE);
		}
		return responseDto;
	}

	@Override
	public ResponseDto getBugsByStatusId(Long statusId) {
		LOGGER.info("BugServiceImpl.getBugsByStatusId(Long statusId) execution started.");
		ResponseDto responseDto = null;
		try {
			BugDto statusById = bugDao.getBugsByStatusId(statusId);

			if (statusById == null) {
				LOGGER.info("Unable to receive the bugs information by status Id.");
				responseDto = serviceUtil
						.getErrorServiceResponse(MessageConstants.ServiceErrorMessages.ERR_BUG_NOT_FOUND_BY_STATUS_ID);
			} else {
				LOGGER.info("Bugs information received by statusId {[]}.", statusId);
				responseDto = serviceUtil.getServiceResponse(statusById);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while recieving the bugs by status Id. {[]}", statusId);
			responseDto = serviceUtil.getExceptionServiceResponseByProperties(
					MessageConstants.ServiceErrorMessages.EX_BUG_NOT_FOUND_BY_STATUS_ID);
		}
		return responseDto;
	}

	public ResponseDto addBugDetails(BugDto bugDto) {
		LOGGER.info("BugServiceImpl.addBugDetails() execution started");
		ResponseDto responseDto = null;
		// responseDto = serviceUtil.getServiceResponse(bugService.addBugDetails());
		BugDto addBug = bugDao.addBugDetails(bugDto);
		try {
			if (addBug == null) {
				LOGGER.info("Unable to add the new bug");
				responseDto = serviceUtil
						.getErrorServiceResponse(MessageConstants.ServiceErrorMessages.ERR_BUG_CANNOT_ADD);
			} else {
				LOGGER.info("New bug added");
				responseDto = serviceUtil.getServiceResponse(addBug);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs whil adding new bug");
			responseDto = serviceUtil
					.getExceptionServiceResponseByProperties(MessageConstants.ServiceErrorMessages.EX_ADD_NEW_BUG);
		}

		return responseDto;

	}

	@Override
	public ResponseDto getAllProjectBugs(Long projectId) {
		LOGGER.info("BugServiceImpl.getAllProjectBugs() execution started");
		ResponseDto responseDto = null;

		try {
			BugDto projectBugs = bugDao.getAllProjectBugs(projectId);

			if (projectBugs == null) {
				LOGGER.info("Unable to receive project bugs.");

				responseDto = serviceUtil
						.getErrorServiceResponse(MessageConstants.ServiceErrorMessages.ERR_PROJECT_BUGS_NOT_FOUND);
			} else {
				LOGGER.info("Project bugs recieved.");
				responseDto = serviceUtil.getServiceResponse(projectBugs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occurs while reciving the project bugs details.");
			responseDto = serviceUtil.getExceptionServiceResponseByProperties(
					MessageConstants.ServiceErrorMessages.EX_PROJECT_BUGS_RETRIEVE);
		}
		return responseDto;
	}

	/*
	 * @Override public ResponseDto getDeviationOfBugStatus(String bugStatus) {
	 * LOGGER.info("BugServiceImpl.getDeviationOfPendingStatus() execution started"
	 * ); ResponseDto responseDto = null;
	 * 
	 * try { // List<BugDto> bugDtos = bugDao.getDeviationOfBugs(bugStatus);
	 * List<DateDeviationDto> dateDeviationDtos =
	 * dateDeviationBl.getDateDeviation(bugStatus);
	 * 
	 * if (dateDeviationDtos == null) {
	 * LOGGER.info("Unable to receive pending bugs.");
	 * 
	 * responseDto = serviceUtil
	 * .getErrorServiceResponse(MessageConstants.ServiceErrorMessages.
	 * ERR_BUG_DATE_DEVIATION); } else {
	 * LOGGER.info("Pending bug date deviation recieved."); responseDto =
	 * serviceUtil.getServiceResponse(dateDeviationDtos); } } catch (Exception e) {
	 * e.printStackTrace();
	 * LOGGER.info("Exception occurs while getting deviation of pending bugs.");
	 * responseDto = serviceUtil.getExceptionServiceResponseByProperties(
	 * MessageConstants.ServiceErrorMessages.EX_BUG_DATE_DEVIATION); } return
	 * responseDto; }
	 */
}
