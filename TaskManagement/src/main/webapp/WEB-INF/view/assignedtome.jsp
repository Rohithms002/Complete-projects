<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Management System</title>
</head>
<body>
	${message}
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>description</th><th>priority</th><th>category</th><th>AssignTo</th><th>AssignedBy</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td><c:out value="${emp.id}"/></td>
    <td>${emp.description}</td>
    <td>${emp.priority}</td>
    <td>${emp.category}</td>
    <td>${emp.email}</td>
    <td>${emp.assignedBy}
   
    </tr>
    </c:forEach>
    </table>
    <br/>
</body>
</html>