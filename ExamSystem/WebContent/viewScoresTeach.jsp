<%@page import="com.vwits.model.Results"%>
<%@page import="java.util.List"%>
<%@page import="com.vwits.db.ResultsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Student Scores</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h3>Students' Scores</h3>
	<table class="table table-bordered table-responsive table-striped">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Exam ID</th>
				<th scope="col">Student ID</th>
				<th scope="col">Marks</th>
			</tr>
		</thead>
		<%
			ResultsDAO r = new ResultsDAO();
			List<Results> results = r.getAll();
			
			for(Results res : results) {
				
		%>
		
		<tbody>
			<tr>
				<td scope="row"><%= res.getExamid() %></td>
				<td><%= res.getStudentid() %></td>
				<td><%= res.getMarks() %></td>
			</tr>
		</tbody>
		
		<%
			}
		%>
		
	</table>
	
	<form action="teacherProfile.jsp">
		<input class="btn btn-primary" type="submit" value="Back">
	</form>
	
</body>
</html>