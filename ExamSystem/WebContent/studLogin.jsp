<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Student Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<form action="StudentLogin">
		<div class="form-group">
			<input class="form-control" type="text" placeholder="Enter Username" name="txtUsername"> <br>
			<input class="form-control" type="password" placeholder="Enter Password" name="txtPassword"> <br>
			<input class="btn btn-primary" type="submit" value="Login">
			<input class="btn btn-primary" type="reset" value="Reset">
		</div>
	</form>
	<form action="index.jsp">
		<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Home">
		</div>
	</form>
	<font color="red">
	<%
		String msg = (String) request.getAttribute("errorMessage");
		if(msg != null)
			out.println(msg);
	%>
	</font>
	<font color="green">
	<%
		String msgLogout = (String) request.getAttribute("logoutMessage");
		if(msgLogout != null)
			out.println(msgLogout);
	%>
	</font>
</body>
</html>