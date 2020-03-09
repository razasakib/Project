<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="wh" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment View</title>
</head>
<body>

<h3>Detail of Shipment</h3>

<table border="1">
<tr>
<th>ID</th><td>${shipmentType.shipId}
</tr>
<tr>
<th>MODE</th><td>${shipmentType.shipMod}
</tr>
<tr>
<th>CODE</th><td>${shipmentType.shipCode}
</tr>
<tr>
<th>ENABLE SHIP</th><td>${shipmentType.enbShip}
</tr>
<tr>
<th>GRADE</th><td>${shipmentType.shipGrd}
</tr>
<tr>
<th>NOTE</th><td>${shipmentType.shipDesc}
</tr>


</table>

<a href="all">Back</a><br>
<a href="show">Home</a><br>
<a href="excel?id=${omt.shipId}">Excel Export</a><br>
<a href="pdf?id=${omt.shipId}">PDF Export</a>

</body>
</html>