<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employees List</h1>
	${message}
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td><c:out value="${emp.id}"/></td>
    <td>${emp.name}</td>
    <td>${emp.email}</td>
    <td>${emp.password}
    <td><a href="editemp?id=${emp.id}"><button> Edit </button></a></td>
    <td><a href="deleteemp?id=${emp.id}"> <button onclick="return confirm('Are you sure you want to delete this record?');">Delete</button></a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="register">Register New Employee</a>
</body>
</html>