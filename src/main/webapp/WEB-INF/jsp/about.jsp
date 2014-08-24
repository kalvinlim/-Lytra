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
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<alpha-head:alpha-head></alpha-head:alpha-head>
<body class="body-min">
	<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
	<alpha-navbar:alpha-navbar></alpha-navbar:alpha-navbar>
	<alpha-slideshow-bg:alpha-slideshow-bg></alpha-slideshow-bg:alpha-slideshow-bg>
	<alpha-head:alpha-navbar-left></alpha-head:alpha-navbar-left>
	<div class="containerCenter opaque clearfix">
		<blogPostPanel:blogPostPanel></blogPostPanel:blogPostPanel>
	</div>
	<alpha-head:alpha-navbar-right></alpha-head:alpha-navbar-right>
</body>
</html>
