<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Question</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h3>New Question</h3>
	<form action="AddQuestion">
		<div class="form-group">
			<input class="form-control" type="text" name="txtQuestion" placeholder="Enter Question">
			<input class="form-control" type="text" name="txtOption1" placeholder="Enter Option 1"> 
			<input class="form-control" type="text" name="txtOption2" placeholder="Enter Option 2"> 
			<input class="form-control" type="text" name="txtOption3" placeholder="Enter Option 3"> 
			<input class="form-control" type="text" name="txtOption4" placeholder="Enter Option 4"> 
			<input class="form-control" type="text" name="txtOptionCorrect" placeholder="Enter Correct Option"> <br>
			<input class="btn btn-primary" type="submit" value="Submit">
		</div>
	</form>
	
	<form action="teacherProfile.jsp">
		<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Back">
		</div>
	</form>
	
	<%
		String msg = (String) request.getAttribute("message");
		if(msg != null)
			out.println(msg);
	%>
	
</body>
</html>