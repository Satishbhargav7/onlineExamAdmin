<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>UpdatePost</title>
<link rel="icon" href="../images/logo.png">
<meta charset="utf-8">

<link rel="stylesheet" href="../css/style.css" type="text/css" />

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap"
	rel="stylesheet">
</head>

<script>
	function show_alert() {
		alert("Data Submitted sucessfuly ");
	}
</script>

<body>
	<div class="container">
		<jsp:include page='header.jsp'>
			<jsp:param name="articleId" value="" />
		</jsp:include>

		<div class="createPostBlock">
			<form class="form-horizontal"
				action="/examupdateurl/${updateValues.id}" method="post">
				<div class="form-group">
					<label class="control-label col-sm-5" for="examcode">ExamCode
						:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="exam_code"
							value="${updateValues.exam_code}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="name">ExamName
						:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="exam_name"
							value="${updateValues.exam_name}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="examdate">
						ExamDate :</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="exam_date"
							value="${updateValues.exam_date}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="duration">ExamDuration
						:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="duration"
							value="${updateValues.duration}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="question">MFEQuestion
						:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="marks_per_question"
							value="${updateValues.marks_per_question}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="negativemarks">NMFEQuestion
						:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="negativemarks_per_question"
							value="${updateValues.negativemarks_per_question}" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost">Select post Name 
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						 <select class="form-control" name="post_name">
						<option value="">--Select Post --
							<c:forEach var="updateValues" items="${value}">
							
								<option value="${updateValues.post_name}">${updateValues.post_name}</option>
							</c:forEach>
						</select> 
						<!-- <input type="text" class="form-control" name="post" id="post" >  -->
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-5" for="no.ofvancancies">Exam Description
						:</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="exam_description"
							value="${updateValues.exam_description}" />
					</div>
				</div>
				
				<div class="col-md-12">
					<div class="preBtn text-center">
						<button type="submit" class="btn btn-primary" value="Update">UPDATE</button>
					</div>
				</div>
			</form>
		</div>
		<div class="clearfix"></div>
		<!--Wpp Block End-->
		<div class="footer">
			<div class="row">
				<div class="col-md-6">
					<div class="footer-info"></div>
				</div>
				<div class="col-md-6 text-right">
					<div class="footer-info">
						<span>&copy; 2020 Timing Technologies India Pvt Ltd. </span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Container end-->
</body>
</html>