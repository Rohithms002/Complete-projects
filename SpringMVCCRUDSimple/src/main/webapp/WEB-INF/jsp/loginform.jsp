<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRvOxCvyaW1mm4GjnX3L9ovRyDiH1syGVnRBWaA6q4nSyrbGuR">
	style <i> <b>${message} </b></i>
	<form method="POST" action="loginemp">

		<p>
			<img src="https://images.jdmagicbox.com/comp/bangalore/p3/080pxx80.xx80.150418173221.g1p3/catalogue/testyantra-software-solutions-india-pvt-ltd-basavanagudi-bangalore-software-companies-k211a.jpg"
				alt="Test yantra" width="300" height="200"><big>Test
				Yantra Software Solutions India Pvt Ltd</big>
		</p>


		<label for="id"><b>User Id</b></label> <input type="number"
			placeholder="Enter your id" name="id" required> 
			
			<label for="password"><b>Password</b></label> <input type="password"
			placeholder="Enter Password" name="password" required>

		<button type="submit">
			Login</a>
		</button>

	<button type="button" class="cancelbtn">Cancel</button>
	
		<span class="psw">Forgot <a href="forgotpassword">password?</a></span>
		<div>${error}</div>


	</form>
	</body>