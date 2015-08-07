package org.techzoo.springmvc.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl<T, PK extends Serializable> implements Dao {

	@Autowired
	private SessionFactory sessionFactory;

	//private Class<T> clazz;


	@Override
	public void add(Object t) {
		sessionFactory.getCurrentSession().save(t);		
	}

	@Override
	public void update(Object t) {
		sessionFactory.getCurrentSession().update(t);		
	}

	@Override
	public List list(Class clazz) {
		return sessionFactory.getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	}

	@Override
	public Object getById(Integer id, Class clazz) {
		return (T) sessionFactory.getCurrentSession().get( clazz, id );
	}


	@Override
	public void remove(Object t) {
		sessionFactory.getCurrentSession().delete(t);		
	}

	@Override
	public List list(Integer deptId, Integer year, Integer semester,
			Class clazz) {
		String sql ;
		StringBuffer buffer = new StringBuffer();
		if(deptId != 0){
			buffer.append("department = "+ deptId);
		}

		if(year != 0){
			if(StringUtils.isNotBlank(buffer.toString())){
				buffer.append("year = "+ year);
			}else {
				buffer.append("AND year = "+ year);
			}
		}

		if(semester !=0){
			if(StringUtils.isNotBlank(buffer.toString())){
				buffer.append("semester = "+ semester);
			} else {
				buffer.append("AND semester = "+ semester);
			}
		}
		if(StringUtils.isNotBlank(buffer.toString())){
			sql  = "from "+ clazz.getName() + " where " + buffer.toString();
		} else {
			sql  = "from "+ clazz.getName();
		}
		return sessionFactory.getCurrentSession().createQuery( sql ).list();
	}



}
