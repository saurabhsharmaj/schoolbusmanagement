package org.techzoo.springmvc.common;

import java.util.LinkedHashMap;
import java.util.Map;

import org.techzoo.springmvc.form.BusDetail;
import org.techzoo.springmvc.form.Route;
import org.techzoo.springmvc.form.User;
import org.techzoo.springmvc.service.BusDetailService;
import org.techzoo.springmvc.service.RegistrationService;
import org.techzoo.springmvc.service.RouteService;

public class Utils {

	public static Map<String,String> referenceStreamData(){
		Map<String,String> semester = new LinkedHashMap<String,String>();
		semester.put("1", "Civil engineering");
		semester.put("2", "Computer Science");
		semester.put("3", "Electronics & Communication engineering");
		semester.put("4", "Electrical engineering");
		semester.put("5", "Information Technology");
		semester.put("6", "Mechanical engineering");
		return semester;
	}

	public static Map<String,String> referenceYearData(){
		Map<String,String> semester = new LinkedHashMap<String,String>();
		semester.put("1", "First Year");
		semester.put("2", "Second Year");
		semester.put("3", "Third Year");
		semester.put("4", "Fourth Year");
		return semester;
	}

	public static Map<String,String> referenceSemesterData(){
		Map<String,String> semester = new LinkedHashMap<String,String>();
		semester.put("1", "I");
		semester.put("2", "II");
		semester.put("3", "III");
		semester.put("4", "IV");
		semester.put("5", "V");
		semester.put("6", "VI");
		semester.put("7", "VII");
		semester.put("8", "VII");
		return semester;
	}

	public static Map<String,String> referenceRoleData(){
		Map<String,String> semester = new LinkedHashMap<String,String>();
		semester.put("1", "ADMIN");
		semester.put("2", "Teacher");
		semester.put("3", "Student");
		return semester;
	}

	public static Map<Integer,String> getBusDetails(RouteService routeService) {

		Map<Integer,String> routeList = new LinkedHashMap<Integer,String>();
		for (Route route : routeService.listRoutes()) {
			routeList.put(route.getId(), route.getRouteName());
		}
		return routeList;
	}
	
	public static Map<Integer,String> getUserList(RegistrationService registrationService) {

		Map<Integer,String> userList = new LinkedHashMap<Integer,String>();
		for (User user : registrationService.listUsers()) {
			userList.put(user.getId(), user.getFname() +" "+user.getLname());
		}
		return userList;
	}
	
	
	public static Map<Integer,String> getBusStopList(BusDetailService busDetailService) {

		Map<Integer,String> busDetailList = new LinkedHashMap<Integer,String>();
		for (BusDetail busDetail : busDetailService.listBusDetails()) {
			busDetailList.put(busDetail.getId(), busDetail.getBusStopName());
		}
		return busDetailList;
	}

	public static String getDepartmentName(String department) {
		return referenceStreamData().get(department);
	}

	public static String getYearName(String year) {
		return referenceYearData().get(year);
	}

	public static String getSemesterName(String semesterName) {
		return referenceSemesterData().get(semesterName);
	}

	public static String getRoleName(String role) {
		return referenceRoleData().get(role);
	}
	
}
