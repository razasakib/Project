<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome to Whuser Data Page</h4>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>TYPE</th>
			<th>CODE</th>
			<th>USER FOR</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>ID TYPE</th>
			<th>ID NO</th>
			<th colspan="3">OPTION</th>
		</tr>

		<c:choose>
	<c:when test="${!empty list }">
	<c:forEach items="${list}" var="ob">
	<tr>
	<td>${ob.whuId}</td>
	<td>${ob.whuserTyp}</td>
	<td>${ob.whuCode}</td>
	<td>${ob.whusefor}</td>
	<td>${ob.whuEmail}</td>
	<td>${ob.whucont}</td>
	<td>${ob.whuIdType}</td>
	<td>${ob.whuIdNo}</td>
	<td><a href="delete?wid=${ob.whuId}">DELETE</a>
	<td><a href="edit?wid=${ob.whuId}">EDIT</a>
	<td><a href="view?wid=${ob.whuId}">SHOW</a>
	
	</tr>
	
	</c:forEach>
	</c:when>
	<c:otherwise>
	NO Record Found
	
	</c:otherwise>
		</c:choose>
	</table>
<a href="show">Home</a><br>

<br><h3>${message}</h3><br>
<a href="excel">Excel Export</a><br>

<br><a href="pdf">PDF Export</a>
</body>
</html>