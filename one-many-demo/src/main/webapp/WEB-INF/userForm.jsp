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
<title>User Form</title>
</head>
<body class="container">

	<h1>New User</h1>
	<form:form action="/books/users/new" method="post"
		modelAttribute="newUser">
		<p class="form-group">
			<form:label path="username">Username</form:label>

			<form:input path="username" class="form-control" />
			<form:errors path="username" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</p>
		
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
	

</body>
</html>