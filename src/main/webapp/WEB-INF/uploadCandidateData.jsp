<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>CBT AdminPanel</title>
<link rel="icon" href="images/logo.png">
<meta charset="utf-8">

<link rel="stylesheet" href="css/style.css" type="text/css" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap"
	rel="stylesheet">
<meta charset="ISO-8859-1">

<script type="text/javascript">
	var _validFileExtensions = [ ".xls", ".xlsx" ];
	function Validate(oForm) {
		var arrInputs = oForm.getElementsByTagName("input");
		for (var i = 0; i < arrInputs.length; i++) {
			var oInput = arrInputs[i];
			if (oInput.type == "file") {
				var sFileName = oInput.value;
				if (sFileName.length > 0) {
					var blnValid = false;
					for (var j = 0; j < _validFileExtensions.length; j++) {
						var sCurExtension = _validFileExtensions[j];
						if (sFileName.substr(
								sFileName.length - sCurExtension.length,
								sCurExtension.length).toLowerCase() == sCurExtension
								.toLowerCase()) {
							blnValid = true;
							break;
						}
					}

					if (!blnValid) {
						alert("Sorry, " + sFileName
								+ " is invalid, allowed extensions are: "
								+ _validFileExtensions.join(", "));
						return false;
					}
				}
			}
		}

		return true;
	}
</script>

<style>
.adminBlock .row label {
	margin-bottom: 40px;
}

.adminBlock .row .mgn-left a {
	margin-bottom: 20px;
	width: 200px;
}

.adminBlock .row .mgn-left {
	text-align: left;
	margin-top: -3px;
}
</style>
<script>
	$(document).ready(function() {
		$("#btn1").click(function() {
			console.log(" i'm working fine");
			$("#sub-main1").load("createExam.jsp");

		});

		$('#btn2').click(function() {

			$('#sub-main1').load('exam_list.jsp');

		});

	});
</script>
</head>
<body>
	<div class="container">

		<jsp:include page='header.jsp'>
			<jsp:param name="articleId" value="" />
		</jsp:include>



		<form class="form-horizontal" id="upload" action="uploadcandidatedata"
			method="POST" enctype="multipart/form-data">
			<div class="adminBlock">
				<div class="form-group">
					<label class="control-label col-sm-5" for="selectpost">Select
						Exam Name:</label>
					<div class="col-sm-3">
						<select id="exam_name" class="form-control" name="exam_name">

							<option value="">Select ExamName</option>
							<c:forEach var="m" items="${values}">
								<option value="${m.exam_name}">${m.exam_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="selectpost">Select
					Location Name:</label>
				<div class="col-sm-3">
					<select id="location_name" class="form-control"
						name="location_name">
						<option value="">Select Location Name</option>
						<c:forEach var="m" items="${value}">
							<option value="${m.location_name}">${m.location_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<label class="control-label col-sm-5" for="selectpost">
					Select Sessions Timings :<span style="color: red">*</span>
				</label>
				<div class="col-sm-3">
					<select id="session_timings" class="form-control"
						name="session_timings">
						<option value="">--Select Location And Session --</option>
						<c:forEach var="m1" items="${value}">

							<option value="${m1.session_timings}">${m1.session_timings}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="adminBlock">
				<div class="row">
					<div class="col-md-6">
						<label class="control-label">Click to upload File:</label>
					</div>
					<div class="mgn-left">

						<input type="file" name="file" class="btn btn-primary"> <input
							type="submit" value="Upload">
					</div>

				</div>
			</div>

		</form>
	</div>

	<div class="footer">
		<div class="row">
			<div class="col-md-6">
				<div class="footer-info"></div>
			</div>
			<div class="col-md-6 text-right">
				<div class="footer-info">
					<span>&copy; 2020 Timing Technologies India Pvt Ltd </span>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#upload").validate({
				rules : {
					exam_name : {
						required : true,
					},
					location_name : {
						required : true,
					},

					session_timings : {
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