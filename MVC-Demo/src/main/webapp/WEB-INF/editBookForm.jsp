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
<title>Edit Book Form</title>
</head>
<body class="container">

	<h2>Edit Book Form</h2>

	<form:form action="/books/binding/edit/${editBook.id }" method="post" modelAttribute="editBook">
	 <input type="hidden" name="_method" value="put">
		<p class="form-group">
			<form:label path="title">Title</form:label>
			<form:input  path="title" class="form-control"/>
			<form:errors path="title" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="description">Description</form:label>
			<form:textarea path="description" class="form-control" />
			<form:errors path="description" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="language">Language</form:label>
			<form:input path="language" class="form-control" />
			<form:errors path="language" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="numberOfPages">Pages</form:label>
			<form:input  type="number" path="numberOfPages" class="form-control"/>
			<form:errors path="numberOfPages" class="text-danger" />
		</p>
		<input class="btn btn-primary" type="submit" value="Edit" />
	</form:form>

</body>
</html>