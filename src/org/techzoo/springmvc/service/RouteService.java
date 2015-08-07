package org.techzoo.springmvc.service;

import java.util.List;

import org.techzoo.springmvc.form.Route;

public interface RouteService {
	
	public void addRoute(Route route);
	public void updateRoute(Route route);
	public Route getRouteById(Integer id);
	public List<Route> listRoutes();
	public void removeRoute(Integer id);

}
