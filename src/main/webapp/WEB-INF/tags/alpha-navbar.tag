<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="alpha-navbar" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/alpha">Lytra</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">

				<li id="home" class="${active == 'home' ? 'active' : ''}"><a
					href="/alpha">Home</a></li>
				<li id="about" class="${active == 'about' ? 'active' : ''}"><a
					href="/about">About</a></li>
				<li id="services" class="${active == 'services' ? 'active' : ''}"><a
					href="#">Services</a></li>
				<li id="gallery" class="${active == 'gallery' ? 'active' : ''}"><a
					href="/gallery">Gallery</a></li>
				<li id="blog" class="${active == 'blog' ? 'active' : ''}"><a
					href="/blog">Blog</a></li>
				<li id="contacts" class="${active == 'contacts' ? 'active' : ''}"><a
					href="#">Contacts</a></li>
				<c:if test="${sessionScope.USER_OBJECT.admin == true}">
					<li><a href="/dashboard/blog">Dashboard</a></li>
				</c:if>
				<c:if test="${sessionScope.USER_OBJECT ne null}">
					<li id="contacts" class="${active == 'contacts' ? 'active' : ''}"><a
						href="#">My Photos</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav">
				<c:if test="${sessionScope.USER_OBJECT ne null}">
					<li><a href="#">Logged in as:
							${sessionScope.USER_OBJECT.username}</a></li>
					<li class="active"><a href="/logout">Logout</a></li>
				</c:if>
			</ul>
			<c:if test="${sessionScope.USER_OBJECT eq null}">
				<form class="navbar-form navbar-right" role="form" onsubmit="return false;" id="login-form">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control"	name="username">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control" name="password">
					</div>
					<button type="submit" class="btn btn-success" id="login-submit">Sign in</button>
				</form>
			</c:if>
		</div>
		<!--/.navbar-collapse -->
	</div>
</div>