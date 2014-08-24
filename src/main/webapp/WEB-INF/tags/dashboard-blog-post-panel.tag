<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="dashboard-blog-post-panel" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${posts}" var="p">
	<div class="panel ${p.published ? 'panel-success' : 'panel-danger'}" blogPostId="${p.id}" published="${p.published}">
		<div class="panel-heading">${p.title}
			<div class="pull-right">
				<button type="button" class="btn btn-xs ${p.published ? 'published' : 'unpublished'} ${p.published ? 'btn-success' : 'btn-danger'}">${p.published ? 'Published' : 'Unpublished'}</button>
				<button type="button" class="btn btn-danger btn-xs deletePost">Delete</button>
			</div>
		</div>
		<div class="panel-footer">${p.content}</div>
	</div>
</c:forEach>
