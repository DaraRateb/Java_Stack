<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Song</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<a href="/dashboard">Dashboard</a>

	<form:form action="/songs/new" method="post" modelAttribute="song">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="artist">Artist</form:label>
			<form:errors path="artist" />
			<form:textarea path="artist" />
		</p>
		<p>
			<label for="rating">Rating</label> <form:input type="number" min="1"
				max="10" name="rating" path="rating"/>
		</p>

		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>