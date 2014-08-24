<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="blogPostPanel" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-head" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-navbar" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-navbar-left" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-navbar-right" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="alpha-slideshow-bg" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<alpha-head:alpha-head></alpha-head:alpha-head>
<body>
	<alpha-navbar:alpha-navbar></alpha-navbar:alpha-navbar>
	<alpha-slideshow-bg:alpha-slideshow-bg></alpha-slideshow-bg:alpha-slideshow-bg>
	<alpha-head:alpha-navbar-left></alpha-head:alpha-navbar-left>
	<div class="row">
	
	</div>
	<div class="containerCenter opaque clearfix">
		
	</div>
	<alpha-head:alpha-navbar-right></alpha-head:alpha-navbar-right>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
<script src="js/vendor/bootstrap.min.js"></script>
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
