<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Welcome</title>

</head>
<body>
	<h1>Welcome ${user.firstname}</h1>
	<a href="/logout">Logout</a>

	<p>Here are some of the events in your state:</p>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${events}" var="event">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td><fmt:formatDate pattern="MMMM dd, yyyy"
							value="${event.date}" /></td>
					<td><c:out value="${event.location}" /></td>
					<td><c:out value="${event.host.firstname}" /></td>
					<td><c:choose>
							<c:when test="${event.host.id==user.id }">
								<a href="/events/edit/${event.id }">Edit</a>
								<a href="/events/delete/${event.id }">Delete</a>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${event.users.contains(user) }">

										<span>Joined <a href="/events/cancel/${event.id}">Cancel</a></span>
									</c:when>
									<c:otherwise>
										<a href="/events/join/${event.id }">Join</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Here are some of the events in other state:</p>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${other}" var="event">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td><fmt:formatDate pattern="MMMM dd, yyyy"
							value="${event.date}" /></td>
					<td><c:out value="${event.location}" /></td>
					<td><c:out value="${event.host.firstname}" /></td>
					<td><c:choose>
							<c:when test="${event.host.id == user.id}">
								<a href="/events/edit/${event.id }">Edit</a>
								<a href="/events/delete/${event.id }">Delete</a>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${event.users.contains(user) }">

										<span>Joined <a href="/events/cancel/${event.id}">Cancel</a></span>
									</c:when>
									<c:otherwise>
										<a href="/events/join/${event.id }">Join</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>



	<h1>Create an Event</h1>
	<form:form action="/event/create" method="post" modelAttribute="event">
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

		<input type="submit" value="Create" />
	</form:form>
</body>
</html>