<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Single Order Page</title>

</head>
<body>
<table border="1">
<tr>
<th>ID </th>	 	<td>${omt.orderId}</td>
</tr>
<tr>
<th>MODE</th> 		<td>${omt.orderMode}</td>
</tr>
<tr>
<th>CODE</th> 		<td>${omt.orderCode}</td>
</tr>
<tr>
<th>ORDER METHOD</th> <td>${omt.orderMeth}</td>
</tr>
<tr>
<th>ORDER ACCEPT</th> 	<td>${omt.orderAccept}</td>
</tr>
<tr>
<th>NOTE</th> 			<td>${omt.orderDesc}</td>
</tr>
</table>
 <a href="all">Show All</a> <br>




<a href="all">Back</a><br>
<a href="show">Home</a><br>
<a href="excel?oid=${omt.orderId}">Excel Export</a><br>
<a href="pdf?oid=${omt.orderId}">PDF Export</a>

</body>
</html>