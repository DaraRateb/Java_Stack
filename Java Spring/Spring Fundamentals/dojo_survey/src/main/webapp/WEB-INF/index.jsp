<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
   <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="form">
<form action='/process' method='POST'> 
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name"><br><br>
        <label for="location">Dojo Location:</label>
        <select name="location" id="location">
            <option value="sanjose">San Jose</option>
            <option value="ramallah">Ramallah</option>
            <option value="nablus">Nablus</option>
            <option value="newyork">New York</option>
        </select><br><br>
        <label for="language">Favorite Language:</label>
        <select name="language" id="language">
            <option value="python">Python</option>
            <option value="c">C</option>
            <option value="java">Java</option>
            <option value="mern">Mern</option>
        </select><br><br>
        <label for="comment">Comment (optional): </label>
        <textarea id="comment" name="comment" rows="4" cols="50">
        </textarea><br>
    
        <input type="submit" value="Submit">
</form>
</div>
</body>
</html>