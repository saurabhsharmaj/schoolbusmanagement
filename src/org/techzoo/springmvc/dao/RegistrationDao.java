package org.techzoo.springmvc.dao;

import java.util.List;

import org.techzoo.springmvc.form.User;

public interface RegistrationDao {
	
	public void addUser(User route);
	public void updateUser(User route);
	public List<User> listUsers();
	public User getUserById(Integer userId);
	public void removeUser(Integer id);
	
}
