<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Teacher</title>
</head>
<body>
<%@ include file="header.html" %> 
<center>
 	<a href="dashboard.jsp">DASHBOARD</a>
 	<br>
 	<br>
 	<a href="logoutservlet">LOGOUT</a>
 	
 	<h2>Add New Teacher</h2>
 	<form action="addteacher" method="get">
		<table border="1" cellpadding="10">
			<tr>
				<th>Teacher Name</th>
				<td><input type="text" name="teachername" required></td>
			</tr>
			<tr>
				<th>Teacher Email</th>
				<td><input type="email" name="teacheremail" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align : center"><input type="reset" value="Reset">&nbsp;&nbsp;
				<input type="submit" value="Add Teacher"></td>
			</tr>
		</table>
	</form>
</body>
</html>