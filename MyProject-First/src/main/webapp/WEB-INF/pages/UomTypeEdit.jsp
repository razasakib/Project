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

<h1>Welcome To UOM Register</h1>

<form:form action="update" method="post" modelAttribute="uomType">
<pre>
UOM ID		:<form:input path="uomId" readonly="true"/>

UOM TYPE	:<form:select path="uomType">
<form:option value="">---Select---</form:option>
<form:option value="PACKING">PACKING</form:option>
<form:option value="NO PACKING">NO PACKING</form:option>
<form:option value="---NA---">---NA---</form:option>

</form:select>	

UOM MODEL	:<form:input path="uomModel"/>

DESCRIPTION	:<form:textarea path="uomDesc"/>	

			<input type="submit" value="Update Uom"> 
</pre>

</form:form>

${message}<br>

<a href="all">All Data</a>
</body>
</html>