<%@ page language="java" contentType="text/html; chars1et=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="dashboard-sidebar" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="dashboard-blog-post-panel" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Forms - SB Admin</title>

<!-- Bootstrap core CSS -->
<link href="/sb-admin/css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="/sb-admin/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="/sb-admin/font-awesome/css/font-awesome.min.css">
</head>

<body>
	<div id="wrapper">
		<dashboard-sidebar:dashboard-sidebar></dashboard-sidebar:dashboard-sidebar>
		<div id="page-wrapper">
		
			<div class="row">
				<div class="col-lg-12">
					<h1>
						Users
					</h1>
					<ol class="breadcrumb">
						<li><a href="index.html"><i class="fa fa-dashboard"></i>
								Dashboard</a></li>
						<li class="active"><i class="fa fa-edit"></i>Users</li>
					</ol>
					<div class="alert alert-success alert-dismissable">
  						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
  						 <span class="fa fa-check"></span>  <strong>New Blog Post successfully submitted</strong>
					</div>

				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6">
					<form role="form" id="newPostForm" onsubmit="return false;">
						<div class="form-group">
							<label>Username</label> <input class="form-control" name="username">
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" name="password" class="form-control" rows="3"></input>
						</div>
						<button id="newUserSubmit" type="submit" class="btn btn-success">Submit</button>
						<button type="reset" class="btn btn-info">Cancel</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>

				</div>
			</div>
			<!-- /.row -->
			<br />
			<div class="row">
				<div class="col-lg-6">
				sessionscope: ${sessionScope.USER_OBJECT}
					<c:forEach items="${users}" var="p">
						<div class="panel ${!p.deleted ? 'panel-success' : 'panel-danger'}">
							<div class="panel-heading">${p.username}
								<div class="pull-right">
									<button type="button" class="btn btn-xs ${p.deleted ? 'inactive' : 'active'} ${!p.deleted ? 'btn-success' : 'btn-danger'}">${p.deleted ? 'Inactive' : 'Active'}</button>
									<button type="button" class="btn btn-danger btn-xs deletePost">Delete</button>
								</div>
							</div>
							<div class="panel-footer"></div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- JavaScript -->
	<script src="/sb-admin/js/jquery-1.10.2.js"></script>
	<script src="/sb-admin/js/bootstrap.js"></script>
	<script>
	$(function() {
		
    	$("#newUserSubmit").click(function(){
    		var user = $("#newPostForm").serializeArray();
    		console.log(user);
    		//console.log($("#newPostForm").serializeArray());
    		$.post( "/dashboard/createuser", user, function( data ) {
			});
    		
    	});
    	

	});
	</script>
</body>
</html>