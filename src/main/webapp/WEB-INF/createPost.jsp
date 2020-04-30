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
			<form class="form-horizontal" id="createpost" action="redirectpost" 
				method="post">
<div class="form-group">
					<label class="control-label col-sm-5" for="postname">PostName:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="post_name"
							placeholder="Enter post name" name="post_name" >
							<!--  <span id="lblError" style="color: red;visibility:hidden">This field is required</span> -->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="description">Description:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="post_description"
							placeholder="Enter description" name="post_description" >
							<!-- <span id="lblError1" style="color: red;visibility:hidden">This field is required</span>-->
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="qualification">Post
						Qualification:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="post_qualifications"
							placeholder="Enter qualification" name="post_qualifications" >
								<!--<span id="lblError2" style="color: red;visibility:hidden">This field is required</span>--> 
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="vacancies">Vacancies:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="no_of_vacancies"
							placeholder="Enter vacancies" name="no_of_vacancies" required />
							
							<!--  <span id="lblError3" style="color:red;visibility:hidden">This field is required</span>-->
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button  id="submit" type="submit" class="btn btn-primary mgn-top">Submit</button>
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
			 <script type="text/javascript">
 $(document).ready(function() {
		$("#createpost").validate({
			rules : {
				post_name : {
					required : true,
				},
				post_description : {
					required : true,
				},
				post_qualifications : {
					required : true,
				},
				no_of_vacancies : {
					required : true,
					 minlength:1,
				     
				     digits: true
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
			