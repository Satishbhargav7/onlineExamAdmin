<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.time.LocalDateTime"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="en">

<head>
<title>LocationSession</title>
<link rel="icon" href="images/logo.png">
<meta charset="utf-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">

<link href="css/font-awesome.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap"
	rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
</head>

<body>
	<div class="container">
		<jsp:include page='header.jsp'>
			<jsp:param name="articleId" value="" />
		</jsp:include>
		<form class="form-inline" id="locationsession" name="locationsession"
			action="createLocationSession" method="post">
			<div class="main-dashboard">
				<div class="text-center" style="padding-top: 30px;">
				
					<div class="form-group row">
						<label for="locationname">Location Name :<span
							style="color: red">*</span></label> <input type="text"
							class="form-control ct_formCtrl" id="location_name"
							placeholder="Enter location name" name="location_name">
						<!--   <span id="lblError1" style="color: red;visibility:hidden">This field is required</span>-->
					</div>
					<br /> <br />
					<div class="form-group row">
						<label for="address">Address :</label> <textarea 
							class="form-control ct_formCtrl" id="address"
							placeholder="Enter address" name="address"></textarea>
						<!-- <span id="lblError2" style="color: red;visibility:hidden">This field is required</span>-->
					</div>
				</div>
				<br><br>
				
				<div align="center">
				<div class="form-group row">
						<label for="examdate">ExamDate :</label> <input type="date"
							class="form-control ct_formCtrl" id="examdate"
							placeholder="Enter Examdate" name="examdate">
						<!-- <span id="lblError2" style="color: red;visibility:hidden">This field is required</span>-->
					</div>
				</div>
				
				<br><br>
				<div align="center">
				<div class="form-group row">
					<label class="control-label col-sm-5" for="selectpost">Select Post Name
						:<span style="color:red">*</span></label>
					<div class="col-sm-3">
						<select class="form-control" name=id>
						<option value="">--Select Post --
							<c:forEach var="m" items="${values}">
							
								<option value="${m.id}">${m.post_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				</div>
				<br /></br>
				<div class="ct_Width">
					<div>
						<div class="row text-center">
							<div class="col-md-6">
								<h5>Start Time(EX:8:00:00 AM)</h5>
							</div>
							<div class="col-md-6">
								<h5>End Time(EX:8:00:00 AM)</h5>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="Session">Session1 :</label> <input type="text"
							class="form-control ct_formCtrl" id="start_time" name="start_time"
							placeholder="Enter Session"> <input type="text"
							class="form-control ct_formCtrl" id="end_time"
							placeholder="Enter Session" name="end_time">
						<!--   <span id="lblError3" style="color: red;visibility:hidden">This field is required</span>-->
					</div>
					<!-- <div class="form-group">
						<label for="Session">Session2 :</label> <input type="text"
							class="form-control ct_formCtrl" id="start_time" name="start_time"
							placeholder="Enter Session"> <input type="text"
							class="form-control ct_formCtrl" id="end_time"
							placeholder="Enter Session" name="end_time">
						  <span id="lblError3" style="color: red;visibility:hidden">This field is required</span>
					</div> -->
					<br /></br> <br /></br>
				</div>
					<div><input type="hidden" name="date_created" value="<%=LocalDateTime.now()%>"></div>
			</div>
		
			
			<div class="col-md-12">
					<div class="preBtn text-center">
						<button id="submit" type="submit" class="btn btn-primary mgn-top"
						 >Create Location</button>
					</div>
				</div>

		</form>
<h4>${msg}</h4>
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
	<script>
		$(document).ready(function() {
			$("#locationsession").validate({
				rules : {
					location_name : {
						required : true,
					},
					address : {
						required : true,
					},
					examdate :{
						required :true,
					},
					id :{
						required: true,
					},
					start_time : {
						required : true,
					},
					end_time : {
						required : true,
					}
				},
				submitHandler : function(from) {
					//e.preventDefault();// for demo
					alert('Successfully Created ExamLocation With Sessition:)'); // for demo
					return true; // for demo
				}

			});
		});
	</script>

</body>
</html>


