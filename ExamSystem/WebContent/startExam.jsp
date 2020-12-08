<%@page import="com.vwits.db.QuestionDAO"%>
<%@page import="com.vwits.model.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Exam</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<form action="showResult.jsp">
		<div class="form-group">
			<table class="table table-bordered table-responsive table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Question no.</th>
						<th scope="col">Question</th>
						<th scope="col">Option 1</th>
						<th scope="col">Option 2</th>
						<th scope="col">Option 3</th>
						<th scope="col">Option 4</th>
					</tr>
				</thead>
				
				<% 
					QuestionDAO q = new QuestionDAO();
					List<Question> questions = q.getAllQuestions();
					int i =0;
					for(Question ques:questions) {
						i++;
						
				%>
				<tbody>
					<tr>
						<th scope="row"><%=ques.getQuestionid()-10%></th>
						<td><%=ques.getQuestion() %></td>
						<td><input type="radio" name="question<%=i %>" value="<%=ques.getOption1() %>"><%=ques.getOption1() %></td>
						<td><input type="radio" name="question<%=i %>" value="<%=ques.getOption2() %>"><%=ques.getOption2() %></td>
						<td><input type="radio" name="question<%=i %>" value="<%=ques.getOption3() %>"><%=ques.getOption3() %></td>
						<td><input type="radio" name="question<%=i %>" value="<%=ques.getOption4() %>"><%=ques.getOption4() %></td>
					</tr>
				</tbody>
				
				<!-- <input type="radio" value="e" name="" checked="checked" name=> -->
				
				<%
					}
				%>
				
			</table>
		</div>
		<input class="btn btn-primary" type="submit" value="End Exam">
	</form>
</body>
</html>