<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Teacher Portal</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
	<script>
		
		function addQuestion() {
			document.forms[0].action = "addQuestion.jsp";
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
		function viewScoresTeach() {
			document.forms[0].action = "viewScoresTeach.jsp";
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
		
	</script>
</head>
<body>
	<h3>Teacher Portal</h3>
	<form action="LogoutTeacher">
		<div class="form-group">
			<input class="btn btn-primary" type="button" onclick="addQuestion()" value="Add New Question">
			<input class="btn btn-primary" type="button" onclick="viewScoresTeach()" value="View All Students' Scores">
			<input class="btn btn-primary" type="submit" value="Logout">
		</div>
	</form>
</body>
</html>