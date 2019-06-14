<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee registration</title>
</head>
<body>
<form:form action="registered" modelAttribute="employee">

Name : <form:input path="name" /></br>
Email : <form:input path="email" /></br>
password : <form:input path="password" type="password"/></br>


		<input type="submit" value="submit" />
</form:form>
</body>
</html>