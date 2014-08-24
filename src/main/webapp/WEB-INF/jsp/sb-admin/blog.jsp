<%@ page language="java" contentType="text/html; chars1et=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="dashboard-sidebar" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="dashboard-blog-post-panel" tagdir="/WEB-INF/tags"%>
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
						New Blog Post <small>Enter Your Data</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="index.html"><i class="fa fa-dashboard"></i>
								Dashboard</a></li>
						<li class="active"><i class="fa fa-edit"></i>Blog</li>
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
							<label>Title</label> <input class="form-control" name="title">
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea name="content" class="form-control" rows="3"></textarea>
						</div>
						<button id="newPostSubmit" type="submit" class="btn btn-success">Submit</button>
						<button type="reset" class="btn btn-info">Cancel</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>

				</div>
			</div>
			<!-- /.row -->
			<br />
			<div class="row">
				<div class="col-lg-6">
				
					<dashboard-blog-post-panel:dashboard-blog-post-panel></dashboard-blog-post-panel:dashboard-blog-post-panel>
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
		
    	$("#newPostSubmit").click(function(){
    		var blogPost = $("#newPostForm").serializeArray();
    		//console.log($("#newPostForm").serializeArray());
    		$.post( "/dashboard/form", blogPost, function( data ) {
   
			});
    		
    	});
    	
    	$(".deletePost").click(function(){
    		//alert("Are you sure you want to delete blog post ");
    		console.log($(this).parents(".panel").attr("blogPostId"));
    	});

    	$(".published").click(function(){
    		var blogPostId = $(this).parents(".panel").attr("blogPostId");
    		var blogPostPublished = $(this).parents(".panel").attr("published");
    		
    		var blogPost = JSON.stringify({id : blogPostId, published : blogPostPublished});
    		console.log(blogPost);
     		/* $.post( "/dashboard/publish", blogPost, function( data ) {
     		   
			}); */ 
		
			var confirmed=confirm("Unpublish this post?");
			if (confirmed==true)
			{
				$.ajax({
	    			  type: "POST",
	    			  url: "/dashboard/unpublish",
	    			  data: blogPost,
	    			  contentType: 'application/json',
	    			  success: function(html) {
	    				  location.reload(); 
	    			  }
	    		});  
			}
    	});
    	
    	$(".unpublished").click(function(){
    		var blogPostId = $(this).parents(".panel").attr("blogPostId");
    		var blogPostPublished = $(this).parents(".panel").attr("published");
    		
    		var blogPost = JSON.stringify({id : blogPostId, published : blogPostPublished});
    		console.log(blogPost);
     		/* $.post( "/dashboard/publish", blogPost, function( data ) {
     		   
			}); */ 
			var confirmed=confirm("Publish this post?");
			if (confirmed==true)
			{
	    		$.ajax({
	    			  type: "POST",
	    			  url: "/dashboard/publish",
	    			  data: blogPost,
	    			  contentType: 'application/json',
	    			  success: function(html) {
	    				  location.reload(); 
	    			  }
	    		});
			}
    	});
	});
	</script>
</body>
</html>