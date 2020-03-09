<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="wh" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Detail of User</h3>

<table border="1">
<tr>
<th>ID</th><td>${uomType.uomId}
</tr>
<tr>
<th>TYPE</th><td>${uomType.uomType}
</tr>
<tr>
<th>CODE</th><td>${uomType.uomModel}
</tr>
<tr>
<th>USE FOR</th><td>${uomType.uomDesc}
</tr>

</table>

<a href="all">Back</a><br>
<a href="show">Home</a><br>
<a href="excel?uid=${uomType.uomId}">Excel Export</a><br>

<a href="pdf?uid=${uomType.uomId}">PDF Export</a>

</body>
</html>