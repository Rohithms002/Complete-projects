<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title> Task Management System</title>
<body>

	<form:form action="move">
		<table border=1>
			<tr>
				<td>id</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input path="description" readonly="true" /></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:input path="priority" readonly="true" /></td>
			</tr>

            <tr>
		 		<td>Password :</td>
				<td><form:input path="assignTo" readonly="true" /></td>
			</tr>
			
			<tr>
				<td>Password :</td>
				<td><form:input path="date" readonly="true" /></td>
			</tr>
			
			
			<tr>
				<td>category :</td>
				<td><form:input path="category" readonly="true" /></td>
			</tr>
			
				<tr>
				<td>email :</td>
				<td><form:input path="email" readonly="true"/></td>
			</tr>
			
				<tr>
				<td>CreatedAt :</td>
				<td><form:input path="createdAt" readonly="true"/></td>
			</tr>
					<tr>
				<td>Assignedby :</td>
				<td><form:input path="assignedBy" readonly="true"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Move" /></td>
			</tr>
		</table>
	</form:form>
</body>
