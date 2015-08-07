package org.techzoo.springmvc.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.techzoo.springmvc.common.Utils;
import org.techzoo.springmvc.form.User;
import org.techzoo.springmvc.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
		
	@RequestMapping(value="userList")
	public String listRoutes(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", registrationService.listUsers());
		map.put("streamList", Utils.referenceStreamData());
		map.put("yearList", Utils.referenceYearData());
		map.put("semesterList", Utils.referenceSemesterData());
		map.put("roleList", Utils.referenceRoleData());
		return "userList";
	}

	@RequestMapping(
		value = "/user/add",
		method = RequestMethod.POST
	)
	public String addRoute(@ModelAttribute("user") 
		User user, BindingResult result) 
	{
		if(null == user.getId()) {
			registrationService.addUser(user);	
		}
		else {
			registrationService.updateUser(user);
		}
		return "redirect:/userList";
	}

	@RequestMapping("/deleteuser/{userId}")
	public String deleteUser(
		@PathVariable("userId") Integer userId)
	{
		registrationService.removeUser(userId);
		return "redirect:/userList";
	}

	@RequestMapping("/edituser/{userId}")
	public String editRoute(
		@PathVariable("userId")Integer userId,
		Map<String, Object> map)
	{
		map.put("user", registrationService.getUserById(userId));
		map.put("userList", registrationService.listUsers());
		map.put("streamList", Utils.referenceStreamData());
		map.put("yearList", Utils.referenceYearData());
		map.put("semesterList", Utils.referenceSemesterData());
		map.put("roleList", Utils.referenceRoleData());
		return "userList";
	}
}