<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered successfully</title>
<link href="/Project/css/loginsucc.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/css?family=Play"rel="Stylesheet">
</head>
<body>

<script>
         setTimeout(function(){
            window.location.href = '/Project/Login.html';
         }, 10000);
      </script>
	<div class="cong">
		<form>
			<h2 style="color:white">Registered Successfully!!!</h2>
			<h4>Your system generated username is: ${object.username}</h4>
			<a href="#" style="text-decoration: none">Redirecting to Login in 10 second...</a>
			<br><br><br><br>
		</form>
	</div>
