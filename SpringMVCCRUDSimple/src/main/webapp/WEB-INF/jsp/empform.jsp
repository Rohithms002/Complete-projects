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
	<h1>Welcome to Employee Registration form</h1>
	<h5>Please fill all the mandatory fields to register</h5>
	<form:form method="post" action="save">
	 <fieldset>
    <legend>Personal information:</legend>

		<label for="name"><b>Name</b></label>
		<input type="text" placeholder="Enter your name" name="name" required>
		</br>


		<label for="salary"><b>Salary</b></label>
		<input type="number" placeholder="Enter your Salary" name="salary"
			required>
		</br>

		<label for="designation"><b>Designation</b></label>
		<input type="text" placeholder="Enter your Designatin"
			name="designation" required>
		</br>

		<label for="email"><b>Email </b></label>
		<input type="email" placeholder="Enter your Email" name="email"
			required>
		</br>

		<label for="password"><b>Password</b></label>
		<input type="password" placeholder="Enter your password"
			name="password" required> </br>
			<p>Select role:</p>
			 <input type="radio" name="rollType" value="admin"> Admin</br>
              <input type="radio" name="rollType" value="user"> User</br> </br>
  </br>
		<button type="submit">
			Register</a>
		</button>
 </fieldset>
    
	</form:form>
	${message}
</body>
