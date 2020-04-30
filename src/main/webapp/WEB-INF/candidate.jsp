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
			<form class="form-horizontal" id="createxam" action="candidateurl"
				method="post">

				<div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost">
						Select Exam Name :<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<select class="form-control" name="exam_name">
							<option value="">--Select Exam Name --</option>
								<c:forEach var="m" items="${values}">

									<option value="${m.exam_name}">${m.exam_name}</option>
								</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost">
						Select Location Name :<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<select class="form-control" name="location_name">
							<option value="">--Select Exam Name --</option>
								<c:forEach var="m" items="${value}">

									<option value="${m.location_name}">${m.location_name}</option>
								</c:forEach>
						</select>
					</div>
				</div>
			 <div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost"> Select Location And Sessions
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<select class="form-control" name="exam_loc_session_id">
						<option value="">--Select Location And Session --
							<c:forEach var="m1" items="${value}">
							
								<option value="${m1.exam_loc_session_id}">${m1.location_name}(${m1.session_timings})</option>
							</c:forEach>
						</select>
					</div>
				</div>
 

				<!-- <div class="form-group">
					<label class="control-label col-sm-5" for="rollno">RollNO:<span
						style="color: red">*</span></label>
					<div class="col-sm-3">
						<input type="hidden" class="form-control" id="exam_loc_session_id"
							placeholder="Enter rollno" name="exam_loc_session_id">
						 <span id="lblError" style="color: red;visibility:hidden">this field is required</span>

					</div>
				</div> -->
				<div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost">
						Select Session Timings :<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<select class="form-control" name="session_timings">
							<option value="">--Select Location And Session --
								<c:forEach var="m1" items="${value}">

									<option value="${m1.session_timings}">${m1.session_timings}</option>
								</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="rollno">RollNO:<span
						style="color: red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="rollno"
							placeholder="Enter rollno" name="rollno">
						<!--  <span id="lblError" style="color: red;visibility:hidden">this field is required</span>-->

					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="fullname">FullName
						:<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="full_name"
							id="full_name" placeholder="select Full Name">
						<!--  <span id="lblError1" style="color: red;visibility:hidden">this field is required</span>-->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="fathername">FatherName
						:<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">

						<input type="text" class="form-control" id="father_name"
							name="father_name" placeholder="select Father name">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="enterexamduration">Gender
						:<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<select class="form-control" name="gender">
							<!-- <input type="text" class="form-control" name="gender" id="gender" placeholder="Select  Gender"> -->
							<option value="">--Select Gender--</option>
							<option value="male">MALE</option>
							<option value="female">FEMALE</option>
						</select>
						<!--  <span id="lblError2" style="color: red;visibility:hidden">this field is required</span> -->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="marksforeachquestion">Date
						Of Birth :<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<input type="date" class="form-control" name="dob" id="dob">
						<!--  <span id="lblError3" style="color: red;visibility:hidden">this field is required</span>-->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="nmarksforeachquestion">Category
						:<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<select class="form-control" name="category">
							<!-- <input type="text" class="form-control" name="gender" id="gender" placeholder="Select  Gender"> -->
							<option value="">--Select category--</option>
							<option value="oc">OC</option>
							<option value="sc">SC</option>
							<option value="st">ST</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="selectpost">Mobile
						NO :<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">

						<input type="text" class="form-control" name="mobile_no"
							id="mobile_no" placeholder="Select Mobile no">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="description">Email
						Id :<span style="color: red">*</span>
					</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="email_id"
							id="email_id" placeholder="Select Email Id">

					</div>
				</div>


				<div class="col-md-12">
					<div class="preBtn text-center">
						<button id="submit" type="submit" class="btn btn-primary mgn-top">Add</button>
					</div>
				</div>
			</form>



		</div>
		
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
					exam_name : {
						required : true,
					},
					location_name :{
						required : true,
					},
					exam_loc_session_id : {
						required : true,
					},
					session_timings:{
						required : true,
					},
					rollno : {
						required : true,
					},
					full_name : {
						required : true,
					},
					father_name : {
						required : true,

					},
					gender : {
						required : true,

					},
					dob : {
						required : true,
					},

					category : {
						required : true,
					},
					mobile_no : {
						required : true,
					},
					email_id : {
						required : true,
					}
				},
				submitHandler : function(from) {
					alert('Successfully added Candidate details'); // for demo
					return true; // for demo
				}

			});
		});
	</script>
</body>
</html>




