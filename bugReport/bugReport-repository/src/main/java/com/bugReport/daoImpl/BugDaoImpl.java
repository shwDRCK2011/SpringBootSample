package com.bugReport.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugReport.dao.BugDao;
import com.bugReport.dao.UserDao;
import com.bugReport.domain.Bug;
import com.bugReport.domain.BugUser;
import com.bugReport.domain.User;
import com.bugReport.dto.BugDto;
import com.bugReport.transformer.BugsTransformer;

@Repository
public class BugDaoImpl extends BaseDaoImpl<Bug> implements BugDao {

	@Autowired
	BugsTransformer bugTransformer;

	@Autowired
	UserDao userDao;

	@Override
	public List<BugDto> getAllBugs() {
		List<Bug> bugs = (List<Bug>) readAll();
		List<BugDto> bugDtos = null;
		if (bugs != null && bugs.size() > 0) {
			bugDtos = new ArrayList<BugDto>();
			for (Bug bug : bugs) {
				BugDto bugDto = bugTransformer.transform(bug);
				bugDtos.add(bugDto);
			}
		}
		return bugDtos;
	}

	@Override
	public BugDto getAllBugDetails(Long bugId) {
		Bug bugsWithId = read((long) bugId);
		BugDto bugDtos = null;

		if (bugsWithId != null) {
			bugDtos = new BugDto();
			bugDtos = bugTransformer.transform(bugsWithId);
		}
		return bugDtos;
	}

	@Override
	public BugDto getBugsByStatusId(Long statusId) {

		Criteria criteria = getCurrentSession().createCriteria(Bug.class);
		criteria.createAlias("bugStatus", "bugStatus").add(Restrictions.eq("bugStatus.bugStatusId", statusId));
		criteria.setMaxResults(1);

		Bug bug = (Bug) criteria.uniqueResult();
		BugDto bugDto = null;

		if (bug != null) {
			bugDto = bugTransformer.transform(bug);
		}
		return bugDto;
	}

	@Override
	@Transactional
	public BugDto addBugDetails(BugDto bugDto) {

		Bug bug = bugTransformer.reverseTransform(bugDto);

		List<BugUser> bugUsers = null;
		if (bugDto.getUserIds() != null) {
			bugUsers = new ArrayList<BugUser>();

			for (Long userId : bugDto.getUserIds()) {

				User user = userDao.read(userId);
				BugUser bugUser = new BugUser();
				bugUser.setUserId(user);
				bugUser.setBugId(bug);
				bugUsers.add(bugUser);

			}

		}
		bug.setBugUsers(bugUsers);
		bug = saveOrUpdate(bug);
		bugDto = bugTransformer.transform(bug);

		return bugDto;

	}

	@Override
	public BugDto getAllProjectBugs(Long projectId) {

		Criteria criteria = getCurrentSession().createCriteria(Bug.class);
		criteria.createAlias("project", "project").add(Restrictions.eq("project.projectId", projectId));
		criteria.setMaxResults(1);

		Bug bug = (Bug) criteria.uniqueResult();
		BugDto bugDto = null;

		if (bug != null) {
			bugDto = bugTransformer.transform(bug);
		}
		return bugDto;
	}

	@Override
	public List<BugDto> getDeviationOfBugs(String bugStatus) {

		Criteria criteria = getCurrentSession().createCriteria(Bug.class);
		criteria.createAlias("bugStatus", "bugStatus").add(Restrictions.eq("bugStatus.bugStatus", bugStatus));
		@SuppressWarnings("unchecked")
		List<Bug> bugs = (List<Bug>) criteria.list();
		List<BugDto> bugDtos = null;

		if (bugs != null && bugs.size() > 0) {
			bugDtos = new ArrayList<BugDto>();
			for (Bug bug : bugs) {
				BugDto bugDto = bugTransformer.transform(bug);
				bugDtos.add(bugDto);
			}
		}
		return bugDtos;
	}

}
