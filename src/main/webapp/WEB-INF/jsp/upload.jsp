<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<div class="container">
  		<div class="row>
  			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="POST" enctype="multipart/form-data" action="/upload">
					<input type="file" name="file">
					
					<div class="form-group">
						<label for="name" class="col-md-1">File name:</label>
						<div class="col-md-4">
							<input type="text" name="name" id="name" class="form-control">
						</div> 
					</div>
					<div class="form-group">
						<label for="name" class="col-md-1">Owner</label>
						<div class="col-md-4">
							<select class="form-control">
								<c:forEach var="user" items="${users}">
									<option>${user.username}</option>
								</c:forEach>
							</select>				
						</div> 
					</div>
					<form:select path="user" items="${users}"></form:select>
					<!-- <input type="submit" value="Upload"> -->
					<button type="submit" value="Upload" class="btn btn-danger">Upload</button>
				</form>
				<c:forEach items="${users}" var="u">
					<div class="panel panel-danger">
						<div> ${u.username}</div>
						<div>${u.deleted}</div>
						<div>${u.created}</div>
						<div>${u.admin}</div>
						<br />
					</div>
				</c:forEach>
				
				${users}
			</div>
		</row>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>



