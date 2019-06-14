    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRvOxCvyaW1mm4GjnX3L9ovRyDiH1syGVnRBWaA6q4nSyrbGuR">
     <p><img src="https://images.jdmagicbox.com/comp/bangalore/p3/080pxx80.xx80.150418173221.g1p3/catalogue/testyantra-software-solutions-india-pvt-ltd-basavanagudi-bangalore-software-companies-k211a.jpg" alt="Test yantra"width="300" height="200"><big>Test Yantra Software Solutions India Pvt Ltd</big></p>
	<h1>Employees List</h1>
	
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.salary}</td>
    <td>${emp.designation}</td>
    <td>${emp.email}</td>
    <td><a href="editemp/${emp.id}"><button> Edit </button></a></td>
    <td><a href="deleteemp/${emp.id}"> <button onclick="return confirm('Are you sure you want to delete this record?');">Delete</button></a></td>
    </tr>
    ${message}
    </c:forEach>
    </table>
    <br/>
    <a href="empform">Register New Employee</a>
     <a href="loginform">Click to login</a>
     </body>
    

