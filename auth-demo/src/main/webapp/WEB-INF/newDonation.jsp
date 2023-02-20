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
<title>New Donation</title>
</head>
<body class="container">

	<h1>Create a New Donation</h1>
	<form:form action="/donations/new" method="post"
		modelAttribute="newDonation">
		<p class="form-group">
			<form:label path="itemName">Item Name</form:label>

			<form:input path="itemName" class="form-control" />
			<form:errors path="itemName" class="text-danger" />
		</p>
		<p class="form-group">
			<form:label path="quantity">Quantity</form:label>
			<form:input path="quantity" class="form-control" type="number" min="1" />
			<form:errors path="quantity" class="text-danger" />
		</p>
		
		<form:hidden path="donor" value="${userId}"/>
		
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
	

</body>
</html>