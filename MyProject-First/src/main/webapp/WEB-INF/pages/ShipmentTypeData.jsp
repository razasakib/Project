<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Welcome To Shipment Type Data</h4>
<c:choose>
<c:when test="${!empty list}">
<table border="1">

<tr>
<th>ID</th>
<th>CODE</th>
<th>GARDE</th>
<th>MODE</th>
<th>ENABLE</th>
<th>NOTE</th>
<th colspan="3">Operation</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.shipId}</td>
<td>${ob.shipCode}</td>
<td>${ob.shipGrd}</td>
<td>${ob.shipMod}</td>
<td>${ob.enbShip}</td>
<td>${ob.shipDesc}</td>
<td> <a href="delete?sid=${ob.shipId}">Delete</a>
<td> <a href="edit?sid=${ob.shipId}">Edit</a>
<td> <a href="viewone?sid=${ob.shipId}">View</a>
</tr>

</c:forEach>

</table>

</c:when>

<c:otherwise>
<h4>No Data Found</h4>
</c:otherwise>
</c:choose>
${message}


<a href="excel">Excel Export</a><br>

<br><a href="pdf">PDF Export</a>
</body>
</html>