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
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>All Users</title>
</head>
<body>

	<h1>All Users</h1>
	
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Username</th>
				<th scope="col">Email</th>
				<th scope="col">Action</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachUser" items="${ allUsersList}">
				<tr>
					<td><c:out value="${eachUser.id }" /></td>
					<td><c:out value="${eachUser.username }" /></td>
					<td><c:out value="${eachUser.email }" /></td>
					<td></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	

</body>
</html>