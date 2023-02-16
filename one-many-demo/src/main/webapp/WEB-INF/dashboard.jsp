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
<title>Book Dashboard</title>
</head>
<body class="container">
	<h1>All Books from Database</h1>
	<p><a href="/books/users/new">Create a User</a></p>
	
	<p><a href="/books/databinding/new">Create a Book</a></p>

	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Title</th>
				<th scope="col">Description</th>
				<th scope="col">Language</th>
				<th scope="col">Number of Pages</th>
				<th scope="col">Writer</th>
				<th scope="col">Action</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachBook" items="${ allBooks}">
				<tr>
					<td scope="row"><c:out value="${eachBook.id }" /></td>
					<td><a href="/books/${eachBook.id }"><c:out
								value="${eachBook.title }" /></a></td>
					<td><c:out value="${eachBook.description }" /></td>
					<td><c:out value="${eachBook.language }" /></td>
					<td><c:out value="${eachBook.numberOfPages }" /></td>
					<td><c:out value="${eachBook.writer.email}" /></td>
					<td><a href="/books/binding/edit/${eachBook.id }">Edit</a></td>
					<td>
						<form action="/books/delete/${eachBook.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>