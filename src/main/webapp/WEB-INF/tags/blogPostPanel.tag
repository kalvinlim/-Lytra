<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="blogPostPanel" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${posts}" var="p">
	<div class="panel panel-danger">
		<div class="panel-heading">${p.title}</div>
		<div class="panel-footer">${p.content}</div>
	</div>
</c:forEach>
