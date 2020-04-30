<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>CreateExam</title>
<link rel="icon" href="images/logo.png">
<meta charset="utf-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap"
	rel="stylesheet">
 <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>

</head>

<style>
.btnsubmit {
	margin-bottom: 50px;
}

button:hover {
	background: #104a36 !important;
}
</style>

<body>
	<div class="container">
		<jsp:include page='header.jsp'>
			<jsp:param name="articleId" value="" />
		</jsp:include>

		<div class="createPostBlock">
			<div class="row">
				<!--<div class="col-md-12">
				 <label class="col-sm-12 createExam" for="mark">CREATEXAM</label>
			</div>-->
			</div>
			<form class="form-horizontal" id="createxam" action="examformurl" 
				method="post">
				<div class="form-group">
					<label class="control-label col-sm-5" for="examCode">Exam Code:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="exam_code"
							placeholder="Enter exam code" name="exam_code" >
							<!--  <span id="lblError" style="color: red;visibility:hidden">this field is required</span>-->
							
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="examname">ExamName
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="exam_name"
							id="exam_name" placeholder="Enter Exam Name" >
							<!--  <span id="lblError1" style="color: red;visibility:hidden">this field is required</span>-->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="enterexamdate">ExamDate
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
					
						<input type="date" class="form-control" id="exam_date"
							name="exam_date" placeholder="Enter Exam Date">
							
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="enterexamduration">ExamDuration
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
					<!-- <h5>(Ex:HH:MM:SS)</h5> -->
						<input type="text" class="form-control" name="duration" id="duration" placeholder="HH:MM:SS">
							<!--  <span id="lblError2" style="color: red;visibility:hidden">this field is required</span> -->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="marksforeachquestion">Marks
						for each Question :<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="marks_per_question" id="marks_per_question" placeholder="Enter Marks">
						<!--  <span id="lblError3" style="color: red;visibility:hidden">this field is required</span>-->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="nmarksforeachquestion">Negative Marks
						for each Question :<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="negativemarks_per_question" id="negativemarks_per_question" placeholder="Ex:0.33">
						<!--  <span id="lblError3" style="color: red;visibility:hidden">this field is required</span>-->
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost">Select post Name 
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						 <select class="form-control" name="post_name">
						<option value="">--Select Post --
							<c:forEach var="m" items="${value}">
							
								<option value="${m.post_name}">${m.post_name}</option>
							</c:forEach>
						</select> 
						<!-- <input type="text" class="form-control" name="post" id="post" >  -->
					</div>
				</div>
				<!-- <div class="form-group">
					<label class="control-label col-sm-5" for="description">Post Description
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="postdesc" id="postdesc" > 
								
					</div>
					</div> -->
					
					<div class="form-group">
					<label class="control-label col-sm-5" for="description">Exam Description
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="exam_description" id="exam_description" > 
								
					</div>
					</div>
				<div class="col-md-12">
					<div class="preBtn text-center">
						<button id="submit" type="submit" class="btn btn-primary mgn-top"
						 >Create Exam</button>
					</div>
				</div>
				</form>
				
			
			
		</div>
		<%--   <h4>${msg}</h4> --%>
		<!--Main dashboard end-->
		<div class="clearfix"></div>
		<div class="footer">
			<div class="row">
				<div class="col-md-6">
					<div class="footer-info"></div>

				</div>
				<div class="col-md-6 text-right">
					<div class="footer-info">
						<span>&copy; 2020 Timing Technologies India Pvt Ltd.</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Container end-->
	 <script type="text/javascript">

	$(document).ready(function() {
		$("#createxam").validate({
			rules : {
				exam_code : {
					required : true,
				},
				exam_name : {
					required : true,
				},
				exam_date : {
					required : true,
				},
				duration : {
					required : true,
				},
				marks_per_question : {
					required : true,
					minlength:1,
					maxlength : 4,
					number:true
				},
				negativemarks_per_question : {
					required : true,
					minlength :1,
					
					
				},
				post_name : {
					required : true,
				},
				
				
				exam_description :{
					required:true,
				}
			},
			submitHandler : function(from) {
				alert('data submitted successfully'); // for demo
				return true; // for demo
			}

		});
	});
</script>
</body>
</html>


	

