<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset>
  	<legend>Registration</legend>
<p style="color:green;font-weight:bold;">To add a New Student please click <a href="<c:url value='/userList' />" >
	<img src="<c:url value='/images/vcard_add.png' />" title="Add a New Student"/>
</a>
</p>
<c:url var="action" value="/user/add.html" ></c:url>

<form:form method="post" action="${action}" commandName="user" cssClass="bookForm">
	<table>
	<c:if test="${!empty user.fname}">
	<tr>
		<td>
			<form:label path="id" cssClass="userNameLabel">
				<spring:message code="label.userId" />
			</form:label>
		</td>
		<td colspan="2">
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="fname" cssClass="nameLabel">
				<spring:message code="label.name" />
			</form:label>
		</td>
		<td>
			<form:input path="fname" placeholder="first name"/>
		</td>
		<td>
			Last Name: <form:input path="lname"  placeholder="last name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="department" cssClass="nameLabel">
				<spring:message code="label.department" />
			</form:label>
		</td>
		<td colspan="2">
			<form:select id="department" path="department">
						<form:option value="0" label="-Select department-"/>			
					    <form:options items="${streamList}" />
					</form:select>
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="year" cssClass="nameLabel">
				<spring:message code="label.year" />
			</form:label>
		</td>
		<td >			
			<form:select id="year" path="year">
						<form:option value="0" label="-Select Year-"/>			
					    <form:options items="${yearList}" />
					</form:select>
					
		</td> 
		<td >
			Semester: <form:select id="semester" path="semester">
						<form:option value="0" label="-Select Semester-"/>			
					    <form:options items="${semesterList}" />
					</form:select>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="role" cssClass="nameLabel">
				<spring:message code="label.role" />
			</form:label>
		</td>
		<td colspan="2">
			<form:select id="role" path="role">
						<form:option value="0" label="-Select Role-"/>			
					    <form:options items="${roleList}" />
					</form:select>
		</td> 
	</tr>
	<tr>
	<td colspan=3>
	<fieldset>
  	<legend>Login Details</legend>
		<table>
		<tr>
			<td>
			<form:label path="userProfile.username" cssClass="nameLabel">
				<spring:message code="label.username" />
			</form:label>
			<form:input path="userProfile.username"  placeholder="user name" /></td>
			<td>
			<form:label path="userProfile.password" cssClass="nameLabel">
				<spring:message code="label.password" />
			</form:label>
			<form:input path="userProfile.password"  placeholder="user password" /></td>
		</tr>
		</table>
		</fieldset>
	</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.fname}">
				<input type="submit"
					value="<spring:message code="label.edituser"/>" />
			</c:if>
			<c:if test="${empty user.fname}">
				<input type="submit"
					value="<spring:message code="label.adduser"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</fieldset>
<c:if test="${!empty userList}">
<fieldset>
  	<legend>List of Users</legend>
	<table class="bookTable">
	<tr>
		<th width="60">UserID</th>
		<th width="160">First Name</th>
		<th width="160">Last Name</th>
		<th width="160">Department</th>
		<th width="60">Year</th>
		<th width="160">Semester</th>
		<th width="160">Type</th>
		<th width="60">Action</th>
	</tr>
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.id}</td>
			<td><a href="<c:url value='/edituser/${user.id}' />" >${user.fname}</a></td>
			<td>${user.lname}</td>
			<td>${user.departmentName}</td>
			<td>${user.yearName}</td>
			<td>${user.semesterName}</td>
			<td>${user.roleName}</td>		
			<td><img src="<c:url value='/images/vcard_delete.png' />"
				title="Delete User"
				onclick="javascript:deleteUser(${user.id})" />
				<a href="<c:url value='/edituser/${user.id}' />"  >
					<img src="<c:url value='/images/vcard_add.png' />" title="Edit User"/>
				</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</fieldset>
</c:if>

