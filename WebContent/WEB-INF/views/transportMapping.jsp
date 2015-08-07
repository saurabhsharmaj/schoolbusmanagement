<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$( document ).ready(function() {
	$("select#department").change(function(){
         $.getJSON("getUserByCriteria/"+$('#department').val()+"/"+$('#year').val()+"/"+$('#semester').val(), function(j){
         console.log(j);
              var options = '';
              for (var i = 0; i < j.length; i++) {
                options += '<option value="' + j[i].id + '">' + j[i].name + '</option>';
              }
              $("select#user").html(options);
            });
        });

	$("select#year").change(function(){
         $.getJSON("getUserByCriteria/"+$('#department').val()+"/"+$('#year').val()+"/"+$('#semester').val(), function(j){
         console.log(j);
              var options = '';
              for (var i = 0; i < j.length; i++) {
                options += '<option value="' + j[i].id + '">' + j[i].name + '</option>';
              }
              $("select#user").html(options);
            });
        });
        
        $("select#semester").change(function(){
         $.getJSON("getUserByCriteria/"+$('#department').val()+"/"+$('#year').val()+"/"+$('#semester').val(), function(j){
         console.log(j);
              var options = '';
              for (var i = 0; i < j.length; i++) {
                options += '<option value="' + j[i].id + '">' + j[i].name + '</option>';
              }
              $("select#user").html(options);
            });
        });
  });
</script>
<fieldset>
  	<legend>Bus Detail</legend>
<p style="color:green;font-weight:bold;">To add a New Bus Detail please click <a href="<c:url value='/transportMappingList' />" >
	<img src="<c:url value='/images/vcard_add.png' />" title="Assign Bus to User"/>
</a>
</p>
<c:url var="action" value="/transportMapping/add.html" ></c:url>

<form:form method="post" action="${action}" commandName="transportMapping" cssClass="bookForm">
	<table>
		<c:if test="${!empty transportMapping.user.id}">
		<tr>
			<td>
				<form:label path="id" cssClass="userNameLabel">
					<spring:message code="label.transport_mapping_id" />
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
			<form:label path="user.department" cssClass="nameLabel">
				<spring:message code="label.department" />
			</form:label>
		</td>
		<td colspan="2">
			<form:select id="department" path="user.department">
						<form:option value="0" label="-Select department-"/>			
					    <form:options items="${streamList}" />
					</form:select>
		</td> 	
		
		<td >			
			<form:select id="year" path="user.year">
						<form:option value="0" label="-Select Year-"/>			
					    <form:options items="${yearList}" />
					</form:select>
					
		</td> 
		<td >
					<form:select id="semester" path="user.semester">
						<form:option value="0" label="-Select Semester-"/>			
					    <form:options items="${semesterList}" />
					</form:select>
		</td> 
	</tr>
		<tr>
			<td>
				<form:label path="user.id" cssClass="nameLabel">
					<spring:message code="label.choose_user_name" />
				</form:label>
			</td>
			<td colspan=3>
				<form:select id="user" path="user.id">
					<form:option value="0" label="-Select User-"/>			
				    <form:options items="${userList}" />
				</form:select>
			</td> 
		</tr>
	
		<tr>
			<td>
				<form:label path="busDetail.id" cssClass="nameLabel">
					<spring:message code="label.choose_bus_stop_name" />
				</form:label>
			</td>
			<td colspan=3>
				<form:select id="busStop" path="busDetail.id">
					<form:option value="0" label="-Select Bus Stop-"/>			
				    <form:options items="${busStopList}" />
				</form:select>
			</td> 
		</tr>
	
		<tr>
		<td>
			<form:label path="fees" cssClass="nameLabel">
				<spring:message code="label.fee" />
			</form:label>
		</td>
		<td>
			<form:input path="fees" placeholder="Enter fees"/>
		</td>				 
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.id}">
				<input type="submit"
					value="<spring:message code="label.edit_transport_assignmenmt_detail"/>" />
			</c:if>
			<c:if test="${empty user.id}">
				<input type="submit"
					value="<spring:message code="label.add_transport_assignmenmt_detail"/>" />
			</c:if>
		</td>
	</tr>
	
	</table>
</form:form>
</fieldset>
<c:if test="${!empty transportMappingList}">
<fieldset>
  	<legend>List of Transport Assignment</legend>
	<table class="bookTable">
	<tr>
		<th width="60">Id</th>
		<th width="160">Name</th>
		<th width="160">Bus Stop Name</th>
		<th width="160">Fees</th>	
		<th width="60">Action</th>
	</tr>
	<c:forEach items="${transportMappingList}" var="transportMapping">
		<tr>
			<td>${transportMapping.id}</td>
			<td><a href="<c:url value='/editTransportMapping/${transportMapping.id}' />" >${transportMapping.user.fname}&nbsp;${transportMapping.user.lname}</a></td>					
			<td>${transportMapping.busDetail.busStopName}</td>
			<td>${transportMapping.fees}</td>
			<td><img src="<c:url value='/images/vcard_delete.png' />"
				title="Delete Bus Stop"
				onclick="javascript:deleteTransportAssignment(${transportMapping.id})" />
				<a href="<c:url value='/editTransportMapping/${transportMapping.id}' />"  >
					<img src="<c:url value='/images/vcard_add.png' />" title="Edit Transport Assignment"/>
				</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</fieldset>
</c:if>

