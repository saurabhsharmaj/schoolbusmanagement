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
import org.techzoo.springmvc.form.BusDetail;
import org.techzoo.springmvc.service.BusDetailService;
import org.techzoo.springmvc.service.RouteService;

@Controller
public class BusDetailController {
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private BusDetailService busDetailService;
		
	@RequestMapping(value="busDetailList")
	public String listBusDetails(Map<String, Object> map) {
		map.put("busDetail", new BusDetail());
		map.put("routeList", Utils.getBusDetails(routeService));
		map.put("busDetailList", busDetailService.listBusDetails());		
		return "busDetailList";
	}

	@RequestMapping(
		value = "/busdetail/add",
		method = RequestMethod.POST
	)
	public String addBusDetail(@ModelAttribute("busDetail") 
		BusDetail busDetail, BindingResult result) 
	{
		if(null == busDetail.getId()) {
			busDetailService.addBusDetail(busDetail);	
		}
		else {
			busDetailService.updateBusDetail(busDetail);
		}
		return "redirect:/busDetailList";
	}

	@RequestMapping("/deletebusdetail/{id}")
	public String deleteBusDetail(
		@PathVariable("id") Integer id)
	{
		busDetailService.removeBusDetail(id);
		return "redirect:/busDetailList";
	}

	@RequestMapping("/editbusdetail/{id}")
	public String editBusDetail(
		@PathVariable("id")Integer id,
		Map<String, Object> map)
	{
		map.put("busDetail", busDetailService.getBusDetailById(id));
		map.put("busDetailList", busDetailService.listBusDetails());
		map.put("routeList", Utils.getBusDetails(routeService));
		return "busDetailList";
	}
}