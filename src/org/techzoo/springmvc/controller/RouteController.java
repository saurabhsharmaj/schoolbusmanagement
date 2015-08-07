package org.techzoo.springmvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.techzoo.springmvc.common.Utils;
import org.techzoo.springmvc.form.Route;
import org.techzoo.springmvc.service.RouteService;

@Controller
public class RouteController {
	
	@Autowired
	private RouteService routeService;
		
	@RequestMapping(value="routeList")
	public String listRoutes(Map<String, Object> map) {
		map.put("route", new Route());
		map.put("routeList", routeService.listRoutes());		
		return "routeList";
	}

	@RequestMapping(
		value = "/route/add",
		method = RequestMethod.POST
	)
	public String addRoute(@ModelAttribute("route") 
		Route route, BindingResult result) 
	{
		if(null == route.getId()) {
			routeService.addRoute(route);	
		}
		else {
			routeService.updateRoute(route);
		}
		return "redirect:/routeList";
	}

	@RequestMapping("/deleteroute/{routeId}")
	public String deleteroute(
		@PathVariable("routeId") Integer routeId)
	{
		routeService.removeRoute(routeId);
		return "redirect:/routeList";
	}

	@RequestMapping("/editroute/{routeId}")
	public String editRoute(
		@PathVariable("routeId")Integer routeId,
		Map<String, Object> map)
	{
		map.put("route", routeService.getRouteById(routeId));
		map.put("routeList", routeService.listRoutes());		
		return "routeList";
	}
}