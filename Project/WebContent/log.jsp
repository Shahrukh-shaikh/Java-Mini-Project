<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
input[type=button] {
  border-radius: 4px;
  background-color: #828080;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 280px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  margin-top: 50px;
  margin-left: -20px;
}

input[type=button] span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

input[type=button] span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

input[type=button]:hover span {
  padding-right: 25px;
}

input[type=button]:hover span:after {
  opacity: 1;
  right: 0;
}
h2
{
	margin-top: 50px;
	margin-left: 10px;
}
h3
{
	color: #CFCDCD;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="/Project/css/loginsucc.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/css?family=Play"rel="Stylesheet">
</head>
<body>
<div class="cong">
		<form>
			<h2 style="color:white">Login Successfully!!!</h2>
			
			  <h3>Welcome: ${object.username}</h3>
			<a href="firstpage.html" style="text-decoration: none">Go back to Home Page</a>
			<br><br><br><br>
			<form>
<input type="button" value="Update" onclick="window.location.href='update.html'" />
</form>
		</form>
	</div>

</body>
</html>