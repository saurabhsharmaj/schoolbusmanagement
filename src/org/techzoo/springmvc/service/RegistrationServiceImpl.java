package org.techzoo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techzoo.springmvc.dao.Dao;
import org.techzoo.springmvc.form.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired 
	private Dao dao;
	
	@Transactional
	public void addUser(User user) {
		dao.add(user);
	}

	@Transactional
	public void removeUser(Integer id) {
		dao.remove(id);
	}

	@Transactional
	public List<User> listUsers() {
		return dao.list(User.class);
	}

	@Transactional
	public void updateUser(User user) {
		dao.update(user);
	}

	@Transactional
	public User getUserById(Integer userId) {
		return (User) dao.getById(userId,User.class);
	}

	@Override
	public List<User> listUsers(Integer deptId, Integer year, Integer semester) {
		return dao.list(deptId, year, semester,User.class);
	}
}