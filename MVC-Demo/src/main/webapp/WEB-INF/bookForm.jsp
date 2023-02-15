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
<title>Book Form</title>
</head>
<body class="container">
	<h2>Book Form</h2>

	<form action="/books/new" method="post">
		<div class="form-group">
			<label>Book Title</label> <input type="text" class="form-control"
				name="title" placeholder="Enter Title">
		</div>

		<div class="form-group">
			<label>Description</label>
			<textarea class="form-control" name="description" rows="3"></textarea>
		</div>


		<div class="form-group">
			<label>Language</label> <input type="text" class="form-control"
				name="language" placeholder="Enter Language">
		</div>

		<div class="form-group">
			<label>Number of Pages</label> <input type="number" min="1"
				class="form-control" name="pages"
				placeholder="Enter Number of Pages">
		</div>


		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>