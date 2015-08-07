package org.techzoo.springmvc.form;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.techzoo.springmvc.common.Utils;

@Entity
@Table(name = "User", schema = "school_bus_management_system")
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="year")
	private Integer year;

	@Transient
	private String yearName;
	
	@Column(name="department")
	private String department;
	
	@Transient
	private String departmentName;
	
	@Column(name="semester")
	private Integer semester;
	
	@Transient
	private String semesterName;
	
	@Column(name="role")
	private Integer role;

	@Transient
	private String roleName;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private UserProfile userProfile;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	
	public String getDepartmentName() {
		return Utils.getDepartmentName(this.department);
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getYearName() {
		return Utils.getYearName(this.year.toString());
	}

	public String getSemesterName() {
		return Utils.getSemesterName(this.semester.toString());
	}

	public String getRoleName() {
		return Utils.getRoleName(this.role.toString());
	}
	
}
