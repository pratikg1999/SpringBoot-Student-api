<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addStudent">
		<label for="id">Enter the id: </label><input type="text" name="id" id="id"><br> 
		<label for="email">Enter the email:</label><input type="text" name="email" id="email"><br> 
		<label for="name">Name: </label><input type="text" name="name" id="name"><br>
		<label for="password">Password: </label><input type="password" name="password" id="password"><br> <input type="submit">
	</form>
	
	<form action="getStudent">
		<label for='sid'>Sid:</label><input type="text" name='sid' id='sid'><br>
		<input type="submit">
	</form>

	your name is ${name}
</body>
</html>