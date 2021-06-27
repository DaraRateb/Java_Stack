<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details</title>
</head>
<body>
<h1>${category.name}</h1>
<h3>Products: </h3>
<ul>
   <c:forEach items="${category.products}" var="product">
   <li>${product.name}</li>
    </c:forEach>
    </ul>
<form:form action="/add/${category.id}/product" method="post"
		modelAttribute="category">


		<p>
			<form:label path="products">Add Product:</form:label>
			<form:select path="products">
				<c:forEach items="${other}" var="i">
					<form:option value="${i.id}">${i.name} </form:option>
				</c:forEach>
			</form:select>
		</p>   
			<input type="submit" value="Add" /> 
    
    </form:form>  
    
</body>
</html>