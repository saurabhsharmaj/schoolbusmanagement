package org.techzoo.springmvc.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.techzoo.springmvc.common.Utils;
import org.techzoo.springmvc.form.TransportMapping;
import org.techzoo.springmvc.form.User;
import org.techzoo.springmvc.service.BusDetailService;
import org.techzoo.springmvc.service.RegistrationService;
import org.techzoo.springmvc.service.TransportMappingService;

import com.google.gson.Gson;

@Controller
public class TransportAssignController {
	
	@Autowired
	private TransportMappingService transportMappingService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private BusDetailService busDetailService;
		
	@RequestMapping(value="transportMappingList")
	public String listTransportMappings(Map<String, Object> map) {
		map.put("transportMapping", new TransportMapping());
		map.put("transportMappingList", transportMappingService.listTransportMappings());
		map.put("userList", Utils.getUserList(registrationService));		
		map.put("busStopList", Utils.getBusStopList(busDetailService));
		map.put("streamList", Utils.referenceStreamData());
		map.put("yearList", Utils.referenceYearData());
		map.put("semesterList", Utils.referenceSemesterData());
		
		return "transportMappingList";
	}

	@RequestMapping(
		value = "/transportMapping/add",
		method = RequestMethod.POST
	)
	public String addTransportMapping(@ModelAttribute("TransportMapping") 
		TransportMapping transportMapping, BindingResult result) 
	{
		transportMapping.setBusDetail(busDetailService.getBusDetailById(transportMapping.getBusDetail().getId()));
		transportMapping.setUser(registrationService.getUserById(transportMapping.getUser().getId()));
		if(null == transportMapping.getId()) {
			transportMappingService.addTransportMapping(transportMapping);	
		}
		else {
			transportMappingService.updateTransportMapping(transportMapping);
		}
		return "redirect:/transportMappingList";
	}

	@RequestMapping("/deleteTransportMapping/{id}")
	public String deleteTransportMapping(
		@PathVariable("id") Integer id)
	{
		transportMappingService.removeTransportMapping(id);
		return "redirect:/transportMappingList";
	}

	@RequestMapping("/editTransportMapping/{id}")
	public String editTransportMapping(
		@PathVariable("id")Integer id,
		Map<String, Object> map)
	{
		map.put("transportMapping", transportMappingService.getTransportMappingById(id));
		map.put("transportMappingList", transportMappingService.listTransportMappings());
		map.put("userList", Utils.getUserList(registrationService));
		map.put("busStopList", Utils.getBusStopList(busDetailService));
		map.put("streamList", Utils.referenceStreamData());
		map.put("yearList", Utils.referenceYearData());
		map.put("semesterList", Utils.referenceSemesterData());
		return "transportMappingList";
	}
	
	@RequestMapping("/getUserByCriteria/{departmentId}/{year}/{semester}")
	public @ResponseBody String getUserByCriteria(
			@PathVariable("departmentId") Integer deptId,@PathVariable("year") Integer year,@PathVariable("semester") Integer semester)
	{
		//transportMappingService.removeTransportMapping(id);
		System.out.println(deptId+" : "+year+" : "+semester);
		StringBuilder buildString = new StringBuilder();
		
		for (User user : registrationService.listUsers(deptId,year,semester)) {
				if(StringUtils.isBlank(buildString.toString())){
					buildString.append("{'id':'")
					.append(user.getId()).append("','name':'")
					.append(user.getFname() +" "+user.getLname()).append("'")
					.append("}");
				} else {
					buildString.append(",{'id':'")
					.append(user.getId()).append("','name':'")
					.append(user.getFname() +" "+user.getLname()).append("'")
					.append("}");
				}
		}
 System.out.println(buildString);
		if(StringUtils.isEmpty(buildString.toString())){
			buildString.append("{'id':'-1'").append(",'name':'-No Name-'}");
		}
		
		String select = "{"+buildString.toString()+"}";
		System.out.println(select);
		return select;
	}
}