<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul style="list-style:none;line-height:28px;">

	<li><spring:url value="/main" var="homeUrl" htmlEscape="true" />
		<a href="${homeUrl}">Home</a>
	</li>
	
	<li><spring:url value="/userList" var="studentManagement" htmlEscape="true" />
		<a href="${studentManagement}">Student Management</a>
	</li>
	
	<li><spring:url value="/routeList" var="routeManager" htmlEscape="true" />
		<a href="${routeManager}">Route Manager</a>
	</li>
	
	<li><spring:url value="/busDetailList" var="busDetailManager" htmlEscape="true" />
		<a href="${busDetailManager}">Bus Detail Manager</a>
	</li>
		
	<li><spring:url value="/transportMappingList" var="transportMapping" htmlEscape="true" />
		<a href="${transportMapping}">Assign Transport</a>
	</li>
	
	<li><spring:url value="/main" var="distanceReport" htmlEscape="true" />
		<a href="${distanceReport}">Report</a>
	</li>
	
	<li><spring:url value="/main" var="liveTracking" htmlEscape="true" />
		<a href="${liveTracking}">Live Tracking</a>
	</li>
	
	
	
</ul>
