<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="blogPostPanel" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="alpha-head" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="alpha-navbar" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="alpha-navbar-left" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="alpha-navbar-right" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="alpha-slideshow-bg" tagdir="/WEB-INF/tags"%>
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
	<%-- <alpha-slideshow-bg:alpha-slideshow-bg></alpha-slideshow-bg:alpha-slideshow-bg> --%>
	<alpha-head:alpha-navbar-left></alpha-head:alpha-navbar-left>
	<div class="containerCenter opaque clearfix">
		<div id="wowslider-container1">
			<div class="ws_images">
				<ul>
					<li><img src="img/bg_dynamic/6.jpg" alt="6" title="6"
						id="wows1_0" /></li>
					<li><img src="img/bg_dynamic/1.jpg" alt="1" title="1"
						id="wows1_1" /></li>
					<li><img src="img/bg_dynamic/2.jpg" alt="2" title="2"
						id="wows1_2" /></li>
					<li><img src="img/bg_dynamic/3.jpg" alt="3" title="3"
						id="wows1_3" /></li>
					<li><img src="img/bg_dynamic/4.jpg" alt="4" title="4"
						id="wows1_4" /></li>
					<li><img src="img/bg_dynamic/5.jpg" alt="5" title="5"
						id="wows1_5" /></li>
				</ul>
			</div>
			<div class="ws_thumbs">
				<div>
					<a href="#" title="6"><img src="img/slider_thumbs/6.jpg" alt="" /></a>
					<a href="#" title="1"><img src="img/slider_thumbs/1.jpg" alt="" /></a>
					<a href="#" title="2"><img src="img/slider_thumbs/2.jpg" alt="" /></a>
					<a href="#" title="3"><img src="img/slider_thumbs/3.jpg" alt="" /></a>
					<a href="#" title="4"><img src="img/slider_thumbs/4.jpg" alt="" /></a>
					<a href="#" title="5"><img src="img/slider_thumbs/5.jpg" alt="" /></a>
				</div>
			</div>
		</div>

	</div>
	<alpha-head:alpha-navbar-right></alpha-head:alpha-navbar-right>
</body>
</html>
