<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
.right {
	text-align: right;
	float: right;
	color: #fff;
	background-color: #17a2b8;
	border-color: #17a2b8;
}
</style>
<meta charset="ISO-8859-1">
<title>Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h2>Welcome TO Part Data Register</h2>
			</div>

			<div class="card-body">

				<a href="excel" class="btn btn-info ">Excel Export</a> <a href="pdf"
					class="btn btn-info right">PDF Export</a>

				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover " border="1">
							<tr class="bg-success text-white">
							<tr>
									<th>ID</th>
									<!-- <th>MODE</th> -->
									<th>CODE</th>
									<th>WIDTH</th>
									<th>LENGTHT</th>
									<th>HEIGHT</th>
									<th>COST</th>
									<th>CURRENCY</th>
									<th>UOM</th>
									<th>NOTE</th>
									
									<th class="text-center" colspan="3">OPTION</th>

							</tr>

							<c:forEach items="${list}" var="ob">


								<tr>
									<td>${ob.partId}</td>
									<td>${ob.code}</td>
									<td>${ob.width}</td>
									<td>${ob.length}</td>
									<td>${ob.height}</td>
									<td>${ob.baseCost}</td>
									<td>${ob.baseCurrency}</td>
									<td>${ob.uom.uomModel}</td>
									<td>${ob.desc}</td>
									<td><a href="delete?pid=${ob.partId }"
										class="btn btn-danger">DELETE</a>
									<td><a href="edit?pid=${ob.partId }" class="btn btn-info">Edit</a>
									<td><a href="view?pid=${ob.partId }"
										class="btn btn-warning">View</a>
								</tr>
							</c:forEach>
						</table>

					</c:when>
					<c:otherwise>
						<h3>No Data Found</h3>
					</c:otherwise>

				</c:choose>
			</div>
			<%-- <c:if test="${!empty message }">
				<c:choose>
					<c:when test="${opr eq 'DEL'}">
						<div class="card-footer bg-danger text-white 
text-center"><b>${message }</b></div>
					</c:when>
					<c:otherwise>
						<div class="card-footer bg-info text-white 
text-center"><b>${message }</b></div>
					
					</c:otherwise>
				</c:choose>
			</c:if> --%>

		</div>
		<!-- card end -->
	</div>
	<!-- Container end -->
</body>
</html>