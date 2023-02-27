<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body class="container">
	<p>
		<a href="/donations/new">Add a Donation</a>
	</p>


	<h1>Welcome, ${ userName}</h1>


	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Item Name</th>
				<th scope="col">Quantity</th>
				<th scope="col">Donor</th>
				<th scope="col">Action</th>
				<th></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${ donationList}">
				<tr>
					<td scope="row"><c:out value="${eachDonation.id }" /></td>
					<td><a href="/donations/${eachDonation.id }"><c:out
								value="${eachDonation.itemName}" /></a></td>
					<td><c:out value="${eachDonation.quantity}" /></td>
					<td><c:out value="${eachDonation.donor.userName}" /></td>

					<c:choose>
						<c:when test="${userId.equals(eachDonation.donor.id) }">
							<td><a href="/donations/edit/${eachDonation.id }">Edit</a></td>
							<td>
						<!-- 	Delete form -->
								<form action="/donations/delete/${eachDonation.id}"
									method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete" class="btn btn-danger">
								</form>
							</td>
						</c:when>
						
						<c:when test="${eachDonation.receivers.contains(loggedInUser) }">
							<td>
								<form action="/donations/return/${eachDonation.id}" method="post">
								
									<input type="hidden" name="_method" value="put"/>
									<button type="submit" class="btn btn-secondary">Return</button>
								
								</form>
							</td>
							<td></td>
						</c:when>
						<c:otherwise>
							<td>
								<form action="/donations/receive/${eachDonation.id}" method="post">
								
									<input type="hidden" name="_method" value="put"/>
									<button type="submit" class="btn btn-warning">Receive</button>
								
								</form>
							
							</td>
							<td></td>
						</c:otherwise>
</c:choose>

				</tr>
			</c:forEach>

		</tbody>
	</table>



	<p>
		<a href="/logout">Log Out</a>
	</p>

</body>
</html>