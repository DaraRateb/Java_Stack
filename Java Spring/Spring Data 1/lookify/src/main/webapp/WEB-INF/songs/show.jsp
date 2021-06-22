<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Show Song</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>



<p>Title: ${song.title}</p>
<p>Artist: ${song.artist}</p>
<p>Rating(1-10): ${song.rating}</p>

<a href="/songs/delete/${song.id}">Delete</a>


</body>
</html>