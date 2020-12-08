<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Student Portal</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		function startExam() {
			document.forms[0].action = "startExam.jsp";
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
		function viewScoresStud() {
			document.forms[0].action = "viewScoresStud.jsp";
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
	</script>
</head>
<body>
	<h3>Student Portal</h3>
	<form action="Logout">
		<div class="form-group">
			<input class="btn btn-primary" type="button" onclick="startExam()" value="Take Exam">
			<input class="btn btn-primary" type="button" onclick="viewScoresStud()" value="View Exam Scores">
			<input class="btn btn-primary" type="submit" value="Logout">
		</div>
	</form>
</body>
</html>