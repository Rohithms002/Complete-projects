<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>task Management System</title>
</head>
<body>
<h1> Create your Task and Assign</h1>
<form:form action="save" modelAttribute="task">
<table border=1>
Description : <form:input path="description" /></br>
<p> Choose Priority</p> <select name="priority">
    <option value="low">low</option>
    <option value="Medium">medium</option>
    <option value="Hign">hign</option>
    <option value="Critical">critical</option>
  </select></br>
Assign To : <form:input path="assignTo" /></br>
End Date : <form:input path="date" type="date"/></br>
<p> Choose Category</p>
 <select name="category">
    <option value="java">java</option>
    <option value="jquery">jquey</option>
    <option value="python">python</option>
    <option value="springboot">springboot</option>
  </select>
Add Category : <form:input path="addCategory" /></br>
Email:<form:input path="email"/> </br></br>

		<input type="submit" value="Save&Assign" />
		</table>
</form:form>
</body>
</html>