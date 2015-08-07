package org.techzoo.springmvc.service;

import java.util.List;

import org.techzoo.springmvc.form.User;

public interface RegistrationService {
	
	public void addUser(User user);
	public void updateUser(User user);
	public User getUserById(Integer userId);
	public List<User> listUsers();
	public List<User> listUsers(Integer deptId, Integer year, Integer semester);
	public void removeUser(Integer id);

}
