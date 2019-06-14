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
${error}

<form:form action="checklogin" modelAttribute="employee">
Email : <form:input path="email" /></br>
Password : <form:input path="password" /></br>
<input type="submit" value ="Login"/>
</form:form>
</body>
</html>