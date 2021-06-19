<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1 style="text-decoration: underline;">Submitted Info:</h1>
    <label for="name">Your Name:</label>
    <p><c:out value="${name}"/> </p><br>
    <label for="location">Dojo Location:</label>
    <p><c:out value="${location}"/> </p><br>
    <label for="language">Favorite Language:</label>
    <p><c:out value="${language}"/> </p><br>
    <label for="comment">Comment (optional): </label>
    <p><c:out value="${comment}"/> </p><br>
    <form action="/index">
    <input type="submit" value="Go Back">
    </form>
</body>
</html>