<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Artist</title>
</head>
<body>
	<p>Songs by artist: ${search}</p>


	<form action="/search" method="post">
		<input type="search" placeholder="Search.." name="search">
		<button type="submit">
			<i class="fa fa-search"></i>New Search
		</button>
	</form>
	<a href="/dashboard">Dashboard</a>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>rating</th>
				<th>actions</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td><c:out value="${song.rating}" /></td>
					<td><a href="/songs/delete/${song.id}">delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>