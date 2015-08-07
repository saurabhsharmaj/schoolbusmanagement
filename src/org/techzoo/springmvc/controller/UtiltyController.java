package org.techzoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtiltyController {

	@RequestMapping(value="main.page")
	public String Main() {
		return "home";
	}
	
	@RequestMapping(value="main")
	public String index() {
		return "home";
	}
}