<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome To Uom Data Register</h1>
<c:choose>
<c:when test="${!empty data}">
<table border="1">

<tr>
<td>ID</td>
<td>TYPE</td>
<td>MODEL</td>
<td>DESCRIPTION</td>
<td colspan="3">OPTION</td>
</tr>
<c:forEach items="${data}" var="ob">
<tr>
<td>${ob.uomId}</td>
<td>${ob.uomType}</td>
<td>${ob.uomModel}</td>
<td>${ob.uomDesc }</td>
<td> <a href="delete?uid=${ ob.uomId}">DELETE</a>
<td> <a href="edit?uid=${ ob.uomId}">EDIT</a>
<td> <a href="view?uid=${ ob.uomId}">VIEW</a>
</tr>



</c:forEach>


</table>


</c:when>
<c:otherwise>No Record Found</c:otherwise>

</c:choose>
${message}<br>

<a href="excel">Excel Export</a><br>
<a href="pdf">PDF Export</a>
</body>
</html>