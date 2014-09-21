<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
body {
	padding-top: 70px;
}
#myModal{
	top:20%;
}

</style>

</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/lytra/dashboard">Lytra Dashboard</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<c:if test="${sessionScope.USER_OBJECT ne null}">
						<li><a href="#">Logged in as:
								${sessionScope.USER_OBJECT.username}</a></li>
						<li class="active"><a href="/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="/lytra">Lytra Home</a></li>
					<li><a href="">Users</a></li>
				</ul>

			</div>
			<div class="col-sm-offset-3 col-md-offset-2 col-md-9">
				<table class="table table-striped table-bordered">
					<tr>
						<th>Username</th>
						<th>Photos</th>
						<th>created</th>
						<th>deleted</th>
						<th>admin</th>
					</tr>
					<c:forEach items="${users}" var="u">
						<tr>
							<th>
								${u.username} 
								<%-- <a href="javascript:void(0)" onclick="edit('${u.id}')">(edit)</a> --%>
								<!-- <a href="javascript:void(0)" class="edituser">(edit)</a> --> 
								<button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#useredit_${u.id}">Edit</button>								
								<input type="text" value="${u.id}" class="id hidden">
								<input type="text" value="${u.username}" class="username hidden">
								<input type="text" value="${u.created}" class="hidden">
								<input type="text" value="${u.deleted}" class="deleted hidden">
								<input type="text" value="${u.admin}" class="admin hidden">
							</th>
							<th>
								<c:choose>
									<c:when test="${u.photos > 0}">     										       									
										<a class="btn btn-primary btn-xs" href="/lytra/dashboard/user/${u.id}">View Photos (${u.photos})</a>
   									 </c:when>
									
									<c:otherwise>
       									 No Photos
   									</c:otherwise>
								</c:choose>
								<a class="btn btn-primary btn-xs" href="/lytra/dashboard/user/upload/${u.id}">Upload Photos</a>
							</th>
							<th>${u.created}</th>
							<th>${u.deleted}</th>
							<th>${u.admin}</th>
						</tr>
					</c:forEach>
				</table>
				<button class="btn btn-warning" data-toggle="modal" data-target="#createuser">Add User</button>
				

				<!------------------ Modals  ------------------------------------->


				<!-- User edits -->
				<c:forEach items="${users}" var="u" varStatus="loop">
					<div class="modal fade" id="useredit_${u.id}" tabindex="-1"	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Edit User</h4>
								</div>
								<form:form class="form-horizontal" role="form" method="POST" action="/dashboard/moduser" commandName='user'>
								
								<div class="modal-body">
										
										<div class="form-group">
											<label for="name" class="col-md-3">User</label>
											<div class="col-md-9">
												${u.username}
											</div>
										</div>
										<div class="form-group">
											<label for="name" class="col-md-3">Admin</label>
											<div class="col-md-9">
												<form:radiobutton path="admin" value="true" /> true
												<form:radiobutton path="admin" value="false" /> false
											</div>
										</div>
										<div class="form-group">
											<label for="name" class="col-md-3">Deleted</label>
											<div class="col-md-9">
												<form:radiobutton path="deleted" value="true" /> true
												<form:radiobutton path="deleted" value="false" /> false												
											</div>
										</div>		 							
																
								
								</div>
								<form:input class="hidden" value="${u.id}" path="id"/>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									<button type="submit" class="btn btn-primary">Save changes</button>
								</div>
								</form:form>
							</div>
						</div>
					</div>
				</c:forEach>
				
				<!-------------------------- create user modal -------------------------------->
				<div class="modal fade" id="createuser" tabindex="-1"
					role="dialog" aria-labelledby="createuser" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Edit User</h4>
							</div>
							<div class="modal-body">
								<form:form class="form-horizontal" role="form" method="POST"
									action="/dashboard/createuser" commandName="user">
									<div class="form-group">
										<label for="username" class="col-md-3">username</label>
										<div class="col-md-9">
											<form:input path="username" class="form-control"
												id="username" placeholder="username" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-3">password</label>
										<div class="col-md-9">
											<form:input path="password" class="form-control"
												id="password" placeholder="password" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-3 col-md-offset-3">
											<button type="submit" class="btn btn-danger">Create
												User</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<!---------------------------------------------------------------------------->
				
				
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$( ".edituser" ).click(function() {
				var id = $(this).siblings('.id').val()
				var username = $(this).siblings('.username').val()
				var deleted = $(this).siblings('.deleted').val()
				var admin = $(this).siblings('.admin').val()
				
				console.log(id);
				console.log(username);
				console.log(deleted);
				console.log(admin);
			});	
		});
		function edit(id){
			
			console.log(   $(this).val()   );
		}
		
	</script>
</body>
</html>

