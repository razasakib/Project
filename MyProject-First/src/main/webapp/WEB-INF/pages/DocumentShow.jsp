<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload</title>
</head>
<body>
	<h3 align="center">Welocme To Document Upload Page</h3>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
ID: <input type="text" name="fileId">

Document<input type="file" name="fileOb">

<input type="submit" value="UPLOAD">
</pre>
	</form>
		${message }
</body>
</html> 