<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="savingQuestionUrl" method="post">
		Select Exam Name:<select name="examName">
			<option value="">--Select Exam Name --</option>
			<c:forEach var="m" items="${values}">

				<option value="${m.exam_name}">${m.exam_name}</option>
			</c:forEach>

		</select><br> <select name="setNo">
			<option value="">--Select Set no</option>
			<option value="SET-1">SET-1</option>
			<option value="SET-2">SET-2</option>
		</select><br> question:<input type="text" name="question"><br>
		option1:<input type="text" name="option1"><br> option2:<input
			type="text" name="option2"><br> option3:<input
			type="text" name="option3"><br> option4:<input
			type="text" name="option4"><br> <input type="submit"
			value="Submit">
	</form>
</body>
</html>