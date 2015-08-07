<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset>
  	<legend>Bus Detail</legend>
<p style="color:green;font-weight:bold;">To add a New Bus Detail please click <a href="<c:url value='/busDetailList' />" >
	<img src="<c:url value='/images/vcard_add.png' />" title="Add a New Bus Detail"/>
</a>
</p>
<c:url var="action" value="/busdetail/add.html" ></c:url>

<form:form method="post" action="${action}" commandName="busDetail" cssClass="bookForm">
	<table>
	<c:if test="${!empty busDetail.busStopName}">
	<tr>
		<td>
			<form:label path="id" cssClass="userNameLabel">
				<spring:message code="label.bus_detail_id" />
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
			<form:label path="route.id" cssClass="nameLabel">
				<spring:message code="label.choose_route_name" />
			</form:label>
		</td>
		<td colspan=3>
			<form:select id="route" path="route.id">
						<form:option value="0" label="-Select Route-"/>			
					    <form:options items="${routeList}" />
					</form:select>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="busStopName" cssClass="nameLabel">
				<spring:message code="label.bus_stop_name" />
			</form:label>
		</td>
		<td>
			<form:input path="busStopName" placeholder="bus stop name"/>
		</td>
		<td>
			<form:label path="busStopTime" cssClass="nameLabel">
				<spring:message code="label.bus_stop_time" />
			</form:label>
		</td>
		<td>
			<form:input path="busStopTime" id="busStopTime" placeholder="bus stop time" class="time ui-timepicker-input"/>
		</td>		 
	</tr>
	
	<tr>
		<td>
			<form:label path="distance" cssClass="nameLabel">
				<spring:message code="label.bus_stop_distance" />
			</form:label>
		</td>
		<td>
			<form:input path="distance" placeholder="bus stop distance"/> KM
		</td>				 
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty busDetail.busStopName}">
				<input type="submit"
					value="<spring:message code="label.edit_bus_detail"/>" />
			</c:if>
			<c:if test="${empty busDetail.busStopName}">
				<input type="submit"
					value="<spring:message code="label.add_bus_detail"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</fieldset>
<c:if test="${!empty busDetailList}">
<fieldset>
  	<legend>List of Bus Detail</legend>
	<table class="bookTable">
	<tr>
		<th width="60">Bus Detail Id</th>
		<th width="160">Route</th>
		<th width="160">Bus Stop Name</th>
		<th width="160">Bus Stop Time</th>
		<th width="160">Bus Stop Distance</th>		
		<th width="60">Action</th>
	</tr>
	<c:forEach items="${busDetailList}" var="busDetail">
		<tr>
			<td>${busDetail.id}</td>
			<td>${busDetail.route.routeName}</td>
			<td><a href="<c:url value='/editbusdetail/${busDetail.id}' />" >${busDetail.busStopName}</a></td>					
			<td>${busDetail.busStopTime}</td>
			<td>${busDetail.distance}</td>
			<td><img src="<c:url value='/images/vcard_delete.png' />"
				title="Delete Bus Stop"
				onclick="javascript:deleteBusDetail(${busDetail.id})" />
				<a href="<c:url value='/editbusdetail/${busDetail.id}' />"  >
					<img src="<c:url value='/images/vcard_add.png' />" title="Edit Bus Detail"/>
				</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</fieldset>
</c:if>

