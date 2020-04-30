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
	<form action="uplaodQuestionUrl" method="post"
		enctype="multipart/form-data">
		Select Exam Name:<select name="examName">
			<option value="">--Select Exam Name --</option>
			<c:forEach var="m" items="${values}">
				<option value="${m.exam_name}">${m.exam_name}</option>
			</c:forEach>

		</select><br> <select name="setNo">
			<option value="">--Select Set no</option>
			<option value="SET-1">SET-1</option>
			<option value="SET-2">SET-2</option>
		</select><br> Upload File:<input type="file" name="file"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>