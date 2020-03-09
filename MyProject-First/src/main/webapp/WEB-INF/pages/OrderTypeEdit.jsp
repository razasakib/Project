<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Order Type Register</h2>
<form:form action="update" method="post" modelAttribute="orderMethodType">
<pre>

Order ID:<form:input path="orderId" readonly="true"/>

Order Mode:<form:radiobutton path="orderMode" value="sale"/> Sale<form:radiobutton path="orderMode" value="purchase"/> Purchase

Order Code	:<form:input path="orderCode"/>			

Order Method:<form:select path="orderMeth">
<form:option value="">--SELECT--</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>

Order Accept:<form:checkbox path="orderAccept" value="Multi-Model"/>Multi-Model<form:checkbox path="orderAccept" value="Accept Return"/>Accept Return

Description : <form:textarea path="orderDesc"/>		


<input type="submit" value="UpdateOrder">
</pre>
</form:form>
${message}
<br><a href="all">All Record</a>
</body>
</html>