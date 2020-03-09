<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<H3>WELCOME TO SHIPMENT TYPE REGISTER</H3>
	
	
<%-- 	<form action="saveship" method="POST">
		<pre>
		
Shipment Mode		:		<select name="shipMod">
<option>------Select------</option>
<option>Air</option>
<option>Truck</option>
<option>Ship</option>
<option>Train</option>
</select>
Shipment Code		:		<input type="text" name="shipCode"/>
Enable Shipment		:		<select name="enbShip">
<option>------Select-----</option>	
<option>Yes</option>
<option>No</option>
</select>
Shipemetn Grade		:		<input type="radio" name="shipGrd" value="A" />A<input type="radio" name="shipGrd" value="B"/>B<input type="radio" name="shipGrd" value="C"/>C
Shipm Description	:		<textarea name="shipDesc"></textarea>

							<input type="submit" value="CREATE SHIPMENT"> 				



</pre>
</form> --%>



	<form:form action="update" method="POST" modelAttribute="shipmentType" >
		<pre>
		
Shipment Mode		:<form:input path="shipId" readonly="true"/>

Shipment Mode		:<form:select path="shipMod">
						<form:option value="">--Select--</form:option>
						<form:option value="Air">Air</form:option>
						<form:option value="Truck">Truck</form:option>
						<form:option value="Ship">Ship</form:option>
						<form:option value="Train">Train</form:option>
						</form:select>


Shipment Code		:	<form:input path="shipCode"/>

Enable Shipment		:	<form:select path="enbShip">
						<form:option value="">Select</form:option>
						<form:option value="Yes">Yes</form:option>
						<form:option value="No">No</form:option>
							</form:select>	


Shipemetn Grade		:	<form:radiobutton path="shipGrd" value="A"/>A
						<form:radiobutton path="shipGrd" value="B"/>B
						<form:radiobutton path="shipGrd" value="C"/>C

Shipm Description	:	<form:textarea path="shipDesc"/>


							<input type="submit" value="Update"> 				



</pre>
</form:form>

<h3>Report</h3>
  ${message} <br>

<a href="all"> Show All Records</a>

</body>
</html>