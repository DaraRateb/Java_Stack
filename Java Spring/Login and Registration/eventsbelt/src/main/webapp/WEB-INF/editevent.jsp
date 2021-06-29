<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
<h1>${event.name }</h1>
<form:form action="/events/edit/${event.id}" method="post" modelAttribute="event">
	<form:hidden value="${user.id}" path="host" />
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="date">Date</form:label>
			<form:errors path="date" />
			<form:input path="date" type="date" />
		</p>
		<p>
			<form:label path="location">Location</form:label>
			<form:errors path="location" />
			<form:input path="location" />
		</p>
		<p>
			<form:select path="state">
				<form:option value="CA">CA</form:option>
				<form:option value="NY">NY</form:option>
				<form:option value="LY">LY</form:option>
				<form:option value="WA">WA</form:option>
				<form:option value="AZ">AZ</form:option>
			</form:select>
		</p>

		<input type="submit" value="Edit" />
	</form:form>
</body>
</html>