<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Dashboard</title>
</head>
<body>
	<a href="/songs/new">Add New</a>
	<a href="/search/topTen">Top Songs</a>

	

	<form action="/search" method="post" >
        <input type="search" placeholder="Search.." name="search">
        <button type="submit"><i class="fa fa-search"></i>Search</button>
      </form>

	<form>

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}">${song.title}</a></td>
						<td>${song.rating}</td>
						<td><a href="/songs/delete/${song.id}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</form>

</body>
</html>