<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP JSTL Class</title>
</head>
<body>

	<h1>First fruit is: <c:out value="${fruit1}"/></h1>
	<h1>Second fruit is: ${fruit2 }</h1>
	<h1>Hacker script says: <c:out value="${hacker}"/></h1>
	

</body>
</html>