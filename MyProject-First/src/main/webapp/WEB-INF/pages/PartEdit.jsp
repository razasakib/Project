<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Part Register</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>

	<div class="container">

		<div class="card">
			<div class="card-header  text-center text-black text-uppercase">
				<h2>Welcome to Part Register</h2>
			</div>

			<div class="card-body">


				<form:form action="update" method="post"
					modelAttribute="part">
					<div class="row">
						<div class="col-4">ID
						</div>
						<div class="col-4">
						<form:input path="partId" readonly="true"/>
						</div>
						<div class="col-4"></div>
					</div>
					
					<div class="row">
						<div class="col-4">Code
						</div>
						<div class="col-4">
						<form:input path="code"/>
						</div>
						<div class="col-4"></div>
					</div>
					

					<div class="row">
					<div class="col-2">
					Dimension:
					</div>
					<div class="col-1">
					length:
					</div>
					<div class="col-1">
					<form:input path="length" maxlength="4" size="2"/>
					</div>
					<div class="col-1">
					width:
					</div>
					<div class="col-1">
					<form:input path="width" maxlength="4" size="2"/>
					</div>						
					<div class="col-1">
					height:
					</div>
					<div class="col-1">
					<form:input path="height" maxlength="4" size="2"/>
					</div>
					</div>





					<div class="row">
						<div class="col-4">Base Cost</div>
						<div class="col-4>">
						<form:input path="baseCost"/>
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">Base Courrency</div>
						<div class="col-4>">
					<form:select path="baseCurrency">
					<form:option value="">--SELECT--</form:option>
					<form:option value="INR">INR</form:option>
					<form:option value="USD">USD</form:option>
					<form:option value="AUS">AUS</form:option>
					<form:option value="EURO">EURO</form:option>
					</form:select>
						</div>
						<div class="col-4"></div>
					</div>
					
					<div class="row">
						<div class="col-4">UOM</div>
						<div class="col-4>">
						<form:select path="uom.uomId">
						<form:option value="">--SELECT--</form:option>
						<form:options items="${uomlist}" itemValue="uomId" itemLabel="uomModel"/>
						</form:select>			
						</div>
						<div class="col-4"></div>
					</div>
					

					<div class="row">
						<div class="col-4">Description</div>
						<div class="col-4>">
							<form:textarea path="desc" />
						</div>
						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4>">
							<input type="submit" value="Update Part"> <input
								type="reset" value="Reset">

						</div>
						<div class="col-4"></div>
					</div>
				</form:form>
			</div> <!-- cardboty -->
			<div class="card-footer">
				${message} <a href="all">All Record</a><br>
			</div>
		</div>
		<!-- card close -->
	</div>
	<!-- Close Container -->
</body>
</html>