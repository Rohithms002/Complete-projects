<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body
	background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRvOxCvyaW1mm4GjnX3L9ovRyDiH1syGVnRBWaA6q4nSyrbGuR">
	<p>
		<img
			src="https://images.jdmagicbox.com/comp/bangalore/p3/080pxx80.xx80.150418173221.g1p3/catalogue/testyantra-software-solutions-india-pvt-ltd-basavanagudi-bangalore-software-companies-k211a.jpg"
			alt="Test yantra" width="300" height="200"><big>Test
			Yantra Software Solutions India Pvt Ltd</big>
	</p>
	<h1>Edit Employee Details</h1>
	<form:form method="POST" action="/SpringMVCPagination/edit">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><form:input type="number" path="Salary" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><form:input type="text" path="designation" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input type="email" path="Email" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form:form>
</body>
