<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="changed" method="post"></form>
<label for="id"><b>User Id</b></label> <input type="number"
			placeholder="Enter your id" name="id" required> <label
			for="password"><b>Email</b></label> <input type="text"
			placeholder="Enter your Email" name="email" required>

		<button type="submit">
			Submit</a>
		</button>
		${message} 
</body>
</html>