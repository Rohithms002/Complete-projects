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
<form:form action="search" modelAttribute="task">
${message}</br>
</br>

Search : <form:input path="search"/></br>

		<input type="submit" value="Search" />
</form:form>
</body>
</html>