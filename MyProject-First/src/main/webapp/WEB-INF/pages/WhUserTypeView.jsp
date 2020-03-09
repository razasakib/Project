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
<th>ID</th><td>${whuserType.whuId}
</tr>
<tr>
<th>TYPE</th><td>${whuserType.whuserTyp}
</tr>
<tr>
<th>CODE</th><td>${whuserType.whuCode}
</tr>
<tr>
<th>USE FOR</th><td>${whuserType.whusefor}
</tr>
<tr>
<th>EMAIL</th><td>${whuserType.whuEmail}
</tr>
<tr>
<th>CONTACT</th><td>${whuserType.whucont}
</tr>
<tr>
<th>ID TYPE</th><td>${whuserType.whuIdType}
</tr>
<tr>
<th>ID NO</th><td>${whuserType.whuIdNo}
</tr>


</table>

<a href="all">Back</a><br>
<a href="show">Home</a><br>
<a href="excel?id=${omt.orderId}">Excel Export</a>
<a href="pdf?id=${omt.orderId}">PDF Export</a>

</body>
</html>