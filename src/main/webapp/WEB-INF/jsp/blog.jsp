<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="alpha-navbar" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="alpha-slideshow-bg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-navbar" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-head" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-navbar-left" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="blogPostPanel" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<alpha-head:alpha-head></alpha-head:alpha-head>
<body>
	<div class="wrapper">
		<div class="box">
			<div class="row">
				<alpha-navbar:alpha-navbar></alpha-navbar:alpha-navbar>
				<alpha-head:alpha-navbar-left></alpha-head:alpha-navbar-left>
				<!-- main -->
				<div class="column col-sm-10" id="main">
					<%-- <alpha-slideshow-bg:alpha-slideshow-bg></alpha-slideshow-bg:alpha-slideshow-bg> --%>
					<!-- /padding -->
					<div class="padding">
						<!-- body content here -->
							<div class="containerCenter opaque clearfix">
								<blogPostPanel:blogPostPanel></blogPostPanel:blogPostPanel>
							</div>
						<!-- /body content here -->
					</div>
					<!-- /padding -->
				</div>
				<!-- /main -->
			</div>
		</div>
	</div>
	<!-- /.container -->

	<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
	<script src="js/vendor/bootstrap.min.js"></script>
</body>
<script>
	$(function() {
    	$("#login-submit").click(function(){
    		var loginForm = $("#login-form").serializeArray();
    		console.log(loginForm);
    		//console.log($("#newPostForm").serializeArray());
     		$.post( "/login", loginForm, function( data ) {
     			location.reload(); 
			});
    		 
    	});
	});
</script>
</html>
