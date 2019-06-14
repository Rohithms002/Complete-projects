<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<!-- background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRvOxCvyaW1mm4GjnX3L9ovRyDiH1syGVnRBWaA6q4nSyrbGuR">
	<p>
		<img
			src="https://images.jdmagicbox.com/comp/bangalore/p3/080pxx80.xx80.150418173221.g1p3/catalogue/testyantra-software-solutions-india-pvt-ltd-basavanagudi-bangalore-software-companies-k211a.jpg"
			alt="Test yantra" width="300" height="200"><big>Test
			Yantra Software Solutions India Pvt Ltd</big>
	</p> -->
	<form:form action="accept">
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
				<td><input type="submit" value="ACCEPT" /></td>
			</tr>
		</table>
	</form:form>
</body>
