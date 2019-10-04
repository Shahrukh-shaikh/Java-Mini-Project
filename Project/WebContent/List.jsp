<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>CSV File</title>
<style>
body{
	background: url(tab.jpg);
	background-size: cover;


}
table {
  border-collapse: collapse;
  width: 80%;
  margin-left: 160px;
}

th, td {
  text-align: left;
  padding: 8px;
}
tr:hover {background-color: #f5f5f5;}

tr:nth-child(even){background-color: #E5F9FF}


th {
  background-color: #039BD1;
  color: white;
}
</style>
</head>
<body>

<h2>Details</h2>
<h3>${param.err }</h3>
<c:if test="${requestScope.list ==null }">
	<c:redirect url="servlet.htm"/>
</c:if>

<c:if test="${requestScope.list !=null }">
<table>
	<tr>
	<th>User ID</th>
	<th>User Name</th>
	<th>First name</th>
	<th>Last name</th>
	<th>Email</th>
	<th>Password(Encrypted)</th>
	</tr>
	<c:forEach items="${requestScope.list}" var="p">
	<tr>
	<td>${p.userid }</td>
	<td>${p.username }</td>
	<td>${p.fname }</td>
	<td>${p.lname }</td>
	<td>${p.email }</td>
	<td>${p.psw }</td>
	</tr>
	</c:forEach>
</table>
</c:if>

</body>
</html>
