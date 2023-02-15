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
<title>JSP Form</title>
</head>
<body class="container">

	<h3>Login</h3>
	<p><c:out value="${email}" /></p>
	    <form action="/showResult" method="GET">
	<label>Email:</label>
    	<input type="text" name="email">
	<label>Password:</label>
    	<input type="password" name="password">
    	<input type="submit" value="login">
    </form>



</body>
</html>