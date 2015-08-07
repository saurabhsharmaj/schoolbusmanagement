
<head>
	<title>School Bus Management System</title>
	<style type="text/css">
		body {
			font-family: verdana;
			font-size: 12px;
			margin: 40px;
		}
		.bookTable, .bookTable td {
			border-collapse: collapse;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px 2px 2px 10px;
			font-size: 12px;
		}
		.bookTable th {
			font-weight: bold;
			font-size: 12px;
			background-color: #5C82FF;
			color: white;
		}
		.bookLabel {
			font-family: verdana;
			font-size: 12px;
			font-weight: bold;
		}
		a, a:AFTER {
			color: blue;
		}
	</style>
	<script type="text/javascript">
	$( document ).ready(function() {
		$('#busStopTime').timepicker({ 'timeFormat': 'h:i A' });
	});
		
	function deleteUser(userId){
		if(confirm('Do you want to delete this User ?')){
			var url = 'deleteuser/'+userId;
			window.location.href = url;
		}
	}
	
	function deleteRoute(id){
		if(confirm('Do you want to delete this Route ?')){
			var url = 'deleteroute/'+id;
			window.location.href = url;
		}
	}
	
	function deleteBusDetail(id){
		if(confirm('Do you want to delete this Bus Detail ?')){
			var url = 'deletebusdetail/'+id;
			window.location.href = url;
		}
	}
	</script>
</head>

<div class="span-24">
	<img src="${pageContext.request.contextPath}/resources/images/techzoo-header.png" 
		width="950" style="border-radius: 10px;" />
</div>