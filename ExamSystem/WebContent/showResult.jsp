<%@page import="com.vwits.model.Student"%>
<%@page import="com.vwits.db.StudentDAO"%>
<%@page import="com.vwits.model.Results"%>
<%@page import="com.vwits.db.ResultsDAO"%>
<%@page import="com.vwits.db.QuestionDAO"%>
<%@page import="com.vwits.model.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Results</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<% 
	
	QuestionDAO q = new QuestionDAO();
	ResultsDAO r = new ResultsDAO();
	StudentDAO s = new StudentDAO();
	List<Question> questions = q.getAllQuestions();
	HttpSession sess = request.getSession(false);
	String user = (String) sess.getAttribute("name");
	System.out.println(user);
	int correct=0, i=0;
	
	for(Question ques : questions) {
		i++;
		String studAns = (String) request.getParameter("question"+i);
		String actAns = ques.getCorrectoption();
		if(studAns.equals(actAns))
			correct++;
	}
	
	Student stud = s.getStudent(user);
	r.insert(new Results(stud.getId(),correct));
	
	%>
	
	<div>
		<h4>Your score: <%=correct %>/<%=questions.size() %></h4>
		<form action="studProfile.jsp">
			<input class="btn btn-primary" type="submit" value="Home">
		</form>
	</div>
</body>
</html>