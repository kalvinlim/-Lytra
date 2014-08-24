<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<body>
	<form method="POST" enctype="multipart/form-data" action="/upload">
		File to upload: <input type="file" name="file">
		<br /> Name: <input	type="text" name="name"><br /> <br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
</body>
</html>