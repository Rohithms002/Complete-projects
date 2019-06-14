<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Management System</title>
</head>
<body>
<form:form action="saveemployee" modelAttribute="employee">
${message}</br>
</br>

First Name : <form:input path="firstName" required="true"/></br>
Last Name : <form:input path="lastName" required="true" /></br>
Contact No: : <form:input path="contactNo" required="true"/></br>
Email : <form:input path="email" type="email" required="true"/></br>
Password : <form:input path="password" type="password" required="true"/></br>
Confirm Password : <form:input path="confirmPassword" required="true"/></br>

		<input type="submit" value="Register" />
</form:form>
</body>
</html>