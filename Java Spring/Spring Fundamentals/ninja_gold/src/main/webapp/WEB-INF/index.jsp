<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/style.css">
<title>Ninja Gold</title>
</head>
<body>
  Your Gold:<c:out value="${score}"/> <br><br>
    
    <div class="place">
        <h2>Farm</h2>
        <p>(earns 10-20 golds)</p>
        <form action="/process_money" method="POST">
            <input type="hidden" name="place" value="farm">
            <button name="gold" type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="place">
        <h2>Cave</h2>
        <p>(earns 5-10 golds)</p>
        <form action="/process_money" method="POST">
            <input type="hidden" name="place" value="cave">
            <button name="gold" type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="place">
        <h2>House</h2>
        <p>(earns 2-5 golds)</p>
        <form action="/process_money" method="POST">
            <input type="hidden" name="place" value="house">
            <button name="gold" type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="place">
        <h2>Casino</h2>
        <p>(earns/takes 0-50 golds)</p>
        <form action="/process_money" method="POST">
            <input type="hidden" name="place" value="casino">
            <button name="gold" type="submit">Find Gold!</button>
        </form>
    </div>
    
    
        <p>Activities:</p>
        <div id="act">
         	<c:forEach items="${activites}" var="entry">

            <h4><c:out value="${entry}"/></h4>

        </c:forEach>  
     
        </div>
       
</body>
</html>