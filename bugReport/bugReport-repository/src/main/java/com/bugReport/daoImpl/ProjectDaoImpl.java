package com.bugReport.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugReport.dao.ProjectDao;
import com.bugReport.domain.Project;
import com.bugReport.dto.ProjectDto;
import com.bugReport.transformer.ProjectTransformer;

@Repository
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

	@Autowired
	ProjectTransformer projectTransformer;

	@Override
	public List<ProjectDto> getProjectByStatusId(Long bugStatusId) {
				
		Criteria criteria = getCurrentSession().createCriteria(Project.class);
		criteria.createAlias("bugs", "bugs");
		criteria.createAlias("bugs.bugStatus", "bugStatus")
				.add(Restrictions.eq("bugStatus.bugStatusId", bugStatusId));

		ProjectDto projectDto = null;
		@SuppressWarnings("unchecked")
		List<Project> projects = (List<Project>) criteria.list();
		List<ProjectDto> projectDtos = null;
		if (projects != null) {
			
			projectDtos = new ArrayList<ProjectDto>();
			for (Project projectById : projects) {
				projectDto = projectTransformer.transform(projectById);
				projectDtos.add(projectDto);
			}
		}
		return projectDtos;
	}

}
