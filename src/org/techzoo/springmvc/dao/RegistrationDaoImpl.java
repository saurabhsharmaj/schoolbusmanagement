package org.techzoo.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.techzoo.springmvc.form.User;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void removeUser(Integer id) {
		User user = (User)sessionFactory.getCurrentSession()
			.load(User.class, id);
		if(null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		return sessionFactory.getCurrentSession()
			.createQuery("from User").list();
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getUserById(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User b where b.id = :userId")
			.setParameter("userId", userId)
			.list();
		return list.size() > 0 ?(User)list.get(0): null;
	}

}
