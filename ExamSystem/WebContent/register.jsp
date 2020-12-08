<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		function home() {
			document.forms[0].action = "index.jsp";
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
	</script>
</head>
<body>
	<form action="register" method="post">
		<div class="form-group">
			<input class="form-control" type="text" placeholder="Enter your name" name="txtName" required="true"> <br>
			<input class="form-control" type="password" placeholder="Enter your password" name="txtPassword" required="true"> <br>
			<input class="form-control" type="text" placeholder="Enter your email" name="txtEmail" required="true"> <br>
			<input class="form-control" type="number" placeholder="Enter your phone number" name="txtPhone" required="true"> <br>
			<label>Type of Account: </label>
			<div class="form-check">
			<input class="form-check-input" id="Radios1" type="radio" name="type" value="Student">
			<label class="form-check-label" for="Radios1">
				Student
			</label>
			</div>
			<div class="form-check">
			<input class="form-check-input" type="radio" id="Radios2" name="type" value="Teacher">
			<label class="form-check-label" for="Radios2">
				Teacher
			</label>
			</div><br>
			<input class="btn btn-primary" type="submit" value="Submit">
			<input class="btn btn-primary" type="button" value="Home" onclick="home()">
			
			<%
			String message = (String) request.getAttribute("message");
			if(message != null)
				out.println(message);
			%>
		</div>
	</form>
</body>
</html>