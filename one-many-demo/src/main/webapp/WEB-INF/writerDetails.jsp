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
<title>Writer Details</title>
</head>

<body class="container">

	<h1>Writer Details</h1>

	<h3>${writer.username }</h3>
	<h3>${writer.email }</h3>

	<h4>List of Books written by ${writer.username }:</h4>

	<ul>
		<c:forEach var="eachBook" items="${writer.books}">
			<ul class="text-primary">${eachBook.title}- Number of pages:
				${eachBook.numberOfPages}
			</ul>
		</c:forEach>

	</ul>

	<p>
		<a href="/books/dashboard">Go to Dashboard</a>
	</p>

</body>
</html>