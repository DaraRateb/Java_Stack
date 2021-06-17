<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
   <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<p><c:out value="${error}"/></p>
<form action="/check" method="POST">
<h3>What is the code?</h3><br>
<input type="text" name="code" id="code"><br>
<input type="submit" value="Try Code">
</form>
</body>
</html>