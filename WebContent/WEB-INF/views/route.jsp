<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset>
  	<legend>Route</legend>
<p style="color:green;font-weight:bold;">To add a New Route please click <a href="<c:url value='/routeList' />" >
	<img src="<c:url value='/images/vcard_add.png' />" title="Add a New Route"/>
</a>
</p>
<c:url var="action" value="/route/add.html" ></c:url>

<form:form method="post" action="${action}" commandName="route" cssClass="bookForm">
	<table>
	<c:if test="${!empty route.routeName}">
	<tr>
		<td>
			<form:label path="id" cssClass="userNameLabel">
				<spring:message code="label.route_id" />
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
			<form:label path="routeName" cssClass="nameLabel">
				<spring:message code="label.route_name" />
			</form:label>
		</td>
		<td>
			<form:input path="routeName" placeholder="route name"/>
		</td>		 
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty route.routeName}">
				<input type="submit"
					value="<spring:message code="label.edit_route"/>" />
			</c:if>
			<c:if test="${empty route.routeName}">
				<input type="submit"
					value="<spring:message code="label.add_route"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</fieldset>
<c:if test="${!empty routeList}">
<fieldset>
  	<legend>List of Routes</legend>
	<table class="bookTable">
	<tr>
		<th width="60">RouteID</th>
		<th width="160">Route Name</th>		
		<th width="60">Action</th>
	</tr>
	<c:forEach items="${routeList}" var="route">
		<tr>
			<td>${route.id}</td>
			<td><a href="<c:url value='/editroute/${route.id}' />" >${route.routeName}</a></td>					
			<td><img src="<c:url value='/images/vcard_delete.png' />"
				title="Delete User"
				onclick="javascript:deleteRoute(${route.id})" />
				<a href="<c:url value='/editroute/${route.id}' />"  >
					<img src="<c:url value='/images/vcard_add.png' />" title="Edit Route"/>
				</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</fieldset>
</c:if>

