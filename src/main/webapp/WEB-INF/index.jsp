<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>CBT AdminPanel login</title>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<style>
.error {
	color: red
}
</style>
</head>

<body>
	<div class="container">
		<div class="container">

			<nav class="navbar navbar-default">
				<div class="topNav">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><img src="../images/logo.png">
							<span>
								<h3>Online Admin Panel</h3>
						</span> </a>
					</div>
					<!--  <ul class="nav navbar-nav navbar-right">
                    <li><a href="/homeurl">HOME</a></li>
                </ul>-->
				</div>
			</nav>
			<div id="login">
				<div class="container">
					<div id="login-row"
						class="row justify-content-center align-items-center">
						<div id="login-column" class="col-md-offset-3 col-md-6">
							<div id="login-box" class="col-md-12">
								<form id="login-form" class="form" action="loginurl"
									method="post">

									<h3 class="text-center text-info">Login</h3>
									<div class="form-group">
										<h4 style="color: red;" align="center">
											<b>${msg}</b>
										</h4>
										<label for="username">Username</label><br>
										<input type="text" name="username" id="username"
											class="form-control">
											<span id="lblError1" style="color: red;visibility:hidden">This field is required</span>

									</div>
									<div class="form-group">
										<label for="password">Password</label><br>
										<input type="password" name="password" id="password"
											class="form-control">
											<span id="lblError2" style="color: red;visibility:hidden">This field is required</span>

									</div>
									<div class="form-group">
										<input id="submit" type="submit" name="submit"
											class="btn btn-info btn-md center-block" value="Login">
									</div>


								</form>
							</div>
						</div>
					</div>
				</div>
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
							<span>&copy; 2020 Timing Technologies India Pvt Ltd.</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Container end-->


	<script type="text/javascript">
	$(document).ready(function()
			{
		$("#submit").click(function(e)
		{
		
				  var a = $("#username").val();
				  var b = $("#password").val();
				  if(a==""||a==null)
				  {
				  $("#lblError1").css('visibility','visible');
				  return false;
				  }
				 
			  else if(b==""||b==null)
				  {
				  $("#lblError2").css('visibility','visible');
				  return false;
				  }
			  else
			  {
			  return true;
			  }
});
	  
		$("#username").keypress(function (e){
    		 var keyCode = e.keyCode || e.which;
    
    $("#lblError1").html("");

    //Regex for Valid Characters i.e. Alphabets.
    var regex = /^[A-Za-z]+$/;

    //Validate TextBox value against the Regex.
    var isValid = regex.test(String.fromCharCode(keyCode));
    if (!isValid) {
        $("#lblError1").html(" enetr Only Alphabets");
    }

    return isValid;
     });	
	  $("#password").keypress(function (e){
    		 var keyCode = e.keyCode || e.which;
    
    $("#lblError2").html("");

    //Regex for Valid Characters i.e. Alphabets.
    var regex = /^[A-Za-z0-9@$#%*&.:,_]+$/;

    //Validate TextBox value against the Regex.
    var isValid = regex.test(String.fromCharCode(keyCode));
    if (!isValid) {
        $("#lblError2").html(" enetr Only Alphabets");
    }

    return isValid;
     });	
			});
	
	</script>

</body>

</html>
