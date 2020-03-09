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
<h3>Welcome to WHUser Type Registration</h3>
<form:form action="save" method="post" modelAttribute="whuserType">

<pre>
UserType :- <form:radiobutton path="whuserTyp" value="Vendor"/>Vendor <form:radiobutton path="whuserTyp" value="Customer"/>Customer

Code:-	<form:input path="whuCode"/>

User For:-<form:select path="whusefor">
<form:option value="Purchase">Purchase</form:option>
<form:option value="Sale">Sale</form:option>
</form:select>

Email:-<form:input path="whuEmail"/>

Contact:-<form:input path="whucont"/>

User Id Type: <form:select path="whuIdType">
<form:option value="PanCard">PanCard</form:option>
<form:option value="Aadhar">Aadhar</form:option>
<form:option value="Voter">Voter</form:option>
</form:select>

Id No:<form:input path="whuIdNo"/>

<input type="submit" value="Create User">

</pre>
</form:form>
${message}
<br><a href="all">Show All Record</a>
</body>
</html>