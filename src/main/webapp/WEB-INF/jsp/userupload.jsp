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
<link rel="stylesheet" href="/css/dropzone.css">
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
#photodropzone{
    border-style: solid;
    border-color: black;
}
</style>
<script src="/js/dropzone.js"></script>
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
				<a class="navbar-brand" href="/dashboard">Lytra Dashboard</a>
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
		
	
				<div class="col-md-12">
					<div class="well">Uploading photos for user: <strong>${user.username}</strong></div>
					<div style="border-color:black">
					<form:form commandName="user" id="photodropzone" class="dropzone" role="form" method="POST" enctype="multipart/form-data" action="/upload">
						<form:input path="id" class="hidden"/>
						
					</form:form>
							
					</div>	
				</div>

				<!----------------------------------------------------------------------------------->


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

