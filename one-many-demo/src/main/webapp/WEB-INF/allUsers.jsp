<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Users Dashboard</title>
</head>
<body class="container">
	<h1>Show All Users</h1>
	<p><a href="/books/dashboard">Go to Dashboard</a></p>


	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Username</th>
				<th scope="col">Email</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachUser" items="${ listOfUsers}">
				<tr>
					<td scope="row"><c:out value="${eachUser.id }" /></td>
					<td><a href="/books/users/${eachUser.id }"><c:out value="${eachUser.username}" /></a></td>
					<td><c:out value="${eachUser.email}" /></td>
		
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>