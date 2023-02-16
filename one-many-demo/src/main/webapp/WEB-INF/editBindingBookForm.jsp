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
<title>Data Binding Edit Book Form</title>
</head>
<body class="container">


	<h1>Edit Book</h1>
	<p><a href="/books/dashboard">Go to Dashboard</a></p>
	<form:form action="/books/binding/edit/${book.id }" method="post"
		modelAttribute="book">
		<input type="hidden" name="_method" value="put">
	<%-- 	<p class="form-group">
			<form:label path="writer">Writer</form:label>
			<form:select path="writer" class="form-control">
				<c:forEach var="oneWriter" items="${writersList}">
					<!--- Each option VALUE is the id of the person --->
					<form:option value="${oneWriter.id}">
						<!--- This is what shows to the user as the option --->
						<c:out value="${oneWriter.username}" /> - <c:out
							value="${oneWriter.email}" />
					</form:option>
				</c:forEach>
			</form:select>
		</p> --%>
		<p class="form-group">
			<form:label path="title">Title</form:label>

			<form:input path="title" class="form-control" />
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

			<form:input type="number" path="numberOfPages" class="form-control" />
			<form:errors path="numberOfPages" class="text-danger" />
		</p>
		
		<!-- To edit a one to many without updating the owner of the relationship
		pass the mappedBy of the variable through the path="" -->
		<form:hidden path="writer"/>
		<input type="submit" value="Edit" class="btn btn-primary" />
	</form:form>

</body>
</html>