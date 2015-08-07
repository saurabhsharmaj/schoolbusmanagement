package org.techzoo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techzoo.springmvc.dao.Dao;
import org.techzoo.springmvc.form.Route;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired 
	private Dao dao;
	
	@Transactional
	public void addRoute(Route route) {
		dao.add(route);
	}

	@Transactional
	public void removeRoute(Integer id) {
		dao.remove(dao.getById(id, Route.class));
	}

	@Transactional
	public List<Route> listRoutes() {
		return dao.list(Route.class);
	}

	@Transactional
	public void updateRoute(Route route) {
		dao.update(route);
	}

	@Transactional
	public Route getRouteById(Integer id) {
		return (Route) dao.getById(id,Route.class);
	}
}