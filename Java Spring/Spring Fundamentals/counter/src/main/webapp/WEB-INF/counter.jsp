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
<h2>You have visited <a href="http://localhost:8080/">localhost</a> <c:out value="${count}"/> times.</h2>
<h3><a href="http://localhost:8080/">Test another visit!</a></h3>
</body>
</html>