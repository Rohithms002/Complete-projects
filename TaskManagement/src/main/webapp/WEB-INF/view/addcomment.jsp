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
<form:form action="commentadded" modelAttribute="comments">
${message}</br>
</br>
<form:hidden path="id" readonly="true" />
<form:hidden path="description" readonly="true" />
<form:hidden path="category" readonly="true" />
<form:hidden path="priority" readonly="true" />
<form:hidden path="id" readonly="true" />
<form:hidden path="assignTo" readonly="true" />
<form:hidden path="assignedBy" readonly="true" />
<form:hidden path="id" readonly="true" />
Comment : <form:textarea path="addComments"/></br>
		<input type="submit" value="AddComment" />
</form:form>
</body>
</html>