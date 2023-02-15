<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>

	<p>Hello, I am new here</p>
	<h1>I am so excited to be here in this java class!</h1>


	<%
		for (int i = 0; i < 5; i++) {
	%>
	<h1><%= i %></h1>
	<%
	}
	%>
	<p>
		The time is:
		<%=new Date()%></p>

</body>
</html>