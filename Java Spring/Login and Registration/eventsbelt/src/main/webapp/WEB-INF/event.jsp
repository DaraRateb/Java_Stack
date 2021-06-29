<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Event Details</title>
</head>
<body>
	<h1>${event.name}</h1>
	<p>Host: ${event.host.firstname} ${event.host.lastname}</p>
	<p>
		Date:
		<fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}" />
	</p>
	<p>Location: ${event.location},${event.state}</p>
	<p>People who are attending this event: ${event.users.size()}
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${event.users}" var="user">
				<tr>
					<td><c:out value="${user.firstname} ${user.lastname}" /></td>
					<td><c:out value="${user.location}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Message Wall</h2>
	<c:forEach items="${event.messages}" var="message">
		<p>${message.user.firstname} says: ${message.comment }</p>
	</c:forEach>

	<form:form action="/message/create" method="post" modelAttribute="message">
		<form:hidden value="${user.id}" path="user" />
		<form:hidden value="${event.id}" path="event" />

		<p>
			<form:label path="comment">Add a comment: </form:label>
			<br>
			<form:textarea path="comment" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>