<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Single Part View</title>

</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<div class="row">
					<div class="col-4">
						<h2>Welocme to Part View</h2>
					</div>
				</div>
				
				<div class="card-body">
				<div class="col-4">
					<table border="1">
						<tr>
							<th>ID</th>
							<td>${part.partId}</td>
						</tr>
						<tr>
							<th>CODE</th>
							<td>${part.code}</td>
						</tr>
						<tr>
							<th>WIDTH</th>
							<td>${part.width}</td>

						</tr>
						<tr>
							<th>LENGTHT</th>
							<td>${part.length}</td>
						</tr>

						<tr>
							<th>HEIGHT</th>
							<td>${part.height}</td>

						</tr>
						<tr>
							<th>COST</th>
							<td>${part.baseCost}</td>

						</tr>
						<tr>
							<th>CURRENCY</th>
							<td>${part.baseCurrency}</td>
						</tr>
						<tr>

							<th>UOM</th>
							<td>${part.uom.uomModel}</td>
						</tr>
						<tr>
							<th>NOTE</th>
							<td>${part.desc}</td>
						</tr>
					</table>
				</div>
				</div>
				<div class="card-footer">
					<a href="all">Show All</a> <br> <a href="all">Back</a><br>
					<a href="show">Home</a><br> <a href="excel?oid=${part.partId}">Excel
						Export</a><br> <a href="pdf?oid=${part.partId}">PDF Export</a>

				</div>
				<!-- row -->
			</div>
			<!-- card-footer -->
		</div>
		<!--card close-->
	</div>
	<!-- Container-close -->
</body>
</html>