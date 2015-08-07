package org.techzoo.springmvc.common;


public enum RoleEnum {
	
	admin(1),teacher(2),student(3);
	
	private Integer roleId;
	private String roleName;
	RoleEnum(int roleId){
		this.roleId = roleId;
		switch(roleId){
		case 1:	
			this.roleName = "Admin";
		break;
		
		case 2:	
			this.roleName = "Teacher";
		break;
		
		case 3:	
			this.roleName = "Student";
		break;
		
		}
	}

	public Integer getRoleId(){
		return this.roleId;
	}

	public String roleName(){
		return this.roleName;
	}
}
