package com.bugReport.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bugReport.dao.UserDao;
import com.bugReport.domain.User;
import com.bugReport.dto.UserDto;
import com.bugReport.transformer.UserTransformer;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Autowired
	UserTransformer userTransformer;

	@Override
	public List<UserDto> getUsersByDesignationId(Long designationId) {

		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.createAlias("designation", "designation")
				.add(Restrictions.eq("designation.designationId", designationId));

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) criteria.list();
		List<UserDto> userDtos = null;

		if (users != null && users.size() > 0) {
			userDtos = new ArrayList<UserDto>();
			for (User user : users) {
				UserDto userDto = userTransformer.transform(user);
				userDtos.add(userDto);
			}
		}
		return userDtos;

	}

	@Override
	@Transactional
	public List<UserDto> addNewUsers(List<UserDto> userDtos) {

		List<UserDto> users = null;
		users = new ArrayList<UserDto>();

		for (UserDto userDto : userDtos) {
			User user = userTransformer.reverseTransform(userDto);
			user = saveOrUpdate(user);
			userDto = userTransformer.transform(user);
			users.add(userDto);
		}

		return users;

	}

}
