<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<h1>${product.name}</h1>
<h3>Categories: </h3>
<ul>
   <c:forEach items="${product.categories}" var="category">
   <li>${category.name}</li>
    </c:forEach>
    </ul>
<form:form action="/add/${product.id}/category" method="post"
		modelAttribute="product">


		<p>
			<form:label path="categories">Add Category:</form:label>
			<form:select path="categories">
				<c:forEach items="${other}" var="i">
					<form:option value="${i.id}">${i.name} </form:option>
				</c:forEach>
			</form:select>
		</p>   
			<input type="submit" value="Add" /> 
    
    </form:form>  
    
</body>
</html>