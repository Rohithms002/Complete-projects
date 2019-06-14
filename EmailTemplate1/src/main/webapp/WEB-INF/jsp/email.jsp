<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="validate" modelAttribute="email">
	<table border=1>
	<tr>
<td>From</td>
<td><form:input path="from" /></td>
</tr>

<tr>
<td>Password</td>
<td><form:input path="password" type="password" /></td>
</tr>

<tr>
<td>To</td>
<td><form:input path="to" /></br></td>
</tr>

<tr>
<td>Subject</td>
<td><form:input path="subject" /></td>
</tr>

<tr>
<td>Type Your Message here</td>
<td><form:input path="body"/></td>
</tr>
<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
</form:form>
</body>
</html>