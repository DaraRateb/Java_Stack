<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

	<div class="home">
		<div class="register">
			<h1>Register!</h1>

			<p>
				<form:errors path="user.*" />
			</p>

			<form:form method="POST" action="/registration" modelAttribute="user">

				<p>
					<form:label path="firstname">First Name:</form:label>
					<form:input type="text" path="firstname" />
				</p>
				<p>
					<form:label path="lastname">Last Name:</form:label>
					<form:input type="text" path="lastname" />
				</p>
				<p>
					<form:label path="location">Location: </form:label>
					<form:input type="text" path="location" />
				</p>
				<p>
					 <form:select path="state" >
					<form:option value="CA">CA</form:option>
					<form:option value="NY">NY</form:option>
					<form:option value="LY">LY</form:option>
					<form:option value="WA">WA</form:option>
					<form:option value="AZ">AZ</form:option>
					</form:select>
				</p>

				<p>
					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email" />
				</p>
				<p>
					<form:label path="password">Password:</form:label>
					<form:password path="password" />
				</p>
				<p>
					<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					<form:password path="passwordConfirmation" />
				</p>
				<input type="submit" value="Register!" />
			</form:form>



		</div>



		<div class="login">
			<h1>Login</h1>
			<p>
				<c:out value="${logerror}" />
			</p>
			<form method="post" action="/login">
				<p>
					<label for="email">Email</label> <input type="text" id="email"
						name="email" />
				</p>
				<p>
					<label for="password">Password</label> <input type="password"
						id="password" name="password" />
				</p>
				<input type="submit" value="Login!" />
			</form>
		</div>
	</div>

</body>
</html>